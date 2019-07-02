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
	
	

