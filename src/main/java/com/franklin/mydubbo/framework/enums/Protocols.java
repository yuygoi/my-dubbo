package com.franklin.mydubbo.framework.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Kirby
 * @date 2019/9/7 0007 15:55
 */
@AllArgsConstructor
public enum Protocols {

    Http("http"),
    Dubbo("dubbo");

    private String value;

    public String value(){
        return this.value;
    }
}
