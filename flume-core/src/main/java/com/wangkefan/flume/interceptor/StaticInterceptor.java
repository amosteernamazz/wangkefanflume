package com.wangkefan.flume.interceptor;

import com.wangkefan.flume.Event;

import java.util.List;

public class StaticInterceptor implements Interceptor{
    @Override
    public void initialized() {

    }

    @Override
    public Event interceptor(Event event) {
        return null;
    }

    @Override
    public List<Event> interceptor(List<Event> events) {
        return null;
    }

    @Override
    public void close() {

    }

    public Interceptor Builder(){
        return new StaticInterceptor();
    }
}
