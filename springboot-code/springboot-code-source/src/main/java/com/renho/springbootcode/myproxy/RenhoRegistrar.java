package com.renho.springbootcode.myproxy;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.ClassPathMapperScanner;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author renho
 * @date 2020/11/25
 */
public class RenhoRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(RenhoProxy.class.getName()));
        MyClassPathBeanDefinitionScanner scanner = new MyClassPathBeanDefinitionScanner(registry);
        List<String> basePackages = new ArrayList<String>();
        for (String pkg : annoAttrs.getStringArray("value")) {
            basePackages.add(pkg);
        }
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
        scanner.doScan(StringUtils.toStringArray(basePackages));
    }

    private class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {

        public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry) {
            super(registry);
        }

        @Override
        protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
            Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
            process(beanDefinitions);
            return beanDefinitions;
        }

        @Override
        protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
            return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
        }

        private void process(Set<BeanDefinitionHolder> beanDefinitions) {
            beanDefinitions.forEach(System.out::println);
            beanDefinitions.forEach(holder -> {
                GenericBeanDefinition definition = (GenericBeanDefinition) holder.getBeanDefinition();
                definition.getConstructorArgumentValues().addGenericArgumentValue(definition.getBeanClassName());
                definition.setBeanClass(RenhoFactoryBean.class);
            });
        }
    }
}
