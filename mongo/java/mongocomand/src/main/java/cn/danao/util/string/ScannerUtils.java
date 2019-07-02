package cn.danao.util.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author danao
 * @version 1.0
 * @classname ScannerUtils
 * @descriptionclass
 * 1.输入参数
 * 2.其他说明
 * @createdate 2019/7/2 17:53
 * @since 1.0
 */
public class ScannerUtils {


    /**
     * 使用控制台输入参数的工具类
     *
     * @param num    参数个数
     * @param params 参数说明列表
     * @return 参数的集合
     */
    public static List<String> getString(int num, List<String> params) {
        List<String> result = new ArrayList<String>();
        if (params == null || params.isEmpty() || params.size() != num) {
            for (int i = 0; i < num; i++) {
                System.out.println(String.format("请输入第%s个参数", i + 1));
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNext()) {
                    String arg = scanner.next();
                    result.add(arg);
                }
            }
        } else {
            for (int i = 0; i < params.size(); i++) {
                System.out.println(params.get(i));
                Scanner scanner = new Scanner(System.in);
                if (scanner.hasNext()) {
                    String arg = scanner.next();
                    result.add(arg);
                }
            }
        }
        return result;
    }

    /**
     * 使用控制台输入参数的工具类
     *
     * @param num 参数个数
     * @return 参数的集合
     */
    public static List<String> getString(int num) {
        return getString(num, null);
    }


}
