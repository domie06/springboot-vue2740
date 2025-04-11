package com.entity.vo;

import com.entity.QikanxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 期刊
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("qikanxinxi")
public class QikanxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 photoShow
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
	 * 设置：创建时间 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
