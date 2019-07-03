package cn.danao.mongo;

import cn.danao.exception.CodeMsg;
import cn.danao.exception.GlobalException;
import cn.danao.util.string.PropertiesUtils;
import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danao
 * @version 1.0
 * @classname MongoConnectionUtils
 * @descriptionclass 1.获取mongo的连接的工具类
 * 2.其他说明
 * @createdate 2019/7/3 11:10
 * @since 1.0
 */
public class MongoConnectionUtils {


    /**
     * 获取mongodb 的 连接 默认连接的是admin库
     *
     * @param username
     * @param password
     * @param host
     * @param port
     * @return
     */
    public static MongoClient getMongClient(String username, String password, String host, String port) {
        String connectTimeout = "3000";
        String maxWaitTime = "2000";
        String socketTimeout = "0";
        String connectionsPerHost = "300";
        String threadsAllowedToBlockForConnectionMultiplier = "10";
        return getMongClient(username, password, host, port, connectionsPerHost, connectTimeout, maxWaitTime, socketTimeout, threadsAllowedToBlockForConnectionMultiplier);
    }


    /**
     * 获取mongo的连接工具
     *
     * @param username
     * @param password
     * @param host
     * @param port
     * @param connectionsPerHost
     * @param connectTimeout
     * @param maxWaitTime
     * @param socketTimeout
     * @param threadsAllowedToBlockForConnectionMultiplier
     * @return
     */
    public static MongoClient getMongClient(String username, String password, String host, String port, String connectionsPerHost, String connectTimeout, String maxWaitTime, String socketTimeout, String threadsAllowedToBlockForConnectionMultiplier) {
        //配置参数
        MongoClient mongoClient = null;
        if (mongoClient == null) {
            MongoClientOptions.Builder options = new MongoClientOptions.Builder();
            options.connectionsPerHost(Integer.parseInt(connectionsPerHost));//连接池设置为300个连接,默认为100
            options.connectTimeout(Integer.parseInt(connectTimeout));// 连接超时，推荐>3000毫秒
            options.maxWaitTime(Integer.parseInt(maxWaitTime)); //
            options.socketTimeout(Integer.parseInt(socketTimeout));// 套接字超时时间，0无限制
            // 线程队列数，如果连接线程排满了队列就会抛出“Out of semaphores to get db”错误。
            options.threadsAllowedToBlockForConnectionMultiplier(Integer.parseInt(threadsAllowedToBlockForConnectionMultiplier));
            options.writeConcern(WriteConcern.SAFE);
            options.build();
            MongoClientOptions myOptions = options.build();
            try {
                //数据库连接实例
                Integer ports = Integer.parseInt(port);
                String hosts[] = host.split(",");
                List<ServerAddress> serverAddressList = new ArrayList<>();
                for (String everyHost : hosts) {
                    ServerAddress address = new ServerAddress(everyHost, ports);
                    serverAddressList.add(address);
                }
                //默认的数据库
                String db = "admin";
                String dbName = db;
                String userName = username;
                String pwd = password;

                if (userName == null || pwd == null || "".equals(userName) || "".equals(pwd)) {
                    mongoClient = new MongoClient(serverAddressList, myOptions);
                } else {
                    MongoCredential mongoCredential = MongoCredential.createCredential(userName, dbName, pwd.toCharArray());
                    List<MongoCredential> credentials = new ArrayList<>();
                    credentials.add(mongoCredential);
                    mongoClient = new MongoClient(serverAddressList, mongoCredential, myOptions);
                    if (mongoClient == null) {
                        throw new GlobalException(CodeMsg.MONGODB_START_FAIL);
                    } else {
                        System.out.println(mongoClient);
                    }
                }
            } catch (Exception ignored) {
                throw new GlobalException(CodeMsg.MONGODB_START_FAIL);
            }
        }
        return mongoClient;
    }
}