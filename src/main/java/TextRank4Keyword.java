import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/15
 */

public class TextRank4Keyword {
    private static Logger logger = Logger.getLogger(TextRank4Keyword.class);
    private String text;

    private int window = 2;
    private String[][] words_no_filter;    // 对sentences中每个句子分词而得到的两级列表
    private String[][] words_no_stopwords; // 去掉words_no_filter中的停止词而得到的两级列表
    private String[][] words_all_filters;  // 保留words_no_stop_words中指定词性的单词而得到的两级列表

    private String stop_words_file; // 指定停止词文件路径（一行一个停止词），若为其他类型，则使用默认停止词文件
    private String[] delimiters; // 符号 用来把文本拆成句子
    private String[] keywords;

    private Segmentation seg  = new Segmentation();

    /**
     * 无参数的构造函数
     */
    public TextRank4Keyword(){
        text = ""; //必须用双引号


    }

    /**
     *
     * @param text
     * @param window
     */
    public void analyse(String text,int window) {
        //System.out.println(text+ window);
        logger.info("analyse");
        List<List<String>> result = seg.segment(text=text);
        for(int i = 0; i < result.size(); i++){
            logger.info(result.get(i));
        }
        keywords = util.sort_words(window = window);



    };

    /**
     *
     * @param num
     * @param word_min_len
     * @return
     */
    public String[] get_keywords(int num, int word_min_len){
        String[] result;
        int count = 0;

        return keywords;
    }
}
