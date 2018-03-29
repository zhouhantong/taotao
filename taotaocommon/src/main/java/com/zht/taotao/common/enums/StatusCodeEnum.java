package com.zht.taotao.common.enums;

/**
 * Created by zhouhantong on 2018/3/29.
 *
 * @author 周寒通
 */
public enum StatusCodeEnum {
    /**操作成功*/
    SUCCESS(200,"成功"),
    /**操作失败*/
    ERROR(500,"失败");
    int code;
    String name;
    private StatusCodeEnum(int code, String name){
        this.code=code;
        this.name=name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
