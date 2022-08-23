package Stack;

import java.util.ArrayDeque;

public class InfixToPostfix {
    public static void main(String[] args) {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(str));
    }

    public static String infixToPostfix(String exp)
    {
        StringBuilder res = new StringBuilder();
        ArrayDeque<Character> s = new ArrayDeque<>();

        for(int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                res.append(ch);
            }
            else if (ch == '(') {
                s.push(ch);
            }
            else if (ch == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    res.append(s.pop());
                }
                s.pop();
            }
            else {
                while (!s.isEmpty() && precedence(ch) <= precedence(s.peek()) && isL2RA(ch)) {
                    res.append(s.pop());
                }
                s.push(ch);
            }
        }

        while (!s.isEmpty()) {
            res.append(s.pop());
        }

        return res.toString();
    }

    private static boolean isL2RA(char ch){
        return ch != '^';
    }

    private static int precedence(char ch){
        if(ch == '+' || ch == '-')
            return 1;
        else if(ch == '*' || ch == '/')
            return 2;
        else if( ch == '^')
            return 3;
        else
            return -1;
    }
}
