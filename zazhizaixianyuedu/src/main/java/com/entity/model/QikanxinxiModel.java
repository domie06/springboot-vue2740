package com.entity.model;

import com.entity.QikanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 期刊
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class QikanxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String qikanxinxiName;


    /**
     * 杂志
     */
    private Integer zazhixinxiId;


    /**
     * 期刊下载
     */
    private String qikanxinxiFile;


    /**
     * 图片
     */
    private String qikanxinxiPhoto;


    /**
     * 详情
     */
    private String qikanxinxiContent;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：标题
	 */
    public String getQikanxinxiName() {
        return qikanxinxiName;
    }


    /**
	 * 设置：标题
	 */
    public void setQikanxinxiName(String qikanxinxiName) {
        this.qikanxinxiName = qikanxinxiName;
    }
    /**
	 * 获取：杂志
	 */
    public Integer getZazhixinxiId() {
        return zazhixinxiId;
    }


    /**
	 * 设置：杂志
	 */
    public void setZazhixinxiId(Integer zazhixinxiId) {
        this.zazhixinxiId = zazhixinxiId;
    }
    /**
	 * 获取：期刊下载
	 */
    public String getQikanxinxiFile() {
        return qikanxinxiFile;
    }


    /**
	 * 设置：期刊下载
	 */
    public void setQikanxinxiFile(String qikanxinxiFile) {
        this.qikanxinxiFile = qikanxinxiFile;
    }
    /**
	 * 获取：图片
	 */
    public String getQikanxinxiPhoto() {
        return qikanxinxiPhoto;
    }


    /**
	 * 设置：图片
	 */
    public void setQikanxinxiPhoto(String qikanxinxiPhoto) {
        this.qikanxinxiPhoto = qikanxinxiPhoto;
    }
    /**
	 * 获取：详情
	 */
    public String getQikanxinxiContent() {
        return qikanxinxiContent;
    }


    /**
	 * 设置：详情
	 */
    public void setQikanxinxiContent(String qikanxinxiContent) {
        this.qikanxinxiContent = qikanxinxiContent;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
