package com.dao;

import com.entity.ZazhixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZazhixinxiView;

/**
 * 杂志信息 Dao 接口
 *
 * @author 
 */
public interface ZazhixinxiDao extends BaseMapper<ZazhixinxiEntity> {

   List<ZazhixinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
