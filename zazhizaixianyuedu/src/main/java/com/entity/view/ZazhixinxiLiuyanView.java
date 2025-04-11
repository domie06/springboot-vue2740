package com.entity.view;

import com.entity.ZazhixinxiLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 杂志评论
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zazhixinxi_liuyan")
public class ZazhixinxiLiuyanView extends ZazhixinxiLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

		//级联表 zazhixinxi
			/**
			* 杂志标题
			*/
			private String zazhixinxiName;
			/**
			* 杂志类型
			*/
			private Integer zazhixinxiTypes;
				/**
				* 杂志类型的值
				*/
				private String zazhixinxiValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
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
				* 审核状态的值
				*/
				private String zazhixinxiYesnoValue;
			/**
			* 审核原因
			*/
			private String zazhixinxiYesnoText;

	public ZazhixinxiLiuyanView() {

	}

	public ZazhixinxiLiuyanView(ZazhixinxiLiuyanEntity zazhixinxiLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, zazhixinxiLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


























				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}


				//级联表的get和set zazhixinxi
					/**
					* 获取： 杂志标题
					*/
					public String getZazhixinxiName() {
						return zazhixinxiName;
					}
					/**
					* 设置： 杂志标题
					*/
					public void setZazhixinxiName(String zazhixinxiName) {
						this.zazhixinxiName = zazhixinxiName;
					}
					/**
					* 获取： 杂志类型
					*/
					public Integer getZazhixinxiTypes() {
						return zazhixinxiTypes;
					}
					/**
					* 设置： 杂志类型
					*/
					public void setZazhixinxiTypes(Integer zazhixinxiTypes) {
						this.zazhixinxiTypes = zazhixinxiTypes;
					}


						/**
						* 获取： 杂志类型的值
						*/
						public String getZazhixinxiValue() {
							return zazhixinxiValue;
						}
						/**
						* 设置： 杂志类型的值
						*/
						public void setZazhixinxiValue(String zazhixinxiValue) {
							this.zazhixinxiValue = zazhixinxiValue;
						}
					/**
					* 获取： 杂志图片
					*/
					public String getZazhixinxiPhoto() {
						return zazhixinxiPhoto;
					}
					/**
					* 设置： 杂志图片
					*/
					public void setZazhixinxiPhoto(String zazhixinxiPhoto) {
						this.zazhixinxiPhoto = zazhixinxiPhoto;
					}
					/**
					* 获取： 杂志下载
					*/
					public String getZazhixinxiFile() {
						return zazhixinxiFile;
					}
					/**
					* 设置： 杂志下载
					*/
					public void setZazhixinxiFile(String zazhixinxiFile) {
						this.zazhixinxiFile = zazhixinxiFile;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 价格
					*/
					public Double getZazhixinxiNewMoney() {
						return zazhixinxiNewMoney;
					}
					/**
					* 设置： 价格
					*/
					public void setZazhixinxiNewMoney(Double zazhixinxiNewMoney) {
						this.zazhixinxiNewMoney = zazhixinxiNewMoney;
					}
					/**
					* 获取： 杂志详情
					*/
					public String getZazhixinxiContent() {
						return zazhixinxiContent;
					}
					/**
					* 设置： 杂志详情
					*/
					public void setZazhixinxiContent(String zazhixinxiContent) {
						this.zazhixinxiContent = zazhixinxiContent;
					}
					/**
					* 获取： 审核状态
					*/
					public Integer getZazhixinxiYesnoTypes() {
						return zazhixinxiYesnoTypes;
					}
					/**
					* 设置： 审核状态
					*/
					public void setZazhixinxiYesnoTypes(Integer zazhixinxiYesnoTypes) {
						this.zazhixinxiYesnoTypes = zazhixinxiYesnoTypes;
					}


						/**
						* 获取： 审核状态的值
						*/
						public String getZazhixinxiYesnoValue() {
							return zazhixinxiYesnoValue;
						}
						/**
						* 设置： 审核状态的值
						*/
						public void setZazhixinxiYesnoValue(String zazhixinxiYesnoValue) {
							this.zazhixinxiYesnoValue = zazhixinxiYesnoValue;
						}
					/**
					* 获取： 审核原因
					*/
					public String getZazhixinxiYesnoText() {
						return zazhixinxiYesnoText;
					}
					/**
					* 设置： 审核原因
					*/
					public void setZazhixinxiYesnoText(String zazhixinxiYesnoText) {
						this.zazhixinxiYesnoText = zazhixinxiYesnoText;
					}













}
