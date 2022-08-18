package com.wangkefan.flume.interceptor;

import com.google.common.collect.Lists;
import com.wangkefan.flume.Event;

import java.util.ArrayList;
import java.util.List;

public class InterceptorChain implements Interceptor{

    private List<Interceptor> interceptors;

    public InterceptorChain(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
    }
    public InterceptorChain() {interceptors = Lists.newLinkedList();
    }

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
    public void setInterceptors(List <Interceptor> interceptors) {
        this.interceptors = interceptors;
    }
}
