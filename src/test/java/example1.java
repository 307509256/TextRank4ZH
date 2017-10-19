import org.apache.log4j.Logger;

import java.util.Map;

/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/16
 */
public class example1 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(loggerTest.class);
        String fileName = "src/test/doc/01.txt";
        Map<String, String> keyWords;
        String readResult;
        readResult = ReadFromFile.file2String(fileName,"utf8");
        //logger.info(readResult);

        //关键词

        TextRank4Keyword tr4k = new TextRank4Keyword();
        tr4k.analyse(readResult, 2);
        keyWords = tr4k.get_keywords(16,1);
        logger.info("关键词：");
        for (String  key : keyWords.keySet()) {
            String value = keyWords.get(key);
            logger.info("Key = " + key + "Value = " + value);
        }

        //摘要
        TextRank4Sentence tr4s = new TextRank4Sentence();
        tr4s.analyse(readResult, 2);
        keyWords = tr4s.get_keysentences(3,15);
        logger.info("摘要：");
        for (String  key : keyWords.keySet()) {
            String value = keyWords.get(key);
            logger.info("Key = " + key + "Value = " + value);
        }

    }
}
