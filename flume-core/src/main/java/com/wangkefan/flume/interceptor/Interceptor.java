package com.wangkefan.flume.interceptor;

import com.wangkefan.flume.Event;
import com.wangkefan.flume.annotations.InterfaceAudience;
import com.wangkefan.flume.annotations.InterfaceStability;
import com.wangkefan.flume.conf.Configurable;

import java.util.List;

@InterfaceAudience.Public
@InterfaceStability.Stable
public interface Interceptor {

    public void initialized();

    public Event interceptor(Event event);

    public List<Event> interceptor(List<Event> events);

    public void close();

    public interface Builder extends Configurable{
        public Interceptor build();
    }

}
