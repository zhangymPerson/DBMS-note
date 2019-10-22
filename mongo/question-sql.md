## mongo中的sql查询

- 模糊查询

    ```js
    //本质是利用正则表达式
    //查询 collectionName中 key字段 包含"关键字"字的文档：
    db.getCollection('collectionName').find({key:/关键字/})
    db.collectionName.find({key:/关键字/}}
    //查询 key 字段以"关键字"字开头的文档：
    db.collectionName.find({key:/^关键字/})
    //查询 key 字段以"关键字"字结尾的文档：
    db.collectionName.find({key:/关键字$/})

    //只差某一列的数据
    db.getCollection('collectionname').find({},{"columnname":1})

    //查询指定的多列的数据 查看 columnname_keyOne 和 columnname_keyTwo 
    db.getCollection('collectionname').find({"columnname_key":/正则/},{"columnname_keyOne":1,"columnname_keyTwo":1})

    //去重查询
    db.collectionName.distinct("columnname")

    //查询关键字 模糊查询
    db.collectionName.find( {"columnname": {$regex:/正则/}},{"columnname":1})

    //查询任意位置包含 正则 只包含当前查找值
    db.collectionName.find( {"columnname": /^.*字符.*/},{"columnname":1})

    
    ```

