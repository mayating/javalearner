package cn.myt.demo.pharse2.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mayating
 * @date 2021/10/4 12:16 下午
 */
@Data
@TableName("userRole")
public class UserRole implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String username;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer roleCode;

}