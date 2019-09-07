package com.franklin.mydubbo.framework;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Kirby
 * @date 2019/9/7 0007 11:07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class URL implements Serializable{

    private String hostName;
    private Integer port;
}
