# mongo command note

## 官方文档

- [https://docs.mongodb.com/manual/](https://docs.mongodb.com/manual/)

## 常用命令

- 登陆

  mongo --port 27017 -u root -p root

- 查看有哪些库

  show dbs;

- 选择和新建库

  use newDbName;

- 查看所有的集合 类比 mysql 中的表结构

  show collections;

- 创建 collection

  #往集合中添加一条数据即可创建该集合 collectionName 代表要创建的集合(表)
  db.collectionName.insert({"key":"value","key":"value"});

- 查找命令

  #查找全部数据
  db.collectionName.find({})

  #查找总数 #大括号里可以放查询条件
  db.getCollection("collectionName").count({})
  db.getCollection("collectionName").count({"\_id":/1209/})

- 查看索引

- 创建索引

  createIndex() 方法

  MongoDB 使用 createIndex() 方法来创建索引。

  语法

  createIndex()方法基本语法格式如下所示：

      >db.collection.createIndex(keys, options)

  createIndex() 方法中你也可以设置使用多个字段创建索引（关系型数据库中称作复合索引）。

      >db.col.createIndex({"title":1,"description":-1})

  语法中 Key 值为你要创建的索引字段，1 为指定按升序创建索引，如果你想按降序来创建索引指定为 -1 即可。

- mongo 导出命令

  一种是针对**库**的 `mongodump` 和 `mongorestore`

  ```sh
  #导出整个库
  mongodump --host 127.0.0.1 --port 27017 --username username --password password --out /root/*/*/dirPath --db dbName
  ```
- 参数介绍：

  --host <hostname><:port>, -h <hostname><:port> # 指定备份的主机 ip 和端口号，默认值 localhost:27017
  --port # 指定端口号 默认 27017
  --username <username>, -u <username> # 指定用户名
  --password <password>, -p <password> # 指定密码
  --authenticationDatabase <dbname> # 指定认证的数据库
  --authenticationMechanism <name> # 指定认证的算法 ，默认值 SCRAM-SHA-1
  --db <database>, -d <database> # 指定备份的数据库，未指定的话，备份所有的数据库，但不包含 local 库
  --collection <collection>, -c <collection> # 指定备份的集合，未指定则备份指定库中的所有集合。
  --query <json>, -q <json> # 指定 json 作为查询条件。来备份我们过滤后的数据。
  --queryFile <path> # 指定 json 文档路径，以该文档的内容作为查询条件，来备份我们过滤后的数据。
  --quit # 通过抑制 MongoDB 的复制，连接等活动，来实现备份。
  --gzip # 开启压缩，3.2 版本后可以使用，输出为文件的话会带有后缀.gz
  --out <path>, -o <path> # 输出的目录路径
  --repir # 修复数据时使用 下面有详细介绍
  --oplog # mongodump 会将 mongodump 执行期间的 oplog 日志 输出到文件 oplog.bson，这就意味着从备份开始到备份结束的数据操作我们都可以记录下来。
  --archive <file> # 输出到单个存档文件或者是直接输出。
  --dumpDbUsersAndRoles # 只有在 使用 --db 时才适用，备份数据库的包含的用户和角色。
  --excludeCollection string # 排除指定的集合，如果要排除多个，使用多个--excludeCollection
  --numParallelCollections int, -j int # 并行导出的集合数，默认为 4
  --ssl # 指定 TLS/SSL 协议
  --sslCAFile filename # 指定认证文件名
  --sslPEMKeyFile <filename>
  --sslPEMKeyPassword <value>
  --sslCRLFile <filename>
  --sslAllowInvalidCertificates
  --sslAllowInvalidHostnames
  --sslFIPSMode

  一种是针对库中**表**的 `mongoexport` 和 `mongoimport`

  ```sh
  #导出单个表
  mongoexport --host 127.0.0.1 --port 27017 --db dbName --collection tableName --out outFile.json --username username --password password
  ```
