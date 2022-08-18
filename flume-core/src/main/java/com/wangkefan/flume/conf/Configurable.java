package com.wangkefan.flume.conf;

import com.wangkefan.flume.Context;
import com.wangkefan.flume.annotations.InterfaceAudience;
import com.wangkefan.flume.annotations.InterfaceStability;

@InterfaceAudience.Public
@InterfaceStability.Stable
public interface Configurable {

    public void configure(Context context);
}
