package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 杂志信息
 *
 * @author 
 * @email
 */
@TableName("zazhixinxi")
public class ZazhixinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZazhixinxiEntity() {

	}

	public ZazhixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 杂志标题
     */
    @TableField(value = "zazhixinxi_name")

    private String zazhixinxiName;


    /**
     * 杂志类型
     */
    @TableField(value = "zazhixinxi_types")

    private Integer zazhixinxiTypes;


    /**
     * 杂志图片
     */
    @TableField(value = "zazhixinxi_photo")

    private String zazhixinxiPhoto;


    /**
     * 杂志下载
     */
    @TableField(value = "zazhixinxi_file")

    private String zazhixinxiFile;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 价格
     */
    @TableField(value = "zazhixinxi_new_money")

    private Double zazhixinxiNewMoney;


    /**
     * 杂志详情
     */
    @TableField(value = "zazhixinxi_content")

    private String zazhixinxiContent;


    /**
     * 审核状态
     */
    @TableField(value = "zazhixinxi_yesno_types")

    private Integer zazhixinxiYesnoTypes;


    /**
     * 审核原因
     */
    @TableField(value = "zazhixinxi_yesno_text")

    private String zazhixinxiYesnoText;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：杂志标题
	 */
    public String getZazhixinxiName() {
        return zazhixinxiName;
    }


    /**
	 * 获取：杂志标题
	 */

    public void setZazhixinxiName(String zazhixinxiName) {
        this.zazhixinxiName = zazhixinxiName;
    }
    /**
	 * 设置：杂志类型
	 */
    public Integer getZazhixinxiTypes() {
        return zazhixinxiTypes;
    }


    /**
	 * 获取：杂志类型
	 */

    public void setZazhixinxiTypes(Integer zazhixinxiTypes) {
        this.zazhixinxiTypes = zazhixinxiTypes;
    }
    /**
	 * 设置：杂志图片
	 */
    public String getZazhixinxiPhoto() {
        return zazhixinxiPhoto;
    }


    /**
	 * 获取：杂志图片
	 */

    public void setZazhixinxiPhoto(String zazhixinxiPhoto) {
        this.zazhixinxiPhoto = zazhixinxiPhoto;
    }
    /**
	 * 设置：杂志下载
	 */
    public String getZazhixinxiFile() {
        return zazhixinxiFile;
    }


    /**
	 * 获取：杂志下载
	 */

    public void setZazhixinxiFile(String zazhixinxiFile) {
        this.zazhixinxiFile = zazhixinxiFile;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：价格
	 */
    public Double getZazhixinxiNewMoney() {
        return zazhixinxiNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setZazhixinxiNewMoney(Double zazhixinxiNewMoney) {
        this.zazhixinxiNewMoney = zazhixinxiNewMoney;
    }
    /**
	 * 设置：杂志详情
	 */
    public String getZazhixinxiContent() {
        return zazhixinxiContent;
    }


    /**
	 * 获取：杂志详情
	 */

    public void setZazhixinxiContent(String zazhixinxiContent) {
        this.zazhixinxiContent = zazhixinxiContent;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getZazhixinxiYesnoTypes() {
        return zazhixinxiYesnoTypes;
    }


    /**
	 * 获取：审核状态
	 */

    public void setZazhixinxiYesnoTypes(Integer zazhixinxiYesnoTypes) {
        this.zazhixinxiYesnoTypes = zazhixinxiYesnoTypes;
    }
    /**
	 * 设置：审核原因
	 */
    public String getZazhixinxiYesnoText() {
        return zazhixinxiYesnoText;
    }


    /**
	 * 获取：审核原因
	 */

    public void setZazhixinxiYesnoText(String zazhixinxiYesnoText) {
        this.zazhixinxiYesnoText = zazhixinxiYesnoText;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "Zazhixinxi{" +
            "id=" + id +
            ", zazhixinxiName=" + zazhixinxiName +
            ", zazhixinxiTypes=" + zazhixinxiTypes +
            ", zazhixinxiPhoto=" + zazhixinxiPhoto +
            ", zazhixinxiFile=" + zazhixinxiFile +
            ", shangxiaTypes=" + shangxiaTypes +
            ", zazhixinxiNewMoney=" + zazhixinxiNewMoney +
            ", zazhixinxiContent=" + zazhixinxiContent +
            ", zazhixinxiYesnoTypes=" + zazhixinxiYesnoTypes +
            ", zazhixinxiYesnoText=" + zazhixinxiYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
