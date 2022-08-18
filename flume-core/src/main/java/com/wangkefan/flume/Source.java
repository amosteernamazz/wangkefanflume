package com.wangkefan.flume;

import com.wangkefan.flume.annotations.InterfaceAudience;
import com.wangkefan.flume.annotations.InterfaceStability;
import com.wangkefan.flume.channel.ChannelProcessor;
import com.wangkefan.flume.lifecycle.LifecycleAware;

@InterfaceStability.Stable
@InterfaceAudience.Public
public interface Source extends LifecycleAware, NamedComponent {

    public void setChannelProcessor(ChannelProcessor channelProcessor);

    public ChannelProcessor getChannelProcessor();
}
