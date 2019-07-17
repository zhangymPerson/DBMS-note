package cn.danao;

import cn.danao.mongo.MongoUtils;
import cn.danao.util.string.ScannerUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Scanner;

/**
 * @author danao
 * @version 1.0
 * @classname ApplicationStart
 * @descriptionclass
 * 1.测试类
 * 2.应用开始类
 * @createdate 2019/7/2 13:53
 * @since 1.0
 */
@Slf4j
public class ApplicationStart {

    public static void main(String[] args) {
        log.info("start");
        List<String> list = MongoUtils.getAllCollections("danao");
        log.info("{}",list);
        String tableName = ScannerUtils.getString("输入要查询的表名");
        MongoUtils.getDB(MongoUtils.defaultMongoClient,tableName);
    }

}
