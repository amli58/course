package com.course.server.enums;

public enum StuSexEnum {
    CHARGE("B", "男"),
    FREE("G", "女");

    private String code;

    private String desc;

    StuSexEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
