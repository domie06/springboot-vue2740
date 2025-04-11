
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 杂志信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zazhixinxi")
public class ZazhixinxiController {
    private static final Logger logger = LoggerFactory.getLogger(ZazhixinxiController.class);

    @Autowired
    private ZazhixinxiService zazhixinxiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private FaxingfangService faxingfangService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("发行方".equals(role))
            params.put("faxingfangId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zazhixinxiService.queryPage(params);

        //字典表数据转换
        List<ZazhixinxiView> list =(List<ZazhixinxiView>)page.getList();
        for(ZazhixinxiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZazhixinxiEntity zazhixinxi = zazhixinxiService.selectById(id);
        if(zazhixinxi !=null){
            //entity转view
            ZazhixinxiView view = new ZazhixinxiView();
            BeanUtils.copyProperties( zazhixinxi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZazhixinxiEntity zazhixinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zazhixinxi:{}",this.getClass().getName(),zazhixinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZazhixinxiEntity> queryWrapper = new EntityWrapper<ZazhixinxiEntity>()
            .eq("zazhixinxi_name", zazhixinxi.getZazhixinxiName())
            .eq("zazhixinxi_types", zazhixinxi.getZazhixinxiTypes())
            .eq("shangxia_types", zazhixinxi.getShangxiaTypes())
            .eq("zazhixinxi_yesno_types", zazhixinxi.getZazhixinxiYesnoTypes())
            .eq("zazhixinxi_yesno_text", zazhixinxi.getZazhixinxiYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZazhixinxiEntity zazhixinxiEntity = zazhixinxiService.selectOne(queryWrapper);
        if(zazhixinxiEntity==null){
            zazhixinxi.setShangxiaTypes(1);
            zazhixinxi.setZazhixinxiYesnoTypes(1);
            zazhixinxi.setInsertTime(new Date());
            zazhixinxi.setCreateTime(new Date());
            zazhixinxiService.insert(zazhixinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZazhixinxiEntity zazhixinxi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zazhixinxi:{}",this.getClass().getName(),zazhixinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ZazhixinxiEntity> queryWrapper = new EntityWrapper<ZazhixinxiEntity>()
            .notIn("id",zazhixinxi.getId())
            .andNew()
            .eq("zazhixinxi_name", zazhixinxi.getZazhixinxiName())
            .eq("zazhixinxi_types", zazhixinxi.getZazhixinxiTypes())
            .eq("shangxia_types", zazhixinxi.getShangxiaTypes())
            .eq("zazhixinxi_yesno_types", zazhixinxi.getZazhixinxiYesnoTypes())
            .eq("zazhixinxi_yesno_text", zazhixinxi.getZazhixinxiYesnoText())
            .eq("insert_time", zazhixinxi.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZazhixinxiEntity zazhixinxiEntity = zazhixinxiService.selectOne(queryWrapper);
        if("".equals(zazhixinxi.getZazhixinxiPhoto()) || "null".equals(zazhixinxi.getZazhixinxiPhoto())){
                zazhixinxi.setZazhixinxiPhoto(null);
        }
        if("".equals(zazhixinxi.getZazhixinxiFile()) || "null".equals(zazhixinxi.getZazhixinxiFile())){
                zazhixinxi.setZazhixinxiFile(null);
        }
        if(zazhixinxiEntity==null){
            zazhixinxiService.updateById(zazhixinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zazhixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZazhixinxiEntity> zazhixinxiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZazhixinxiEntity zazhixinxiEntity = new ZazhixinxiEntity();
//                            zazhixinxiEntity.setZazhixinxiName(data.get(0));                    //杂志标题 要改的
//                            zazhixinxiEntity.setZazhixinxiTypes(Integer.valueOf(data.get(0)));   //杂志类型 要改的
//                            zazhixinxiEntity.setZazhixinxiPhoto("");//照片
//                            zazhixinxiEntity.setZazhixinxiFile(data.get(0));                    //杂志下载 要改的
//                            zazhixinxiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            zazhixinxiEntity.setZazhixinxiNewMoney(data.get(0));                    //价格 要改的
//                            zazhixinxiEntity.setZazhixinxiContent("");//照片
//                            zazhixinxiEntity.setZazhixinxiYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            zazhixinxiEntity.setZazhixinxiYesnoText(data.get(0));                    //审核原因 要改的
//                            zazhixinxiEntity.setInsertTime(date);//时间
//                            zazhixinxiEntity.setCreateTime(date);//时间
                            zazhixinxiList.add(zazhixinxiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        zazhixinxiService.insertBatch(zazhixinxiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = zazhixinxiService.queryPage(params);

        //字典表数据转换
        List<ZazhixinxiView> list =(List<ZazhixinxiView>)page.getList();
        for(ZazhixinxiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZazhixinxiEntity zazhixinxi = zazhixinxiService.selectById(id);
            if(zazhixinxi !=null){


                //entity转view
                ZazhixinxiView view = new ZazhixinxiView();
                BeanUtils.copyProperties( zazhixinxi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ZazhixinxiEntity zazhixinxi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zazhixinxi:{}",this.getClass().getName(),zazhixinxi.toString());
        Wrapper<ZazhixinxiEntity> queryWrapper = new EntityWrapper<ZazhixinxiEntity>()
            .eq("zazhixinxi_name", zazhixinxi.getZazhixinxiName())
            .eq("zazhixinxi_types", zazhixinxi.getZazhixinxiTypes())
            .eq("shangxia_types", zazhixinxi.getShangxiaTypes())
            .eq("zazhixinxi_yesno_types", zazhixinxi.getZazhixinxiYesnoTypes())
            .eq("zazhixinxi_yesno_text", zazhixinxi.getZazhixinxiYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZazhixinxiEntity zazhixinxiEntity = zazhixinxiService.selectOne(queryWrapper);
        if(zazhixinxiEntity==null){
            zazhixinxi.setZazhixinxiYesnoTypes(1);
            zazhixinxi.setInsertTime(new Date());
            zazhixinxi.setCreateTime(new Date());
        zazhixinxiService.insert(zazhixinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
