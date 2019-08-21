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
    ```

