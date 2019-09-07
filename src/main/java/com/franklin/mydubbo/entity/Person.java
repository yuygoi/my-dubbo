package com.franklin.mydubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Kirby
 * @date 2019/9/7 0007 16:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{

    private Integer id;

    private String name;

    private Integer age;
}
