package com.renho.spring5code.configuration.myimport;

import com.renho.spring5code.myimport.MyImportBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: renho
 * @since: 1.0.0
 */
@Slf4j
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //AnnotationMetadata 当前标记@Import的类的所有注解信息
        //BeanDefinitionRegistry BeanDefinition的注册类 BeanDefinitionRegistry.registerBeanDefinition手动注册
        boolean hasImport = registry.containsBeanDefinition("com.renho.spring5code.myimport.MyImportBean");
        if (!hasImport) {
            BeanDefinition myImportBeanDefinition = new RootBeanDefinition(MyImportBean.class);
            registry.registerBeanDefinition("myImportBeanByMyImportBeanDefinitionRegistrar", myImportBeanDefinition);
        }
        log.info("renho");
    }
}
