/**
 * @Description:
 * @Author: J.Y.Zhang
 * @Date: 2017/10/19
 */
public class CaculatePRtest {

        //double [][]s_array = {{0,0,0,0},{0.3333333333333333,0,0,1},{0.3333333333333333,0.5,0,0},{0.3333333333333333,0.5,1,0}};



    public static void main(String[] args) {
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

        double[][] link = {
                { 0, 1, 1, 0 },
                { 0, 0, 1, 0 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 0 }

        };
// 各点的总链出数量
        int[] linkOut = new int[link.length];
        for (int i = 0; i < link.length; i++) {
            for (int j = 0; j < link.length; j++) {
                linkOut[i] += link[i][j];
            }
        }
//定义一个初始数组并初始化，设所有的页面初始PR值都为1；
        double[] pr = new double[link.length];

        double[] init = new double[link.length];
        for (int i = 0; i < link.length; i++) {
            init[i] = 1.0;

        }
        pr = c.pagerank(link, damp, linkOut, init);

//我们进行10次迭代计算pagerank的值
        for(int i=0;i<10;i++){
            System.arraycopy(pr, 0, init, 0, link.length);
            pr = c.pagerank(link, damp, linkOut, pr);
        }

        for (int i = 0; i < link.length; i++) {
            System.out.println("PR(" + i + ") = " + pr[i]);
        }

    }
}
