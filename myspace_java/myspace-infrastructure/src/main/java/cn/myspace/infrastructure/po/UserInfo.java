package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * (UserInfo)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -64489534687101333L;

    private Long userId;
    /**
     * 真实姓名
     */
    private String name;

    private Integer age;
    /**
     * 国家
     */
    private String country;
    /**
     * 地址
     */
    private String address;
    /**
     * 擅长菜系
     */
    private String recipes;
    /**
     * 个人简介
     */
    private String intro;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志
     */
    private Integer deleteMark;
}