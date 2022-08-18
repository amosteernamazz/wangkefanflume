package com.wangkefan.flume.channel;

import com.wangkefan.flume.Context;
import com.wangkefan.flume.FlumeException;
import com.wangkefan.flume.conf.Configurable;
import com.wangkefan.flume.interceptor.Interceptor;
import com.google.common.collect.Lists;
import com.wangkefan.flume.interceptor.InterceptorBuilderFactory;
import com.wangkefan.flume.interceptor.InterceptorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ChannelProcessor implements Configurable {

    private static final Logger LOG = LoggerFactory.getLogger(ChannelProcessor.class);

    private final InterceptorChain interceptorChain;

    public ChannelProcessor() {
        interceptorChain = new InterceptorChain();
    }

    @Override
    public void configure(Context context) {
        configureInterceptors(context);
    }

    private void configureInterceptors(Context context) {

        List <Interceptor> interceptors = Lists.newLinkedList();

        String interceptorsListStr = context.getString("interceptors", "");
        if(interceptorsListStr.isEmpty()){
            return;
        }
        String[] interceptorsNames = interceptorsListStr.split("\\s+");

        Context interceptorContexts = new Context(context.getSubProperties("interceptors."));

        InterceptorBuilderFactory interceptorBuilderFactory = new InterceptorBuilderFactory();

        for (String interceptorsName : interceptorsNames) {

            Context interceptorContext = new Context(interceptorContexts.getSubProperties(interceptorsName + "."));
            String type = interceptorContext.getString("type");
            if(type == null){
                LOG.error("Type not specified for interceptor " + interceptorsName);
                throw new FlumeException("Interceptor.Type not specified for " + interceptorsName);
            }
                try {
                    Interceptor.Builder builder = interceptorBuilderFactory.newInstance(type);

                    builder.configure(interceptorContext);
                    interceptors.add(builder.build());
                } catch (ClassNotFoundException e) {
                    LOG.error("Builder class not found. Exception follows. ", e);
                    throw new FlumeException("Interceptor.Builder not found. ", e);
                }catch (InstantiationException e) {
                    LOG.error("Could not instantiate builder class. Exception follow. ", e);
                    throw new FlumeException("Instantiate builder class failed. ", e);
                } catch (IllegalAccessException e) {
                    LOG.error("Unable to access Builder. Exception follow. ", e);
                    throw new FlumeException("Unable to access Builder. Exception follow. ", e);
                }

            interceptorChain.setInterceptors(interceptors);
        }
    }
}
