package ds.stackds;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        FindBracketsAreMatched fbam = new FindBracketsAreMatched();
        System.out.println(fbam.findBracketsAreMatchedOrNot("<()[]{}"));
    }

   /* void reverseString() {
        StringBuffer sb = new StringBuffer();

        String data = "noorul hassan mohamed";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < data.length(); i++) {
            stack.push(String.valueOf(data.charAt(i)));
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        for (int i = (data.length() - 1); i >= 0; i--) {
            sb.append(data.charAt(i));
        }
        System.out.println(sb.toString());

    }*/
}
