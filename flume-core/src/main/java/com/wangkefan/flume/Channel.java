package com.wangkefan.flume;

import com.wangkefan.flume.annotations.InterfaceAudience;
import com.wangkefan.flume.annotations.InterfaceStability;
import com.wangkefan.flume.lifecycle.LifecycleAware;


@InterfaceAudience.Public
@InterfaceStability.Stable
public interface Channel extends LifecycleAware, NamedComponent {

    public void put (Event event) throws  ChannelException;

    public Event take() throws ChannelException;

    public Transaction getTransaction();

}
