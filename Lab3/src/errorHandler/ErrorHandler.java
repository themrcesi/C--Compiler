package errorHandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private ErrorHandler handler;
    private List<ErrorType> errors = new ArrayList<ErrorType>();

    public ErrorHandler getInstanceOf()
    {
        if(this.handler==null) this.handler = new ErrorHandler();
        return this.handler;
    }

    public void addError(ErrorType error)
    {
        this.errors.add(error);
    }

    public boolean anyError()
    {
        return !this.errors.isEmpty();
    }

    public void showErrors(PrintStream ps)
    {
        errors.forEach(errorType -> ps.println(errorType.toString()));
    }
}
