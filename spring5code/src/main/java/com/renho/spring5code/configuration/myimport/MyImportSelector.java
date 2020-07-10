package com.renho.spring5code.configuration.myimport;

import com.renho.spring5code.myimport.MyImportBean;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //AnnotationMetadata 当前标记@Import的类的所有注解信息
        return new String[]{"com.renho.spring5code.myimport.MyImportBean"};
    }
}
