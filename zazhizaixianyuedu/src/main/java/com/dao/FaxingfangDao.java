package com.dao;

import com.entity.FaxingfangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FaxingfangView;

/**
 * 发行方 Dao 接口
 *
 * @author 
 */
public interface FaxingfangDao extends BaseMapper<FaxingfangEntity> {

   List<FaxingfangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
