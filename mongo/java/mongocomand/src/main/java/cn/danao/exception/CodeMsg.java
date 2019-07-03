package cn.danao.exception;

/**
 * @author zhang
 * @version 1.0
 * @classname CodeMsg
 * @descriptionclass
 * 1.自定义异常参考值
 * 2.单例模式，所有得异常都在该类中定义好，不能随便自定义，方便异常得处理
 * @createdate 2019/2/14
 * @since 1.0
 */
public class CodeMsg {

    private int code;
    private String msg;

    //通用的错误码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");

    public static CodeMsg CREATR_FILE_FAIL = new CodeMsg(500100,"创建文件失败");

    public static CodeMsg FILE_NOT_FIND = new CodeMsg(500200,"文件%s不存在,请检查!");
    public static CodeMsg MONGODB_START_FAIL = new CodeMsg(500200,"mongdb数据库连接失败，请检查配置文件和数据库状态");

    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
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

    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }

    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }
}
