package ds.lineards.hashmapds;

import java.util.HashSet;

public class IndicesOfTwoNumbers {

    public void indicesOfTwoNumber(int[] array,int expectedNo){
        HashSet<Integer> hashSet = new HashSet<>();
        for(int item:array){
            hashSet.add(item);
        }
        System.out.println(hashSet);
        int index=0;
        int previousNo = -1;
        boolean isFOund = false;
        for(Integer np:hashSet){
            if((previousNo+np) == expectedNo){
                isFOund = true;
                break;
            }
            previousNo = np;
            index++;

        }
        if(isFOund) {
            System.out.println("Two Sum indeces are:(" + (index - 1) + "," + index + ")");
        }else{
            System.out.println("Not found");
        }


    }

    public static void main(String[] args) {
        IndicesOfTwoNumbers indicesOfTwoNumbers = new IndicesOfTwoNumbers();
        indicesOfTwoNumbers.indicesOfTwoNumber(new int[]{2, 7, 11,14,18,8,3,15},20);
    }
}
