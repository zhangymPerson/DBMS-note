package cn.danao.util.string;


import cn.danao.exception.CodeMsg;
import cn.danao.exception.GlobalException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author danao
 * @version 1.0
 * @classname PropertiesUtils
 * @descriptionclass 1.类的作用
 * 2.其他说明
 * @createdate 2019/7/3 10:04
 * @since 1.0
 */
public class PropertiesUtils {

    /**
     * 默认当前类的classload
     */
    public static ClassLoader classLoader = PropertiesUtils.class.getClassLoader();



    public static String getPropertieskey(String key,String fileName){
        return getPropertieskey(key,classLoader,fileName);
    }

    public static String getPropertieskey(String key,ClassLoader classLoader,String fileName){
        if(classLoader == null || fileName == null ||fileName.equals("")||key ==null || key.equals("")){
            return "";
        }
        return getProperties(classLoader,fileName).getProperty(key);

    }

    /**
     * 获取参数配置文件
     * @param classLoader
     * @param fileName
     * @return
     */
    public static Properties getProperties(ClassLoader classLoader,String fileName){
        InputStream in = classLoader.getResourceAsStream(fileName);
        Properties properties = new Properties();
        try {
            if(in != null){
                properties.load(in);
            }else {
                throw new GlobalException(CodeMsg.FILE_NOT_FIND.fillArgs(fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new GlobalException(CodeMsg.FILE_NOT_FIND.fillArgs(fileName));
        }
        return properties;
    }

}
