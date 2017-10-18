import org.ujmp.core.DenseMatrix;
import org.ujmp.core.Matrix;

import java.util.*;

/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/15
 */
public class util {
    /**
     *
     * @param word_list1
     * @param word_list2
     */
    public int get_simliarity(String[] word_list1, String[] word_list2){

        return 0;
    }

    public void sort_sentences(){

    }

    public static List<String[]> combine(List<String> word_list, int window){
        /*构造在window下的单词组合，用来构造单词之间的边。*/
        if(window < 2){
            window = 2;
        }
        List<String[]> wordCombines = new ArrayList<>();
        for(int i = 1; i <  word_list.size(); i++){
            String[] wordCombine = new String[2];
            wordCombine[0] = word_list.get(i-1);
            wordCombine[1] = word_list.get(i);
            wordCombines.add(wordCombine);
        }
        return wordCombines;

    }




    public static String[] sort_words(List<List<String>> vertex_source, List<List<String>> edge_source, int i) {
        String[] sort_words = {};
        Map word_index = new HashMap();
        Map index_word = new HashMap();
        int words_number = 0;
        for(List<String> word_list: vertex_source){
            for(String word: word_list){
                System.out.println(word);
                boolean contains = word_index.containsKey(word);    //判断是否包含指定的键值
                if(contains == false){
                    //System.out.println("这个单词不在字典里");
                    word_index.put(word,words_number);
                    index_word.put(words_number,word);
                    words_number+=1;
                }

            }
            //System.out.println(word_index);
        }

        //Matrix graph = DenseMatrix.Factory.zeros(words_number, words_number);
        int[][] graph = new int[words_number][words_number];
        for (int[] column: graph){
            for(int position: column){
                position = 0;
            }
        }



        for(List<String> word_list: vertex_source){

            List<String[]> combineResult;
            combineResult = combine(word_list,2);

            for(int k = 0; k < combineResult.size();k++){
                //System.out.println(combineResult.get(k));
                String w1 = combineResult.get(k)[0];
                String w2 = combineResult.get(k)[1];
                if(word_index.containsKey(w1) && word_index.containsKey(w2) ){
                    int index1 = (int) word_index.get(w1);
                    int index2 = (int) word_index.get(w2);
                    System.out.println(index1+w1);
                    graph[index1][index2] = 1;
                    graph[index2][index1] = 1;
                }
            }

            //System.out.println(word_index);
        }
        /**
         * 22222
         */
        // 定义阻尼系数
        double damp = 0.85;
        CaculatePR c = new CaculatePR();
        /* 测试数据，表示四个网页相互之间的有向链接矩阵
         * 用矩阵形式表示
         *    A  B  C  D
         * A  0  1  1  0
         * B  0  0  1  0
         * C  1  1  0  0
         * D  0  1  1  0
         * */

        int[][] link = graph;
        for(int[] xx: link){
            for (int x : xx){
                System.out.println(x);
            }
        }
// 各点的总链出数量
        int[] linkOut = new int[link.length];
        for (i = 0; i < link.length; i++) {
            for (int j = 0; j < link.length; j++) {
                linkOut[i] += link[i][j];
            }
        }
//定义一个初始数组并初始化，设所有的页面初始PR值都为1；
        double[] pr = new double[link.length];

        double[] init = new double[link.length];
        for (i = 0; i < link.length; i++) {
            init[i] = 1.0;

        }
        pr = c.pagerank(link, damp, linkOut, init);

//我们进行10次迭代计算pagerank的值
        for(i=0;i<10;i++){
            System.arraycopy(pr, 0, init, 0, link.length);
            pr = c.pagerank(link, damp, linkOut, pr);
        }

        for (i = 0; i < link.length; i++) {
            System.out.println("PR(" + i + ") = " + pr[i]+ index_word.get(i));

        }

        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
        for (i = 0; i < link.length; i++) {
            map.put(""+pr[i],""+i);

        }
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
            System.out.println(index_word.get(Integer.parseInt(map.get(key)) ));

        }
        return sort_words;
    }
}
