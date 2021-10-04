package cn.myt.demo.pharse2.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mayating
 * @date 2021/10/4 12:15 下午
 */
@Data
@TableName("permission")
public class Permission implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String permissionCode;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String permissionName;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String path;

}