package cn.myt.demo.pharse2.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mayating
 * @date 2021/10/4 12:12 下午
 */
@Data
@TableName("user")
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String name;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer age;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String email;

    @TableField(exist = false)
    private Set<Role> roles = new HashSet<>();

}