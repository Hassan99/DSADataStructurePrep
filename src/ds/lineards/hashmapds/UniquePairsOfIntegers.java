package ds.lineards.hashmapds;

import java.util.HashSet;

public class UniquePairsOfIntegers {
    public void printUniquePairsOfIntegers(int[] array,int k){
        HashSet<Integer> hashSet = new HashSet<>();

        for(int n:array){
            hashSet.add(n);
        }
        StringBuffer sb = new StringBuffer();
        for(Integer item:hashSet){
            int pairValue = item+k;
            if(hashSet.contains(pairValue)){
                sb.append("(").append(item).append(",").append(pairValue).append(")");
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

        System.out.println(hashSet);

    }

    public static void main(String[] args) {
        UniquePairsOfIntegers uniquePairsOfIntegers = new UniquePairsOfIntegers();
        uniquePairsOfIntegers.printUniquePairsOfIntegers(new int[]{1, 7, 5, 9, 2, 12, 3},2);
    }
}
