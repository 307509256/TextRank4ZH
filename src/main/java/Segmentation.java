import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.recognition.impl.StopRecognition;
import org.ansj.splitWord.analysis.BaseAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: 分词 基于 ansj
 * @Author: J.Y.Zhang
 * @Date: 2017/10/15
 */
public class Segmentation {
    private static Logger logger = Logger.getLogger(Segmentation.class);
    private String text;
    private boolean lower = true, use_stop_words = true, use_speech_tags_filter = true;

    public Segmentation() {

    }

    public List<List<String>> segment(String text){
        /** 对一段文本进行分词，返回list类型的分词结果
        Keyword arguments:
        lower                  -- 是否将单词小写（针对英文）
        use_stop_words         -- 若为True，则利用停止词集合来过滤（去掉停止词）
        use_speech_tags_filter -- 是否基于词性进行过滤。若为True，则使用self.default_speech_tag_filter过滤。否则，不过滤。
        */
        String[] result = new String[] {"ss", "sss"};
        Result w = BaseAnalysis.parse(text);
        String[] sentences = SentenceSegmentation(text);
        List<List<String>> words = WordSegmentation(sentences);

        return words;
    }

    public String[] SentenceSegmentation(String text){
        logger.info("SentenceSeg");
        /* 去除换行符 空格 制表符 */
        text =text.replaceAll("\\s*", "");
        /*正则表达式：句子结束符*/
        String regEx="：|。|！|；|，|、 |! |; |？ |…… |… |、 |。|，";
        //['?', '!', ';', '？', '！', '。', '；', '……', '…', '\n']
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(text);
        String[] sentences = p.split(text);
        /*
        for( int i = 0; i < sentences.length; i++){
            logger.info(sentences[i]);
        }
        */
        return sentences;
    }

    public List<List<String>> WordSegmentation(String[] sentences){
        logger.info("WordSeg");
        //List<List<Term>> listTest = new ArrayList<List<Term>>();

        List<List<String>> sentenceWordsList = new ArrayList<List<String>>();
        for(int i = 0; i < sentences.length; i++){
            List<String> wordsList = new ArrayList<String>();
            StopRecognition filter = new StopRecognition();

            //filter.insertStopWords("我"); //过滤单词
            //调用过滤
            //Result modifResult = ToAnalysis.parse(sentences[i]).recognition(filter); //过滤分词结果

            Result result = ToAnalysis.parse(sentences[i]);
            List<Term> terms = result.getTerms(); //拿到terms

            for(int j = 0; j < terms.size(); j++){
                String word = terms.get(j).getName(); //拿到词
                wordsList.add(word);
            }
            sentenceWordsList.add(i, wordsList);

        }
        //logger.info(listTest);
        return sentenceWordsList;



    }
}
