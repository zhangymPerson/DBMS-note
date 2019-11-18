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

- 索引sql

    ```js
    //查看集合索引
    db.col.getIndexes()
    //查看集合索引大小
    db.col.totalIndexSize()
    //删除集合所有索引
    db.col.dropIndexes()
    //删除集合指定索引
    db.col.dropIndex("索引名称")
    ```
    利用 TTL 集合对存储的数据进行失效时间设置：经过指定的时间段后或在指定的时间点过期，MongoDB 独立线程去清除数据。类似于设置定时自动删除任务，可以清除历史记录或日志等前提条件，设置 Index 的关键字段为日期类型 new Date()。
    例如数据记录中 createDate 为日期类型时：

    ```js
    //设置时间180秒后自动清除。
    //设置在创建记录后，180 秒左右删除。
    db.col.createIndex({"createDate": 1},{expireAfterSeconds: 180})
    //由记录中设定日期点清除。

    //设置 A 记录在 2019 年 1 月 22 日晚上 11 点左右删除，
    //A 记录中需添加 "ClearUpDate": new Date('Jan 22, 2019 23:00:00')，
    //且 Index中expireAfterSeconds 设值为 0。
    db.col.createIndex({"ClearUpDate": 1},{expireAfterSeconds: 0})
    ```
- 其他注意事项:

    索引关键字段必须是 Date 类型。

    非立即执行：扫描 Document 过期数据并删除是独立线程执行，默认 60s 扫描一次，删除也不一定是立即删除成功。

    单字段索引，混合索引不支持。
