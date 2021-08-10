/**
 * @author pangzj
 * @date:2021/8/10
 */
public class LeetCode977 {

    public static void main(String[] args) {
        System.out.println(sortedSquares(new int[]{-7,-3,2,3,11}).toString());
    }

    private static int[] sortedSquares(int[] num) {
        int[] res = new int[num.length];
        int k = num.length - 1;
        int i = 0;
        int j = num.length - 1;
        while (i <= j) {
            if (Math.pow(num[i], 2) <= Math.pow(num[j], 2)) {
                res[k--] = (int) Math.pow(num[j--], 2);
            } else {
                res[k--] = (int) Math.pow(num[i++], 2);
            }
        }
        return res;
    }
}
