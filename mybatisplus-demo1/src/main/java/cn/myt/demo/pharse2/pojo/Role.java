package cn.myt.demo.pharse2.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mayating
 * @date 2021/10/4 12:13 下午
 */
@Data
@TableName("role")
public class Role implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String roleCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String roleName;

    @TableField(exist = false)
    private Set<Permission> permissions = new HashSet<>();

}
