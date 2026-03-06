package ds.stackds;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class FindBracketsAreMatched {
    List<Character> leftBrackets = Arrays.asList('<', '(', '[', '{');
    List<Character> rightBrackets = Arrays.asList('>', ')', ']', '}');

    public boolean findBracketsAreMatchedOrNot(String data) {
        Stack<Character> stack = new Stack<>();
        if (data == null || data.isEmpty())
            return false;

        for (char newChar : data.toCharArray()) {
            if (isLeftBracket(newChar)) {
                stack.push(newChar);
            }
            else if (isRightBracket(newChar)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isBracketMatches(top, newChar)) {
                    return false;
                }
            }

        }
        return stack.isEmpty();

    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean isBracketMatches(char left, char right) {
        boolean isMatched = leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
        return isMatched;
    }
}
