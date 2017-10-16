import org.apache.log4j.Logger;

/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/16
 */
public class example1 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(loggerTest.class);
        String fileName = "src/test/doc/01.txt";
        String readResult;
        readResult = ReadFromFile.file2String(fileName,"utf8");
        //logger.info(readResult);

        TextRank4Keyword tr4k = new TextRank4Keyword();

        tr4k.analyse(readResult, 2);

        //logger.info(tr4k.get_keywords()[0]);
    }
}
