package cn.myt.pojo;

import lombok.Data;

/**
 * @author mayating
 * @date 2021/10/18 9:42 上午
 */
@Data
public class ShiroUserPermission {

    private String username;
    private String role;
    private String permission;
}
