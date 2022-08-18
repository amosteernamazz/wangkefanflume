package com.wangkefan.flume;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Context is a key-value store used to pass configuration information throughout the system.
 */
public class Context {
    private Map<String, String> parameters;

    public Context() {parameters = Collections.synchronizedMap(new HashMap<String, String>());    }

    public Context(Map<String, String> parameters) {
        this();
        this.putAll(parameters);
    }

    private void putAll(Map<String, String> parameters) {
        this.parameters.putAll(parameters);
    }

    public ImmutableMap<String, String> getParameters(){
        synchronized (parameters){
            return ImmutableMap.copyOf(parameters);
        }
    }

    public void clear(){
        this.parameters.clear();
    }

    public ImmutableMap<String, String> getSubProperties(String prefix){

        Preconditions.checkArgument(prefix.endsWith("."),"the given profix does not end with a period (" +prefix+ ")");
        Map<String, String>  result = Maps.newHashMap();

        synchronized (parameters){
            for (Map.Entry<String, String> stringStringEntry : parameters.entrySet()) {

                String key = stringStringEntry.getKey();
                if(key.startsWith(prefix)){
                    String substring = key.substring(prefix.length());
                    result.put(substring, stringStringEntry.getValue());
                }
            }
        }
        return ImmutableMap.copyOf(result);

    }

    public void put(String key, String value){
        parameters.put(key, value);
    }

    public boolean containsKey(String key){
        return parameters.containsKey(key);
    }

    private String get(String key, String defaultValue){
        String s = parameters.get(key);
        if(s != null){
            return s;
        }
        return defaultValue;
    }

    private String get(String key){
        return get(key, null);
    }

    public Boolean getBoolean(String key, Boolean defaultValue){
        String s = get(key);
        if(s != null){
            return Boolean.valueOf(Boolean.parseBoolean(s));
        }
        return defaultValue;
    }

    public Boolean getBoolean(String key){
        return getBoolean(key, null);
    }

    public Integer getInteger(String key, Integer defaultValue){
        String s = get(key);
        if(s != null){
            return Integer.valueOf(Integer.parseInt(s.trim()));
        }
        return defaultValue;
    }

    public Integer getInteger(String key){
        return getInteger(key, null);
    }

    public Long getLong(String key, Long defaultValue){
        String s = get(key);
        if(s != null){
            return Long.valueOf(Long.parseLong(s.trim()));
        }
        return defaultValue;
    }

    public Long getLong(String key){
        return getLong(key, null);
    }

    public String getString(String key, String defaultValue){
        return get(key, defaultValue);
    }

    public String getString(String key){
        return get(key);
    }

    public Float getFloat(String key, Float defaultValue){
        String s = get(key);
        if(s !=null){
            return Float.valueOf(s.trim());
        }
        return defaultValue;
    }

    public Float getFloat(String key){
        return getFloat(key, null);
    }

    public Double getDouble(String key){
        return getDouble(key, null);
    }

    public Double getDouble(String key, Double defaultValue){
        String s = get(key);
        if(s != null){
            return Double.valueOf(s.trim());
        }
        return defaultValue;
    }

    @Override
    public String toString() {
        return
                "{ parameters=" + parameters +
                " }";
    }
}
