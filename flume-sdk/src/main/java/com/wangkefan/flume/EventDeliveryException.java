package com.wangkefan.flume;


/**
 * An event delivery exception is raised whenever an{@link Event} fails to reach  at least one of its intended destinations
 */
public class EventDeliveryException extends Exception{

    private static final long serialVersionUID = 1102327497549834945L;

    public EventDeliveryException(){super();}

    public EventDeliveryException(String string){super(string);}

    public EventDeliveryException(String string, Throwable throwable){super(string,throwable);}

    public EventDeliveryException(Throwable throwable){super(throwable);}

}
