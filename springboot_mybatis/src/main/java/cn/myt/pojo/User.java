package cn.myt.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mayating
 * @date 2021/10/10 9:51 下午
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
