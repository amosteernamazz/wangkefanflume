package com.wangkefan.flume;

/**
 * Basic class of all flume exceptions.
 */
public class FlumeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FlumeException(String msg){super(msg);}

    public FlumeException(String msg, Throwable throwable){super(msg,throwable);}

    public FlumeException(Throwable throwable){super(throwable);}

}
