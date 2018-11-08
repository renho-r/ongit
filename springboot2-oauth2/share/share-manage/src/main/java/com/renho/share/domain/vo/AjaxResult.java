package com.renho.share.domain.vo;

/**
 * @author: renho
 * @since: 1.0.0
 */
public class AjaxResult {

    private String code;
    private String msg;

    public AjaxResult() {}

    public AjaxResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
