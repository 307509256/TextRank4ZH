/**
 * @Description: 分词 基于 ansj
 * @Author: J.Y.Zhang
 * @Date: 2017/10/15
 */
public class Segmentation {
    private String text;
    private boolean lower = true, use_stop_words = true, use_speech_tags_filter = true;

    public void  segment(String text, boolean lower, boolean use_stop_words, boolean use_speech_tags_filter){
        /** 对一段文本进行分词，返回list类型的分词结果
        Keyword arguments:
        lower                  -- 是否将单词小写（针对英文）
        use_stop_words         -- 若为True，则利用停止词集合来过滤（去掉停止词）
        use_speech_tags_filter -- 是否基于词性进行过滤。若为True，则使用self.default_speech_tag_filter过滤。否则，不过滤。
        */
    }
}
