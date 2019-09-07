package com.franklin.mydubbo.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Kirby
 * @date 2019/9/7 0007 11:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invocation implements Serializable{

    private String interfaceName;
    private String methodName;
    private Object[] params;
    private Class[] paramTypes;
}
