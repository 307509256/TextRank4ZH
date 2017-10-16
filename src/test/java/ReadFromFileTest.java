import org.apache.log4j.Logger;

/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/15
 */
public class ReadFromFileTest {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger(loggerTest.class);
        String fileName = "src/test/doc/01.txt";
        String readResult;
        readResult = ReadFromFile.file2String(fileName,"utf8");
        logger.info(readResult);

        //ReadFromFile.readFileCode(fileName);
        //ReadFromFile.readFileByBytes(fileName);
        //ReadFromFile.readFileByChars(fileName);
        //ReadFromFile.readFileByLines(fileName);
        //ReadFromFile.readFileByRandomAccess(fileName);
    }
}
