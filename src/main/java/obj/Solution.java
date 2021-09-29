package obj;

import java.util.*;

/**
 * @Title: Solution
 * @Package: obj
 * @description:
 * @author: Stackingrule
 * @created: 2021/09/23 23:07
 * @Copyright: Copyright (c) 2020
 * @version: v1.0
 */

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        if (s == null || s.length() == 0) {
            return false;
        }

        int n = s.length();

        if (n % 2 == 1) return false;
        Map<Character, Character> m = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        //Deque<Character> stack = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            if (m.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != m.get(c)) {
                    return false;
                }
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "({[]})";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}