//执行 mongo 地址  */insert.js
//建立连接    mongodb://username:password@host:port
conn = new Mongo("mongodb://danao:danao@localhost:3306");
//取得db对象 dbname
db = conn.getDB("danao");
//删除collection对象
db.userinfo.drop();
db.createCollection('userinfo',{safe:true},function(err,collection){
    if(err){
        console.log(err);
    }    
});

//批量插入demo
db.userinfo.insertMany([
   {"username":"12344657"},
   {"remark":"测试数据"}
]);