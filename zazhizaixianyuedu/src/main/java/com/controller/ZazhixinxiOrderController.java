
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
 * 杂志订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zazhixinxiOrder")
public class ZazhixinxiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ZazhixinxiOrderController.class);

    @Autowired
    private ZazhixinxiOrderService zazhixinxiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZazhixinxiService zazhixinxiService;



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
        PageUtils page = zazhixinxiOrderService.queryPage(params);

        //字典表数据转换
        List<ZazhixinxiOrderView> list =(List<ZazhixinxiOrderView>)page.getList();
        for(ZazhixinxiOrderView c:list){
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
        ZazhixinxiOrderEntity zazhixinxiOrder = zazhixinxiOrderService.selectById(id);
        if(zazhixinxiOrder !=null){
            //entity转view
            ZazhixinxiOrderView view = new ZazhixinxiOrderView();
            BeanUtils.copyProperties( zazhixinxiOrder , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zazhixinxiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                ZazhixinxiEntity zazhixinxi = zazhixinxiService.selectById(zazhixinxiOrder.getZazhixinxiId());
                if(zazhixinxi != null){
                    BeanUtils.copyProperties( zazhixinxi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZazhixinxiId(zazhixinxi.getId());
                }
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
    public R save(@RequestBody ZazhixinxiOrderEntity zazhixinxiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zazhixinxiOrder:{}",this.getClass().getName(),zazhixinxiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            zazhixinxiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        zazhixinxiOrder.setInsertTime(new Date());
        zazhixinxiOrder.setCreateTime(new Date());
        zazhixinxiOrderService.insert(zazhixinxiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZazhixinxiOrderEntity zazhixinxiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zazhixinxiOrder:{}",this.getClass().getName(),zazhixinxiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            zazhixinxiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZazhixinxiOrderEntity> queryWrapper = new EntityWrapper<ZazhixinxiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZazhixinxiOrderEntity zazhixinxiOrderEntity = zazhixinxiOrderService.selectOne(queryWrapper);
        if(zazhixinxiOrderEntity==null){
            zazhixinxiOrderService.updateById(zazhixinxiOrder);//根据id更新
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
        zazhixinxiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZazhixinxiOrderEntity> zazhixinxiOrderList = new ArrayList<>();//上传的东西
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
                            ZazhixinxiOrderEntity zazhixinxiOrderEntity = new ZazhixinxiOrderEntity();
//                            zazhixinxiOrderEntity.setZazhixinxiOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            zazhixinxiOrderEntity.setZazhixinxiId(Integer.valueOf(data.get(0)));   //杂志 要改的
//                            zazhixinxiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            zazhixinxiOrderEntity.setZazhixinxiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            zazhixinxiOrderEntity.setBuyZuoweiTime(new Date(data.get(0)));          //订购日期 要改的
//                            zazhixinxiOrderEntity.setInsertTime(date);//时间
//                            zazhixinxiOrderEntity.setCreateTime(date);//时间
                            zazhixinxiOrderList.add(zazhixinxiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("zazhixinxiOrderUuidNumber")){
                                    List<String> zazhixinxiOrderUuidNumber = seachFields.get("zazhixinxiOrderUuidNumber");
                                    zazhixinxiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zazhixinxiOrderUuidNumber = new ArrayList<>();
                                    zazhixinxiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zazhixinxiOrderUuidNumber",zazhixinxiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<ZazhixinxiOrderEntity> zazhixinxiOrderEntities_zazhixinxiOrderUuidNumber = zazhixinxiOrderService.selectList(new EntityWrapper<ZazhixinxiOrderEntity>().in("zazhixinxi_order_uuid_number", seachFields.get("zazhixinxiOrderUuidNumber")));
                        if(zazhixinxiOrderEntities_zazhixinxiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZazhixinxiOrderEntity s:zazhixinxiOrderEntities_zazhixinxiOrderUuidNumber){
                                repeatFields.add(s.getZazhixinxiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zazhixinxiOrderService.insertBatch(zazhixinxiOrderList);
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
        PageUtils page = zazhixinxiOrderService.queryPage(params);

        //字典表数据转换
        List<ZazhixinxiOrderView> list =(List<ZazhixinxiOrderView>)page.getList();
        for(ZazhixinxiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZazhixinxiOrderEntity zazhixinxiOrder = zazhixinxiOrderService.selectById(id);
            if(zazhixinxiOrder !=null){


                //entity转view
                ZazhixinxiOrderView view = new ZazhixinxiOrderView();
                BeanUtils.copyProperties( zazhixinxiOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(zazhixinxiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    ZazhixinxiEntity zazhixinxi = zazhixinxiService.selectById(zazhixinxiOrder.getZazhixinxiId());
                if(zazhixinxi != null){
                    BeanUtils.copyProperties( zazhixinxi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZazhixinxiId(zazhixinxi.getId());
                }
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
    public R add(@RequestBody ZazhixinxiOrderEntity zazhixinxiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zazhixinxiOrder:{}",this.getClass().getName(),zazhixinxiOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            ZazhixinxiEntity zazhixinxiEntity = zazhixinxiService.selectById(zazhixinxiOrder.getZazhixinxiId());
            if(zazhixinxiEntity == null){
                return R.error(511,"查不到该物品");
            }
            // Double zazhixinxiNewMoney = zazhixinxiEntity.getZazhixinxiNewMoney();

            if(false){
            }
            else if(zazhixinxiEntity.getZazhixinxiNewMoney() == null){
                return R.error(511,"物品价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - zazhixinxiEntity.getZazhixinxiNewMoney()*1;//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            zazhixinxiOrder.setYonghuId(userId); //设置订单支付人id
            zazhixinxiOrder.setInsertTime(new Date());
            zazhixinxiOrder.setCreateTime(new Date());
                zazhixinxiOrderService.insert(zazhixinxiOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }

}
