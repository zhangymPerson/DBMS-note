package cn.danao.exception;

/**
 * @author zhang
 * @version 1.0
 * @classname GlobalException
 * @descriptionclass
 * 1.全局异常处理类
 * 2.自定义抛出异常类
 *
 * 使用方法
 *
 * try{
 *
 * }catch(GlobalException e){
 *     throw new GlobalException(CodeMsg.*****)
 * }
 *
 * @createdate 2019/2/14
 * @since 1.0
 */
public class GlobalException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private CodeMsg codeMsg;

	public GlobalException(CodeMsg cm) {
		super(cm.toString());
		this.codeMsg = cm;
	}

	public GlobalException(CodeMsg cm, Exception ex) {
		super(cm.toString());
		this.codeMsg = cm;
		this.codeMsg.setMsg(this.codeMsg.getMsg() + "\\r\\n" + ex.getMessage());
	}

	public CodeMsg getCm() {
		return codeMsg;
	}

}
