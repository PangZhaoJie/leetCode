import java.util.Stack;

/**
 * @author pangzj
 * @date:2021/8/6
 */
public class LeetCode316 {

    public static void main(String[] args) {
        System.out.println(cal("cbacdcbc"));
    }

    private static String cal(String str) {
        boolean[] visit = new boolean[26];
        Stack<Character> stack = new Stack();
        int[] num = new int[26];
        int i = 0;
        while (i < str.length()) {
            char letter = str.charAt(i);
            num[letter - 'a']++;
            i++;
        }
        i = 0;
        while (i < str.length()) {
            char letter = str.charAt(i);
            num[letter - 'a']--;
            i++;
            if (visit[letter - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > letter) {
                if (num[stack.peek() - 'a'] == 0) {
                    break;
                }
                visit[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(letter);
            visit[letter - 'a'] = true;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() != null) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }
}
