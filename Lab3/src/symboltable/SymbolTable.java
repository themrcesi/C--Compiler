package symboltable;

import ast.definitions.Definition;
import java.util.*;

public class SymbolTable {
	
	private int scope=0;
	private List<Map<String, Definition>> table;

	public SymbolTable()  {
		table = new ArrayList<Map<String, Definition>>();
		table.add(new HashMap<String, Definition>());
	}

	public void set() {
		scope++;
		table.add(new HashMap<String, Definition>());
	}
	
	public void reset() {
		table.remove(scope);
		scope--;
	}
	
	public boolean insert(Definition definition) {
		definition.setScope(scope);
		if(!table.get(scope).containsKey(definition.getName()))
		{
			table.get(scope).put(definition.getName(), definition);
			return true;
		}
		return false;
	}
	
	public Definition find(String id) {
		for(int i = scope; i >= 0; i--)
		{
			if(table.get(i).containsKey(id))
				return table.get(i).get(id);
		}
		return null;
	}

	public Definition findInCurrentScope(String id) {
		if(table.get(scope).containsKey(id))
			return table.get(scope).get(id);
		return null;
	}
}
