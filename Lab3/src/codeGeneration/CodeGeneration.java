package codeGeneration;

import ast.types.Type;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class CodeGeneration {

    private String input;
    private String output;
    private PrintStream ps;
    private int labels;

    public CodeGeneration(String input, String output) throws FileNotFoundException {
        this.input = input;
        this.output = output;
        this.ps = new PrintStream(new FileOutputStream((this.output)));
    }

    //######################################PUSH#####################################

    public void pushbp() {
        ps.println("\tpush bp");
    }

    public void pusha(int offset) {
        ps.println("\tpusha "+offset);
    }

    public void push(Type type, int value) {
        ps.println("\tpush"+type.suffix()+" "+value);
    }

    public void push(Type type, double value) {
        ps.println("\tpush"+type.suffix()+" "+value);
    }

    public void pushi(int numberOfBytes) {
        ps.println("\tpushi "+numberOfBytes);
    }

    public void pop(Type type) {
        ps.println("\tpop"+type.suffix());
    }

    //###################################ADD###########################################

    public void addi() {
        ps.println("\taddi");
    }

    //################################LOAD###############################################
    public void store(Type type) {
        ps.println("\tstore"+type.suffix());
    }

    //######################################LOAD#######################################

    public void load(Type type) {
        ps.println("\tload"+type.suffix());
    }

    //##################################CAST############################################

    public void convertTo(Type type, Type type1) {
        if (type.suffix().equals("b"))
        {
            if (type1.suffix().equals("i"))
            {
                ps.println("\tb2i");
            } else if (type1.suffix().equals("f"))
            {
                ps.println("\tb2i");
                ps.println("\ti2f");
            }
        } else if (type.suffix().equals("i"))
        {
            if (type1.suffix().equals("b"))
            {
                ps.println("\ti2b");
            } else if (type1.suffix().equals("f"))
            {
                ps.println("\ti2f");
            }
        } else if (type.suffix().equals("f"))
        {
            if (type1.suffix().equals("i"))
            {
                ps.println("\tf2i");
            } else if (type1.suffix().equals("b"))
            {
                ps.println("\tf2i");
                ps.println("\ti2b");
            }
        }
    }

    //###################################ARITHMETIC####################################3
    public void arithmetic(String operator, Type type) {
        switch (operator)
        {
            case "+":
                ps.println("\tadd"+type.suffix());
                break;
            case "-":
                ps.println("\tsub"+type.suffix());
                break;
            case "*":
                ps.println("\tmul"+type.suffix());
                break;
            case "/":
                ps.println("\tdiv"+type.suffix());
                break;
            case "%":
                ps.println("\tmod"+type.suffix());
                break;
        }
    }

    public void muli() {
        ps.println("\tmuli");
    }

    //#################################COMPARISSON##################################
    public void comparisson(String operand, Type type) {
        switch (operand) {
            case ">":
                ps.println("\tgt" + type.suffix());
                break;
            case "<":
                ps.println("\tlt" + type.suffix());
                break;
            case "==":
                ps.println("\teq" + type.suffix());
                break;
            case "<=":
                ps.println("\tle" + type.suffix());
                break;
            case ">=":
                ps.println("\tge" + type.suffix());
                break;
            case "!=":
                ps.println("\tne" + type.suffix());
                break;
        }
    }

    //###############################3LOGICAL#########################################
    public void logical(String operand) {
        if (operand.equals("&&")) {
            ps.println("\tand");
        } else if (operand.equals("||")) {
            ps.println("\tor");
        }
    }

    //######################################COMMENT#######################################
    public void printComment(String s) {
        ps.println(s);
    }

    //##############################IN#################################################
    public void in(Type type) {
        ps.println("\tin"+type.suffix());
    }

    //#####################################OUT#######################################33
    public void out(Type type) {
        ps.println("\tout"+type.suffix());
    }

    public void enter(int byteLocals) {
        ps.println("\tenter "+byteLocals);
    }

    public void line(int line) {
        ps.println("#line\t"+line);
    }

    public void ret(int bytesReturn, int byteLocals, int byteParams) {
        ps.println("\tret "+bytesReturn+","+byteLocals+","+byteParams);
    }

    public void source() {
        ps.println("#source\t\""+input+"\"");
    }

    public void call(String main) {
        ps.println("call "+main);
    }

    public void halt() {
        ps.println("halt");
    }

    public void not() {
        ps.println("\tnot");
    }

    public void sub(Type type) {
        ps.print("\tsub"+type.suffix());
    }


    public int getLabels(int i) {
        var returned = labels;
        labels += i;
        return returned;
    }

    public void jz(int labelNumber) {
        ps.println("\tjz label"+labelNumber);
    }

    public void jmp(int i) {
        ps.println("\tjmp label"+i);
    }

    public void label(int labelNumber) {
        ps.println(" label"+labelNumber+":");
    }
}
