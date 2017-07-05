package com.renho.jersey.dynamicbinding;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class CompressionDynamicBinding implements DynamicFeature {
	 
    @Override
    public void configure(ResourceInfo resourceInfo, FeatureContext context) {
        if (HelloWorldResource.class.equals(resourceInfo.getResourceClass()) && resourceInfo.getResourceMethod().getName().contains("VeryLongString")) {
            context.register(GZIPWriterInterceptor.class);
        }
    }
}
