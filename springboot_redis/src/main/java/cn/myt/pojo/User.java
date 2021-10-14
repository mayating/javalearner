package cn.myt.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mayating
 * @date 2021/10/13 2:46 下午
 */
@Data
public class User implements Serializable {

    private String id;
    private String name;
    private String email;
}
