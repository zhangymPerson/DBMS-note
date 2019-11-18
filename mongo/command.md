# mongo command note

- 登陆
	
	 mongo --port 27017 -u root -p root

- 查看有哪些库

	show dbs;

- 选择和新建库

	use newdbname;

- 查看所有的集合 类比mysql中的表结构

	show collections;

- 创建collection

	#往集合中添加一条数据即可创建该集合 collectionname 代表要创建的集合(表)
	db.collectionname.insert({"key":"value","key":"value"});

- 查找命令

	#查找全部数据
	db.collectionname.find({})

	#查找总数
	#大括号里可以放查询条件
	 db.getCollection("collectionname").count({})
	
	

- 查看索引


- 创建索引

	createIndex() 方法
	
	MongoDB使用 createIndex() 方法来创建索引。

	语法

	createIndex()方法基本语法格式如下所示：

		>db.collection.createIndex(keys, options)

	createIndex() 方法中你也可以设置使用多个字段创建索引（关系型数据库中称作复合索引）。

		>db.col.createIndex({"title":1,"description":-1})

	语法中 Key 值为你要创建的索引字段，1 为指定按升序创建索引，如果你想按降序来创建索引指定为 -1 即可。

