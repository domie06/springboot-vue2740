package com.dao;

import com.entity.ZazhixinxiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZazhixinxiOrderView;

/**
 * 杂志订单 Dao 接口
 *
 * @author 
 */
public interface ZazhixinxiOrderDao extends BaseMapper<ZazhixinxiOrderEntity> {

   List<ZazhixinxiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
