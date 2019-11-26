package com.renho.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.access.ConfigAttribute;

import javax.servlet.http.HttpServletRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyConfigAttribute implements ConfigAttribute {

    private static final long serialVersionUID = -9077500518767298788L;

    HttpServletRequest request;

    @Override
    public String getAttribute() {
        return request.getRequestURI();
    }

}
