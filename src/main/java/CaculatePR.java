/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/18
 */

public class CaculatePR {

    /**
     * 计算pagerank的函数
     * @param link 页面的链接图
     * @param damp 设置的阻尼系数，佩奇设的是0.85
     * @param linkout 每个页面的链接总数
     * @param init 上次迭代的结果
     *
     * */
    public static double[] pagerank(int[][] link, double damp, int[] linkout,
                                    double[] init) {

        double[] pr = new double[init.length];
        double num = 0;
        for (int i = 0; i < init.length; i++) {
            for (int j = 0; j < init.length; j++) {
// 接下来的判断是关键,计算非本页面，和链接数不为0的页面,并且那个页面有连到本页面的值，即是links[j][i] !=0。
                if ((i != j) && (linkout[j] != 0) && (link[j][i] != 0))
                    num = num + init[j] / linkout[j];

            }
// pagerank的计算公式
            pr[i] = damp + (1 - damp) * num;
        }
        return pr;
    }
}

