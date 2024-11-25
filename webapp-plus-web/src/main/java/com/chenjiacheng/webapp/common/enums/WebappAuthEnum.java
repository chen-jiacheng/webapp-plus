package com.chenjiacheng.webapp.common.enums;

/**
 * Created by chenjiacheng on 2024/11/25 23:57
 *
 * @author chenjiacheng
 * @since 1.0.0
 */
public enum WebappAuthEnum {
    USER_PERMS("USER","用户"),
    ADMIN_PERMS("ADMIN","管理员"),
    ;
    private String code;
    private String desc;

    WebappAuthEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
