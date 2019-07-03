package cn.danao.util.string;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author danao
 * @version 1.0
 * @classname ApplicationTest
 * @descriptionclass
 * 自定义打印工具类
 * todo 测试完删除
 * 日志格式
 *      2019-06-26T10:42:16.767  [INFO] [ [SelfDefaultLogUtil 打印的信息]  [具体的日志内容]]
 * @createdate 2019/6/24 17:37
 * @since 1.0
 * @Version 1.1
 */
public class SelfDefaultLogUtil {


    /**
     * 根据自己测试内容自定义
     */
    private static String defaultStr = "SelfDefaultLogUtil 打印的信息";

    /**
     * 枚举
     * 日志级别
     */
    enum Level {
        /**
         * 打印信息级别
         */
        INFO("INFO"),
        TEST("TEST"),
        WARN("WARN"),
        ERROE("ERROR"),
        BUGER("BUGER"),
        EXCEPTION("EXCEPTION");
        private String level;

        Level(String level) {
            this.level = level;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return "Level{" +
                    "level='" + level + '\'' +
                    '}';
        }
    }

    /**
     * 日志格式
     * 统一格式为
     * {"code":200,"msg":" [自定义打印信息]  this object is null"}
     */
    static class LogInfo {

        /**
         * 日期格式
         */
        private static String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

        /**
         * 日志分割符
         */
        private static String LINEA = "*****************************************************************************************";
        private static String LINEB = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
        private static String LINEC = "=======================================================================";
        private static String LINED = "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$";


        /**
         * 配置好的日志
         */
        public static LogInfo BaseLog = new LogInfo(100, "默认输出", Level.INFO);
        public static LogInfo BaseBugerLog = new LogInfo(102, "[%s]", Level.BUGER);
        public static LogInfo BaseInfoLog = new LogInfo(200, "[%s]", Level.INFO);
        public static LogInfo BaseTestLog = new LogInfo(202, "[%s]", Level.TEST);
        public static LogInfo BaseWarnLog = new LogInfo(110, "[%s]", Level.WARN);
        public static LogInfo BaseExceptionLog = new LogInfo(550, "[%s]", Level.EXCEPTION);
        public static LogInfo BaseErrorLog = new LogInfo(500, "[%s]", Level.ERROE);

        private int code;
        private String msg;
        private Level level;

        public LogInfo() {
        }

        public int getCode() {
            return code;
        }

        /**
         * @param localDateTime
         * @param dataformat
         * @return
         */
        public static String getDate(LocalDateTime localDateTime, String dataformat) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dataformat);
            String formattedDateTime = localDateTime.format(formatter);
            System.out.println(formattedDateTime);
            return formattedDateTime;
        }

        public LogInfo(int code, String msg, Level level) {
            this.code = code;
            this.msg = String.format("%s  [%s] [%s] ", LocalDateTime.now(), level.getLevel(), msg);
            this.level = level;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public LogInfo replaceString(Object... args) {
            this.code = code;
            this.level = level;
            this.msg = String.format(msg, args);
            return new LogInfo(code, msg, level);
        }

        @Override
        public String toString() {
            return "LogInfo{" +
                    "code=" + code +
                    ", msg='" + msg + '\'' +
                    ", level=" + level +
                    '}';
        }
    }


    /**
     * 自定义打印信息
     *
     * @param info       日志信息
     * @param level      级别
     * @param isDefault  是否打印默认值
     * @param defaultStr 默认值
     */
    public static void printLevelInfo(String info, Level level, boolean isDefault, String defaultStr) {
        LogInfo logInfo = LogInfo.BaseLog;
        if (level.getLevel().equals(Level.BUGER.getLevel())) {
            logInfo = LogInfo.BaseBugerLog;
        }
        if (level.getLevel().equals(Level.INFO.getLevel())) {
            logInfo = LogInfo.BaseInfoLog;
        }
        if (level.getLevel().equals(Level.TEST.getLevel())) {
            logInfo = LogInfo.BaseTestLog;
        }
        if (level.getLevel().equals(Level.EXCEPTION.getLevel())) {
            logInfo = LogInfo.BaseExceptionLog;
        }
        if (level.getLevel().equals(Level.ERROE.getLevel())) {
            logInfo = LogInfo.BaseErrorLog;
        }
        if (isDefault) {
            String infos = String.format(" [%s]  [%s]", defaultStr, info);
            //静态内部类 只初始化一次，所以每次需要把msg对象置空 不然打印的信息不变
            logInfo.setMsg("%s");
            System.out.println(logInfo.replaceString(infos).getMsg());
        } else {
            logInfo.setMsg("%s");
            System.out.println(logInfo.replaceString(String.format(info)).getMsg());
        }
    }


    /**
     * 自定义打印信息
     *
     * @param info
     */
    public static void print(Object info) {
        //System.out.println(LogInfo.BaseInfoLog);
        String str = "this object is null";
        if (info != null) {
            str = info.toString();
        }
        printLevelInfo(str, Level.INFO, true, defaultStr);
    }

    /**
     * 自定义打印信息
     *
     * @param info
     */
    public static void print(Object info, String defaultInfo) {
        //System.out.println(LogInfo.BaseInfoLog);
        String str = "this object is null";
        if (info != null) {
            str = info.toString();
        }
        if (defaultInfo == null) {
            printLevelInfo(str, Level.INFO, true, defaultStr);
        } else {
            printLevelInfo(str, Level.INFO, true, defaultInfo);
        }
    }

    /**
     * 自定义打印信息
     *
     * @param info
     */
    public static void printAll(Object... info) {
        if (info == null || info.length == 1) {
            print(info);
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < info.length; i++) {
                if (info[i] == null) {
                    sb.append("this object is null ;");
                } else {
                    sb.append(info[i].toString() + " ;");
                }
            }
            print(sb.toString());
        }
    }

    /**
     * 自定义打印信息
     *
     * @param info
     */
    public static void printAllDefault(String defaultInfo,Object... info) {
        if (info == null || info.length == 1) {
            print(info);
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < info.length; i++) {
                if (info[i] == null) {
                    sb.append("this object is null ;");
                } else {
                    sb.append(info[i].toString() + " ;");
                }
            }
            print(sb.toString(),defaultInfo);
        }
    }

    /**
     * 自定义打印信息
     * 打印换行
     *
     * @param info
     */
    public static void printAllLineFeed(Object... info) {
        if (info == null || info.length == 1) {
            print(info);
        } else {
            for (int i = 0; i < info.length; i++) {
                print(info[i]);
            }
        }
    }


    public static void main(String[] args) {
        //System.out.println("测试专用类");
        //打印内容，自定义打印信息
        print("test", "ceshi ");
        //默认打印
        print(1);
        //打印所有参数
        printAll(1, "2", 3, "4", null, 4545);
        //打印所有参数 第一个参数为修改的默认内容
        printAllDefault("默认info",1,2,4,"ceshi ","!@!#$#@$#@%$");
        //打印所有参数，一个参数一行
        printAllLineFeed(true, 1, "2", 3, "4", null, 4545);
    }

}
