package com.wangkefan.flume.interceptor;

public enum InterceptorType {
    TIMESTAMP(com.wangkefan.flume.interceptor.TimestampInterceptor.Builder.class),
    HOST(com.wangkefan.flume.interceptor.HostInterceptor.Builder.class),
    STATIC(com.wangkefan.flume.interceptor.StaticInterceptor.Builder.class),
    REGEX_FILTER(com.wangkefan.flume.interceptor.RegexFilteringInterceptor.Builder.class),
    REGEX_EXTRACTOR(com.wangkefan.flume.interceptor.RegexExtractorInterceptor.Builder.class),
    REMOVE_HEADER(com.wangkefan.flume.interceptor.RemoveHeaderInterceptor.Builder.class),
    SEARCH_REPLACE(com.wangkefan.flume.interceptor.SearchAndReplaceInterceptor.Builder.class);


    private final Class<? extends Interceptor.Builder> builderClass;

    InterceptorType(Class<Interceptor.Builder> builderClass) {
        this.builderClass = builderClass;
    }

    public Class<? extends  Interceptor.Builder> getBuilderClass(){
        return builderClass;
    }
}
