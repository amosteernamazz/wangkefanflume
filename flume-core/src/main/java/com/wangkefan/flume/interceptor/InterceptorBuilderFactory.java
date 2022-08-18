package com.wangkefan.flume.interceptor;

import com.wangkefan.flume.interceptor.Interceptor.Builder;

import java.util.Locale;

public class InterceptorBuilderFactory {

    private static Class <? extends Builder> lookup(String name){
        try {
            return InterceptorType.valueOf(name.toUpperCase(Locale.ENGLISH)).getBuilderClass();
        }catch(IllegalArgumentException e){
            return null;
        }
    }


    public static Builder newInstance(String name) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<? extends Builder> lookup = lookup(name);
        if(lookup == null){
            lookup = (Class<? extends Builder>) Class.forName(name);
        }
        return lookup.newInstance();
    }
}
