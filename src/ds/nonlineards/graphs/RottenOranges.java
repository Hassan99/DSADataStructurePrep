package ds.nonlineards.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    int rottingOranges(int[][] grid){
        int rows = grid.length; // Finding the number of rows
        int cols = grid[0].length; // Finding th number of columns


        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c] == 2){ //Filling the Array with Rotten oranges
                    queue.add(new int[]{r,c});
                }else if(grid[r][c]==1){ // if fresh oranges means, increase its quantity
                    freshOranges++;
                }
            }
        }


        if(freshOranges==0){ // if No fresh oranges, return immediately with 0 mins
            return 0;
        }
        int minuts =0;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean rottenAnyInThisMinute = false;
            for (int i = 0;i<size;i++){
                int[] poll = queue.poll();
                int curentR = poll[0];
                int curentC = poll[1];
                for (int[] j:directions){
                    int nextRow =curentR + j[0];
                    int nextCol =curentC + j[1];
                    if (nextRow>=0 && nextRow<rows && nextCol >=0 && nextCol <cols&& grid[nextRow][nextCol]==1){
                        grid[nextRow][nextCol]=2;
                        queue.add(new int[]{nextRow,nextCol});
                        rottenAnyInThisMinute =true;
                        freshOranges--;
                    }
                }
            }
            if(rottenAnyInThisMinute){
                minuts++;
            }

        }



        return freshOranges == 0 ? minuts : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        RottenOranges ro = new RottenOranges();
        System.out.println(ro.rottingOranges(grid)+" Mins");
    }

            /*
                    Column 0	    Column 1	    Column 2
                    2 (அழுகிய பழம்)	1 (நல்ல பழம்)	1 (நல்ல பழம்)
                    1 (நல்ல பழம்)	1 (நல்ல பழம்)	0 (காலி இடம்)
                    0 (காலி இடம்)	1 (நல்ல பழம்)	1 (நல்ல பழம்)
            */

}
