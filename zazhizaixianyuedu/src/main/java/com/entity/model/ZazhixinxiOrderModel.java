package com.entity.model;

import com.entity.ZazhixinxiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 杂志订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZazhixinxiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String zazhixinxiOrderUuidNumber;


    /**
     * 杂志
     */
    private Integer zazhixinxiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double zazhixinxiOrderTruePrice;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date buyZuoweiTime;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
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
	 * 获取：订单号
	 */
    public String getZazhixinxiOrderUuidNumber() {
        return zazhixinxiOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setZazhixinxiOrderUuidNumber(String zazhixinxiOrderUuidNumber) {
        this.zazhixinxiOrderUuidNumber = zazhixinxiOrderUuidNumber;
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
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getZazhixinxiOrderTruePrice() {
        return zazhixinxiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setZazhixinxiOrderTruePrice(Double zazhixinxiOrderTruePrice) {
        this.zazhixinxiOrderTruePrice = zazhixinxiOrderTruePrice;
    }
    /**
	 * 获取：订购日期
	 */
    public Date getBuyZuoweiTime() {
        return buyZuoweiTime;
    }


    /**
	 * 设置：订购日期
	 */
    public void setBuyZuoweiTime(Date buyZuoweiTime) {
        this.buyZuoweiTime = buyZuoweiTime;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
