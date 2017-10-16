import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/15
 */
public class loggerTest {
    private static Logger logger = Logger.getLogger(loggerTest.class);

    public static void main(String[] args) {
        ArrayList List = new ArrayList();
        List.add("string");
        List.add("string2" );
//往数组中添加不同类型的元素

        String[] b = (String[]) List.toArray(new String[List.size()]);
        logger.info(List+b[0]);
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}

