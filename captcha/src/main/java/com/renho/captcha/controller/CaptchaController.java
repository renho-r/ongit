package com.renho.captcha.controller;

import com.google.common.cache.Cache;
import com.wf.captcha.SpecCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author renho
 * @date 2021/2/23
 */
@Controller
public class CaptchaController {

    @Autowired
    private Cache<String, String> captchaCache;

    @ResponseBody
    @RequestMapping("/captcha")
    public Map<String, String> captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48, 4);
        String verCode = specCaptcha.text().toLowerCase();
        String key = UUID.randomUUID().toString();
        captchaCache.put(key, verCode);
        Map<String, String> result = new HashMap<>(8);
        result.put("key", key);
        result.put("image", specCaptcha.toBase64());
        return result;
    }

    @ResponseBody
    @PostMapping("/captchavalidate")
    public Map<String, String> validate(String verCode, String verKey){
        Map<String, String> result = new HashMap<>(8);
        if (!StringUtils.hasLength(verCode) || !StringUtils.hasLength(verKey)) {
            result.put("code", "fail");
            result.put("msg", "verCode或verKey不能为空!");
            return result;
        }
        String captchaCode = captchaCache.getIfPresent(verKey);
        if (!StringUtils.hasLength(captchaCode)) {
            result.put("code", "fail");
            result.put("msg", "验证码已失效！");
            return result;
        }
        if (!captchaCode.equals(verCode.trim().toLowerCase())) {
            result.put("code", "fail");
            result.put("msg", "verCode错误!");
            return result;
        }
        captchaCache.invalidate(verKey);
        result.put("code", "success");
        return result;
    }
}
