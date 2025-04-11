package com.entity.vo;

import com.entity.FaxingfangEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 发行方
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("faxingfang")
public class FaxingfangVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 发行方姓名
     */

    @TableField(value = "faxingfang_name")
    private String faxingfangName;


    /**
     * 图片
     */

    @TableField(value = "faxingfang_photo")
    private String faxingfangPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 联系方式
     */

    @TableField(value = "faxingfang_phone")
    private String faxingfangPhone;


    /**
     * 邮箱
     */

    @TableField(value = "faxingfang_email")
    private String faxingfangEmail;


    /**
     * 假删
     */

    @TableField(value = "faxingfang_delete")
    private Integer faxingfangDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：发行方姓名
	 */
    public String getFaxingfangName() {
        return faxingfangName;
    }


    /**
	 * 获取：发行方姓名
	 */

    public void setFaxingfangName(String faxingfangName) {
        this.faxingfangName = faxingfangName;
    }
    /**
	 * 设置：图片
	 */
    public String getFaxingfangPhoto() {
        return faxingfangPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setFaxingfangPhoto(String faxingfangPhoto) {
        this.faxingfangPhoto = faxingfangPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：联系方式
	 */
    public String getFaxingfangPhone() {
        return faxingfangPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setFaxingfangPhone(String faxingfangPhone) {
        this.faxingfangPhone = faxingfangPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getFaxingfangEmail() {
        return faxingfangEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setFaxingfangEmail(String faxingfangEmail) {
        this.faxingfangEmail = faxingfangEmail;
    }
    /**
	 * 设置：假删
	 */
    public Integer getFaxingfangDelete() {
        return faxingfangDelete;
    }


    /**
	 * 获取：假删
	 */

    public void setFaxingfangDelete(Integer faxingfangDelete) {
        this.faxingfangDelete = faxingfangDelete;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
