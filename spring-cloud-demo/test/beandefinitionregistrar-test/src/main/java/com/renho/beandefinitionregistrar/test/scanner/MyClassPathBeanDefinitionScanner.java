package com.renho.beandefinitionregistrar.test.scanner;

import com.renho.beandefinitionregistrar.test.annotation.Mapper;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
//@Slf4j
public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
        super(registry, useDefaultFilters);
    }

    public void registerFilters() {
        addIncludeFilter(new AnnotationTypeFilter(Mapper.class));
    }

    @Override
    public Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
