/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/15
 */
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.*;
import org.apache.log4j.Logger;

import java.util.List;

public class ansjTest {
    private static Logger logger = Logger.getLogger(loggerTest.class);
    public static void main(String[] args){
        logger.info("ansjTest:");
        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        logger.info(ToAnalysis.parse(str));
        Result w = BaseAnalysis.parse(str);
        logger.info(w);
    }
}
