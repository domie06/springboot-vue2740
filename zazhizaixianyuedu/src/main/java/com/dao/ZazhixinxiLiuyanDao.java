package com.dao;

import com.entity.ZazhixinxiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZazhixinxiLiuyanView;

/**
 * 杂志评论 Dao 接口
 *
 * @author 
 */
public interface ZazhixinxiLiuyanDao extends BaseMapper<ZazhixinxiLiuyanEntity> {

   List<ZazhixinxiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
