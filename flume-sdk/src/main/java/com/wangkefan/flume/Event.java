package com.wangkefan.flume;

import java.util.Map;


/**
 * Basic representation of a data object in Flume
 */
public interface Event {

    public Map<String, String>  getHeaders();

    public void setHeaders(Map<String, String> headers);

    public byte[] getBody();

    public void setBody(byte[] body);

}
