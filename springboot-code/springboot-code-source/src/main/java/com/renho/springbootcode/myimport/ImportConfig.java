package com.renho.springbootcode.myimport;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@Component
@Import(MyImportBean.class)
public class ImportConfig {
}
