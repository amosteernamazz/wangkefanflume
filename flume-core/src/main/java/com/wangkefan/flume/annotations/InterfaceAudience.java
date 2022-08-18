package com.wangkefan.flume.annotations;

import java.lang.annotation.Documented;

@InterfaceAudience.Public
@InterfaceStability.Evolving
public class InterfaceAudience {


    @Documented public @interface Public{};

    @Documented public @interface LimitedPrivate{
        String[] value();
    }

    @Documented public @interface Private{};

    private InterfaceAudience(){}
}
