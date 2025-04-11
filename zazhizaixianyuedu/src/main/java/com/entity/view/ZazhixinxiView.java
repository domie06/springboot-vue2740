package com.entity.view;

import com.entity.ZazhixinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 杂志信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("zazhixinxi")
public class ZazhixinxiView extends ZazhixinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 杂志类型的值
		*/
		private String zazhixinxiValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;
		/**
		* 审核状态的值
		*/
		private String zazhixinxiYesnoValue;



	public ZazhixinxiView() {

	}

	public ZazhixinxiView(ZazhixinxiEntity zazhixinxiEntity) {
		try {
			BeanUtils.copyProperties(this, zazhixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














}
