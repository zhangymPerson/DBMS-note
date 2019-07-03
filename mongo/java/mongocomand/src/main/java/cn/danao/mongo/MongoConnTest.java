package cn.danao.mongo;

import cn.danao.exception.CodeMsg;
import cn.danao.exception.GlobalException;
import cn.danao.util.string.PropertiesUtils;
import com.mongodb.*;
import com.sun.deploy.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @classname MongoConnTest
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/3 9:59
 * @since 1.0
 */
@Slf4j
public class MongoConnTest {

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
        String threadsAllowedToBlockForConnectionMultiplier = PropertiesUtils.getPropertieskey("threadsAllowedToBlockForConnectionMultiplier","mongo.properties");
        //查看参数是否正确读取
        //SelfDefaultLogUtil.printAll(host,port,db,username,password,connectTimeout,maxWaitTime,socketTimeout,connectionsPerHost,threadsAllowedToBlockForConnectionMultiplier);
        //配置参数
        mongoClient = MongoConnectionUtils.getMongClient(username,password,host,ports);
        log.info("mongoClient {} ",mongoClient);
    }


    public static void main(String[] args) {
        System.out.println("test");
    }


}
