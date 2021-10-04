package cn.myt.demo.pharse2.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mayating
 * @date 2021/10/4 12:18 下午
 */
@Data
@TableName("rolePermission")
public class RolePermission implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer roleCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String permissionCode;

}
