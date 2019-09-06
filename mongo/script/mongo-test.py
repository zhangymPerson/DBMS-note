#_*_encoding:utf-8_*_
'''
简单脚本 保存mongo中的数据到文件中进行备份
需要使用到 pymongo包
'''
from pymongo import MongoClient
import time
def mongo_conn(host,port,username,password,dbname):
    '''
    获取mongo的连接
    :return:
    '''
    print("start connection",host,port,username,password,dbname)
    conn = MongoClient(host=host, port=port)
    # admin 默认 可修改自定义库
    db = conn.admin
    # 密码
    db.authenticate(username, password)
    #查看所有集合
    # print(db.name, "库下的表有", db.collection_names())
    return db

def get_date():
    '''
    获取文件名 使用日期格式
    :return:
    '''
    return time.strftime("%Y-%m-%d", time.localtime(time.time()))

def getalldata(db,self_name):
    if db:
        print("要保存的库名:",db.name)
        print("要保存的集合名",self_name)
        #查找匹配字段和正则表达
        collection_key = "_id"
        regex_str = "on.*"
        colls = db[str(self_name)].find({collection_key:{'$regex' : regex_str}})
        for i in colls:
            # print(db.name,"中的数据：",i)
            #保存文件位置
            dir_name = "D:\company\project\git\med-note\develop\\"
            date = get_date()
            file_name = dir_name+date+'.txt'
            save_to_file(filename=file_name,data = i)
        print("文件保存完成，保存到",file_name)


def save_to_file(filename,data):
    '''
    追加数据写入文件
    :param filename: 文件名
    :param data:  数据
    :return:
    '''
    # print("保存到文件%s,内容是%s"%(filename,data))
    file = open(filename, "a+",encoding='utf8')
    file.write(str(data))
    file.write("\n")
    file.flush()

db = mongo_conn('127.0.0.1',27017,'username','password','dbname')
getalldata(db,"test")

# print(db.name, "库下的表有", db.collection_names())
