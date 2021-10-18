package cn.myt.pojo;

import lombok.Data;

/**
 * @author mayating
 * @date 2021/10/17 10:37 下午
 */
@Data
public class ShiroUser {

    private Integer id;
    private String username;
    private String password;
    private String salt;

}
