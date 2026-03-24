package ds.lineards.hashmapds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
//        System.out.println(String.valueOf(firstNonRepeatingCharacter.firstNonRepeatingCharacter("a green apple")));
        System.out.println(String.valueOf(firstNonRepeatingCharacter.firstRepeatingChar(" green apple")));
    }

    public char firstNonRepeatingCharacter(String data) {
        Map<Character, Integer> hashMap = new HashMap<>();

        for (char character : data.toCharArray()) {
            int count = hashMap.containsKey(character) ? hashMap.get(character) : 0;
            hashMap.put(character, count + 1);
        }

        for (char findChar : data.toCharArray()) {
            if (hashMap.get(findChar) ==1) {

               return findChar;
            }
        }


        return Character.MIN_VALUE;

    }

    public char firstRepeatingCharacter(String data) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char chars : data.toCharArray()) {
            int count = map.getOrDefault(chars, 0);
            map.put(chars, count + 1);
        }
        System.out.println(map);
        for (char chars : data.toCharArray()) {
            if (map.get(chars) > 1) {
                return chars;
            }
        }

        return '0';
    }

    public char firstRepeatingChar(String data) {
        Set<Character> sets = new HashSet<>();
        for (char ch : data.toCharArray()) {
            if (sets.contains(ch)) {
                return ch;
            }
            sets.add(ch);
        }

        return Character.MIN_VALUE;
    }
}
