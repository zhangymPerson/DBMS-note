package cn.danao;

import cn.danao.util.string.ScannerUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

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
        int m = 3;
        List<String> params =  ScannerUtils.getString(3);
        log.info("您输入的参数是 {} ",params);
    }

}
