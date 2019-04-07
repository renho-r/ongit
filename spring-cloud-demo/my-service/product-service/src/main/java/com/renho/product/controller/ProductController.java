package com.renho.product.controller;

import com.renho.vo.ProductVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * @author: renho
 * @since: 1.0.0
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/info/{name}")
    public ProductVo info(@PathVariable String name, HttpServletRequest request) {

        ProductVo productVo = new ProductVo();
        productVo.setId((new Random()).nextLong());
        productVo.setName(name);
        productVo.setInfo("product:port: " + request.getLocalPort());
        return productVo;
    }

}
