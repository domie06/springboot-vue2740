const base = {
    get() {
        return {
            url : "http://localhost:8080/zazhizaixianyuedu/",
            name: "zazhizaixianyuedu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zazhizaixianyuedu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "杂志在线阅读网站"
        } 
    }
}
export default base
