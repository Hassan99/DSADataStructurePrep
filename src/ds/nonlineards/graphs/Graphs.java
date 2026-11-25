package ds.nonlineards.graphs;

import java.util.ArrayList;
import java.util.List;

public class Graphs {
    int[][] edges  = {{0,1},{0,2},{1,3}};
    int vertices = 4;
    List<Integer>[] routes = new ArrayList[vertices];


    public Graphs(){
        for(int i = 0;i<4;i++){
            routes[i] = new ArrayList<>();
        }
        for(int[] value:edges){
            int e = value[0];
            int v = value[1];
            routes[e].add(v);
        }
    }

    public static void main(String[] args) {
        Graphs graphs = new Graphs();
    }
}
