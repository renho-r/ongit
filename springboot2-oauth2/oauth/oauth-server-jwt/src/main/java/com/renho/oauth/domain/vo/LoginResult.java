package com.renho.oauth.domain.vo;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class LoginResult extends AjaxResult {

    public LoginResult() {}

    public LoginResult(String code, String msg) {
        super(code, msg);
    }

}
