package errorHandler;

import ast.types.ErrorType;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ErrorHandler {

    private static ErrorHandler handler;
    private List<ErrorType> errors;

    public static ErrorHandler getInstanceOf()
    {
        if(handler==null) handler = new ErrorHandler();
        return handler;
    }

    private ErrorHandler()
    {
        this.errors = new ArrayList<ErrorType>();
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
