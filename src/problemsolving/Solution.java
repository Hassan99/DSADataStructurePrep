package problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isAnagram("racecar","carrace"));
    }
    public boolean isAnagram(String s, String t) {

        int[] count = new int[26];
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            count[s.toCharArray()[i] - 'a']++;
            count[t.toCharArray()[i] - 'a']--;
        }
        for(int i:count){
            if(i!=0){
                return false;
            }
        }

        return true;

    }
    class CharacterCount{
        char ch;
        int count;
    }
}