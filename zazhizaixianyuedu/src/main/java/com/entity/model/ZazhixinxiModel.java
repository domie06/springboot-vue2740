package com.entity.model;

import com.entity.ZazhixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 杂志信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZazhixinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 杂志标题
     */
    private String zazhixinxiName;


    /**
     * 杂志类型
     */
    private Integer zazhixinxiTypes;


    /**
     * 杂志图片
     */
    private String zazhixinxiPhoto;


    /**
     * 杂志下载
     */
    private String zazhixinxiFile;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 价格
     */
    private Double zazhixinxiNewMoney;


    /**
     * 杂志详情
     */
    private String zazhixinxiContent;


    /**
     * 审核状态
     */
    private Integer zazhixinxiYesnoTypes;


    /**
     * 审核原因
     */
    private String zazhixinxiYesnoText;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：杂志标题
	 */
    public String getZazhixinxiName() {
        return zazhixinxiName;
    }


    /**
	 * 设置：杂志标题
	 */
    public void setZazhixinxiName(String zazhixinxiName) {
        this.zazhixinxiName = zazhixinxiName;
    }
    /**
	 * 获取：杂志类型
	 */
    public Integer getZazhixinxiTypes() {
        return zazhixinxiTypes;
    }


    /**
	 * 设置：杂志类型
	 */
    public void setZazhixinxiTypes(Integer zazhixinxiTypes) {
        this.zazhixinxiTypes = zazhixinxiTypes;
    }
    /**
	 * 获取：杂志图片
	 */
    public String getZazhixinxiPhoto() {
        return zazhixinxiPhoto;
    }


    /**
	 * 设置：杂志图片
	 */
    public void setZazhixinxiPhoto(String zazhixinxiPhoto) {
        this.zazhixinxiPhoto = zazhixinxiPhoto;
    }
    /**
	 * 获取：杂志下载
	 */
    public String getZazhixinxiFile() {
        return zazhixinxiFile;
    }


    /**
	 * 设置：杂志下载
	 */
    public void setZazhixinxiFile(String zazhixinxiFile) {
        this.zazhixinxiFile = zazhixinxiFile;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：价格
	 */
    public Double getZazhixinxiNewMoney() {
        return zazhixinxiNewMoney;
    }


    /**
	 * 设置：价格
	 */
    public void setZazhixinxiNewMoney(Double zazhixinxiNewMoney) {
        this.zazhixinxiNewMoney = zazhixinxiNewMoney;
    }
    /**
	 * 获取：杂志详情
	 */
    public String getZazhixinxiContent() {
        return zazhixinxiContent;
    }


    /**
	 * 设置：杂志详情
	 */
    public void setZazhixinxiContent(String zazhixinxiContent) {
        this.zazhixinxiContent = zazhixinxiContent;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getZazhixinxiYesnoTypes() {
        return zazhixinxiYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setZazhixinxiYesnoTypes(Integer zazhixinxiYesnoTypes) {
        this.zazhixinxiYesnoTypes = zazhixinxiYesnoTypes;
    }
    /**
	 * 获取：审核原因
	 */
    public String getZazhixinxiYesnoText() {
        return zazhixinxiYesnoText;
    }


    /**
	 * 设置：审核原因
	 */
    public void setZazhixinxiYesnoText(String zazhixinxiYesnoText) {
        this.zazhixinxiYesnoText = zazhixinxiYesnoText;
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
