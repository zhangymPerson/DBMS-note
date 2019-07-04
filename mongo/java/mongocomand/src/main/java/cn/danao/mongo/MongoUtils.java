package cn.danao.mongo;

import cn.danao.util.string.PropertiesUtils;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;


/**
 * @author danao
 * @version 1.0
 * @classname MongoUtils
 * @descriptionclass 1.Mongo数据库操作的工具类
 * 2.其他说明
 * @createdate 2019/7/3 11:36
 * @since 1.0
 */
@Slf4j
public class MongoUtils {

    /**
     * 这段可以直接使用连接工具获取
     */

    public static MongoClient mongoClient;

    static {
        //读取参数 获取连接
        String host = PropertiesUtils.getPropertieskey("mongo-host", "mongo.properties");
        String ports = PropertiesUtils.getPropertieskey("mongo-port", "mongo.properties");
        String db = PropertiesUtils.getPropertieskey("mongo-db", "mongo.properties");
        String username = PropertiesUtils.getPropertieskey("mongo-username", "mongo.properties");
        String password = PropertiesUtils.getPropertieskey("mongo-password", "mongo.properties");
        String connectTimeout = PropertiesUtils.getPropertieskey("connectTimeout", "mongo.properties");
        String maxWaitTime = PropertiesUtils.getPropertieskey("maxWaitTime", "mongo.properties");
        String socketTimeout = PropertiesUtils.getPropertieskey("socketTimeout", "mongo.properties");
        String connectionsPerHost = PropertiesUtils.getPropertieskey("connectionsPerHost", "mongo.properties");
        String threadsAllowedToBlockForConnectionMultiplier = PropertiesUtils.getPropertieskey("threadsAllowedToBlockForConnectionMultiplier", "mongo.properties");
        //查看参数是否正确读取
        //SelfDefaultLogUtil.printAll(host,port,db,username,password,connectTimeout,maxWaitTime,socketTimeout,connectionsPerHost,threadsAllowedToBlockForConnectionMultiplier);
        //配置参数
        mongoClient = MongoConnectionUtils.getMongClient(username, password, host, ports);
        log.info("mongoClient {} ", mongoClient);
    }

    /**
     * @param mongoClient
     * @param dbName
     * @return
     */
    public static MongoDatabase getDB(MongoClient mongoClient, String dbName) {
        if (mongoClient != null && dbName != null && !"".equals(dbName)) {
            MongoDatabase database = mongoClient.getDatabase(dbName);
            return database;
        }
        return null;
    }

    /**
     * 使用默认配置
     *
     * @param dbName
     * @return
     */
    public static MongoDatabase getDB(String dbName) {
        return getDB(mongoClient, dbName);
    }


    public static MongoCollection<Document> getCollection(MongoClient mongoClient, String dbName, String collName) {
        if (null == collName || "".equals(collName)) {
            return null;
        }
        if (null == dbName || "".equals(dbName)) {
            return null;
        }
        MongoCollection<Document> collection = mongoClient.getDatabase(dbName).getCollection(collName);
//		System.out.println(collection);
        return collection;
    }

    public static MongoCollection<Document> getCollection(String dbName, String collName) {
        return getCollection(mongoClient, dbName, collName);
    }


    public static List<String> getAllCollections(MongoClient mongoClient, String dbName) {
        //long binganshouye = count(dbName, "binganshouye");
        MongoIterable<String> colls = getDB(mongoClient, dbName).listCollectionNames();
        List<String> list = new ArrayList<String>();
        for (String s : colls) {
            list.add(s);
        }
        return list;
    }

    public static List<String> getAllCollections(String dbName) {
        return getAllCollections(mongoClient, dbName);
    }
}
