package pers.robinz.kehu.util;

import java.util.Random;

/**
 * Created by Robinz on 2018-06-06.
 */
public class NumberRadomUtil {

    static int[] defaultSeed =
            {1, 2, 3, 4, 5, 6, 7, 8, 9};

    /**
     * 生成无符号的随机数字字符串
     *
     * @param sd 种子的最好不要超过1000个
     * @return
     */
    public static String getUnsignNumber(int[] sd) {

        int[] seed = sd;
        // 种子你可以随意生成，但不能重复
        if (null == sd || sd.length <= 0) {
            // 启用默认的seed
            seed = defaultSeed;
        }

        for (int i = 0; i < seed.length; i++) {
            seed[i] = Math.abs(seed[i]);
        }

        int[] ranArr = new int[seed.length];

        Random ran = new Random();

        // 数量你可以自己定义。

        for (int i = 0; i < seed.length; i++) {

            // 得到一个位置

            int j = ran.nextInt(seed.length - i);

            // 得到那个位置的数值

            ranArr[i] = seed[j];

            // 将最后一个未用的数字放到这里

            seed[j] = seed[seed.length - 1 - i];

        }

        // System.out.println("ranArr:" + Arrays.toString(ranArr));

        StringBuffer strB = new StringBuffer();

        for (int i : ranArr) {
            strB.append(i);
        }
        return strB.toString();
    }

    /**
     * 随机指定范围内N个不重复的数
     * 最简单最基本的方法
     *
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n   随机数个数
     */
    public static int[] randomCommon(int min, int max, int n) {
        if (n > (max - min + 1) || max < min) {
            return null;
        }
        int[] result = new int[n];
        int count = 0;
        while (count < n) {
            int num = (int) (Math.random() * (max - min)) + min;
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (num == result[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result[count] = num;
                count++;
            }
        }
        return result;
    }

    // public static void main(String[] args)
    // {
    // int[] sd =
    // { -1, 2, -3 };
    // String str = getUnsignNumber(sd);
    //
    // System.out.println(str);
    //
    // Random random = new Random();
    //
    // System.out.println(random.nextInt(9) + 1);
    // }
}