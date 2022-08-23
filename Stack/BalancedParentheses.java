package Stack;

import java.util.ArrayDeque;

public class BalancedParentheses {
    public static void main(String[] args) {
        String str = "{}([()])";
        System.out.println(checkParentheses(str));
    }

    static boolean checkParentheses(String str) {
        ArrayDeque<Character> st = new ArrayDeque<>();

        int i = 0;

        while (i < str.length()) {
            switch (str.charAt(i)) {
                case '{':
                case '(':
                case '[':
                    st.add(str.charAt(i));
                    i++;
                    break;
                case '}':
                    if (!st.isEmpty() && st.peekLast().equals('{')) {
                        st.removeLast();
                        i++;
                        break;
                    } else return false;
                case ')':
                    if (!st.isEmpty() && st.peekLast().equals('(')) {
                        st.removeLast();
                        i++;
                        break;
                    } else return false;
                case ']':
                    if (!st.isEmpty() && st.peekLast().equals('[')) {
                        st.removeLast();
                        i++;
                        break;
                    } else return false;
            }
        }

        return st.isEmpty();
    }
}
