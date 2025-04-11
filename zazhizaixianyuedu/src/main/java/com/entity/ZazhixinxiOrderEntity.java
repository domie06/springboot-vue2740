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
 * 杂志订单
 *
 * @author 
 * @email
 */
@TableName("zazhixinxi_order")
public class ZazhixinxiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZazhixinxiOrderEntity() {

	}

	public ZazhixinxiOrderEntity(T t) {
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
     * 订单号
     */
    @TableField(value = "zazhixinxi_order_uuid_number")

    private String zazhixinxiOrderUuidNumber;


    /**
     * 杂志
     */
    @TableField(value = "zazhixinxi_id")

    private Integer zazhixinxiId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 实付价格
     */
    @TableField(value = "zazhixinxi_order_true_price")

    private Double zazhixinxiOrderTruePrice;


    /**
     * 订购日期
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat
    @TableField(value = "buy_zuowei_time")

    private Date buyZuoweiTime;


    /**
     * 订单创建时间
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
	 * 设置：订单号
	 */
    public String getZazhixinxiOrderUuidNumber() {
        return zazhixinxiOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setZazhixinxiOrderUuidNumber(String zazhixinxiOrderUuidNumber) {
        this.zazhixinxiOrderUuidNumber = zazhixinxiOrderUuidNumber;
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
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getZazhixinxiOrderTruePrice() {
        return zazhixinxiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setZazhixinxiOrderTruePrice(Double zazhixinxiOrderTruePrice) {
        this.zazhixinxiOrderTruePrice = zazhixinxiOrderTruePrice;
    }
    /**
	 * 设置：订购日期
	 */
    public Date getBuyZuoweiTime() {
        return buyZuoweiTime;
    }


    /**
	 * 获取：订购日期
	 */

    public void setBuyZuoweiTime(Date buyZuoweiTime) {
        this.buyZuoweiTime = buyZuoweiTime;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
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
        return "ZazhixinxiOrder{" +
            "id=" + id +
            ", zazhixinxiOrderUuidNumber=" + zazhixinxiOrderUuidNumber +
            ", zazhixinxiId=" + zazhixinxiId +
            ", yonghuId=" + yonghuId +
            ", zazhixinxiOrderTruePrice=" + zazhixinxiOrderTruePrice +
            ", buyZuoweiTime=" + buyZuoweiTime +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
