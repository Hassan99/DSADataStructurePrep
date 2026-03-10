package ds.hashmapds;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        FirstNonRepeatingCharacter firstNonRepeatingCharacter = new FirstNonRepeatingCharacter();
        System.out.println(String.valueOf(firstNonRepeatingCharacter.firstNonRepeatingCharacter("a green apple")));
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
}
