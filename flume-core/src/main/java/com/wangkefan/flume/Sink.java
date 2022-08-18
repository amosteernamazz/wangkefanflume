package com.wangkefan.flume;

import com.wangkefan.flume.annotations.InterfaceAudience;
import com.wangkefan.flume.annotations.InterfaceStability;
import com.wangkefan.flume.lifecycle.LifecycleAware;

@InterfaceAudience.Public
@InterfaceStability.Stable
public interface Sink extends LifecycleAware, NamedComponent {

    public void setChannel(Channel channel);

    public Channel getChannel();

    public Status process() throws  EventDeliveryException;

    public static enum Status{
        READY,BACKOFF
    }

}
