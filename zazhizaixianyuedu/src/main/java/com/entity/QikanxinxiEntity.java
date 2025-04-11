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
 * 期刊
 *
 * @author 
 * @email
 */
@TableName("qikanxinxi")
public class QikanxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public QikanxinxiEntity() {

	}

	public QikanxinxiEntity(T t) {
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
     * 标题
     */
    @TableField(value = "qikanxinxi_name")

    private String qikanxinxiName;


    /**
     * 杂志
     */
    @TableField(value = "zazhixinxi_id")

    private Integer zazhixinxiId;


    /**
     * 期刊下载
     */
    @TableField(value = "qikanxinxi_file")

    private String qikanxinxiFile;


    /**
     * 图片
     */
    @TableField(value = "qikanxinxi_photo")

    private String qikanxinxiPhoto;


    /**
     * 详情
     */
    @TableField(value = "qikanxinxi_content")

    private String qikanxinxiContent;


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
	 * 设置：标题
	 */
    public String getQikanxinxiName() {
        return qikanxinxiName;
    }


    /**
	 * 获取：标题
	 */

    public void setQikanxinxiName(String qikanxinxiName) {
        this.qikanxinxiName = qikanxinxiName;
    }
    /**
	 * 设置：杂志
	 */
    public Integer getZazhixinxiId() {
        return zazhixinxiId;
    }


    /**
	 * 获取：杂志
	 */

    public void setZazhixinxiId(Integer zazhixinxiId) {
        this.zazhixinxiId = zazhixinxiId;
    }
    /**
	 * 设置：期刊下载
	 */
    public String getQikanxinxiFile() {
        return qikanxinxiFile;
    }


    /**
	 * 获取：期刊下载
	 */

    public void setQikanxinxiFile(String qikanxinxiFile) {
        this.qikanxinxiFile = qikanxinxiFile;
    }
    /**
	 * 设置：图片
	 */
    public String getQikanxinxiPhoto() {
        return qikanxinxiPhoto;
    }


    /**
	 * 获取：图片
	 */

    public void setQikanxinxiPhoto(String qikanxinxiPhoto) {
        this.qikanxinxiPhoto = qikanxinxiPhoto;
    }
    /**
	 * 设置：详情
	 */
    public String getQikanxinxiContent() {
        return qikanxinxiContent;
    }


    /**
	 * 获取：详情
	 */

    public void setQikanxinxiContent(String qikanxinxiContent) {
        this.qikanxinxiContent = qikanxinxiContent;
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
        return "Qikanxinxi{" +
            "id=" + id +
            ", qikanxinxiName=" + qikanxinxiName +
            ", zazhixinxiId=" + zazhixinxiId +
            ", qikanxinxiFile=" + qikanxinxiFile +
            ", qikanxinxiPhoto=" + qikanxinxiPhoto +
            ", qikanxinxiContent=" + qikanxinxiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
