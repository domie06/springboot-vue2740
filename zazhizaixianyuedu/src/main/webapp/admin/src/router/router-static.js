import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import faxingfang from '@/views/modules/faxingfang/list'
    import forum from '@/views/modules/forum/list'
    import liulanjil from '@/views/modules/liulanjil/list'
    import news from '@/views/modules/news/list'
    import qikanxinxi from '@/views/modules/qikanxinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zazhixinxi from '@/views/modules/zazhixinxi/list'
    import zazhixinxiCollection from '@/views/modules/zazhixinxiCollection/list'
    import zazhixinxiLiuyan from '@/views/modules/zazhixinxiLiuyan/list'
    import zazhixinxiOrder from '@/views/modules/zazhixinxiOrder/list'
    import config from '@/views/modules/config/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryZazhixinxi from '@/views/modules/dictionaryZazhixinxi/list'
    import dictionaryZazhixinxiCollection from '@/views/modules/dictionaryZazhixinxiCollection/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryZazhixinxi',
        name: '杂志类型',
        component: dictionaryZazhixinxi
    }
    ,{
        path: '/dictionaryZazhixinxiCollection',
        name: '收藏表类型',
        component: dictionaryZazhixinxiCollection
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/faxingfang',
        name: '发行方',
        component: faxingfang
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/liulanjil',
        name: '浏览记录',
        component: liulanjil
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/qikanxinxi',
        name: '期刊',
        component: qikanxinxi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zazhixinxi',
        name: '杂志信息',
        component: zazhixinxi
      }
    ,{
        path: '/zazhixinxiCollection',
        name: '杂志收藏',
        component: zazhixinxiCollection
      }
    ,{
        path: '/zazhixinxiLiuyan',
        name: '杂志评论',
        component: zazhixinxiLiuyan
      }
    ,{
        path: '/zazhixinxiOrder',
        name: '杂志订单',
        component: zazhixinxiOrder
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
