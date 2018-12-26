package com.renho.spring5code.configuration.condition;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.stream.Stream;


/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Slf4j
public class MyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        context.getEnvironment();
        Stream.of(context.getRegistry().getBeanDefinitionNames()).forEach(log::info);
        return true;
    }
}
