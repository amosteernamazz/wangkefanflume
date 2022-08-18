package com.wangkefan.flume;

/**
 * Channel exception is raised whenever a channel operation failed.
 */
public class ChannelException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ChannelException(String message) {
        super(message);
    }

    public ChannelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChannelException(Throwable cause) {
        super(cause);
    }
}
