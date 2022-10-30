package cn.myspace.common.exception;

/**
 * @author HaoHao
 * Created on 2022-10-30.
 */
public class DatabaseOperationException extends Exception{

    public DatabaseOperationException(){
        super();
    }

    public DatabaseOperationException(String message){
        super(message);
    }

    public DatabaseOperationException(String message, Throwable cause){
        super(message,cause);
    }
}
