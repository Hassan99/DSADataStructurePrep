package ds.nonlineards.graphs;

import java.util.*;

public class GraphCity {


    Map<String, List<String>> cities = new HashMap<>();
    public GraphCity(){
        cities.put("Chennai", Arrays.asList("Trichy","Coimbatore"));
        cities.put("Trichy", Arrays.asList("Madurai"));
        cities.put("Coimbatore", Arrays.asList("Madurai"));
        cities.put("Madurai", new ArrayList<>());

    }
    public void startBFS(){
        bfs(cities,"Chennai");
    }
    private void bfs(Map<String,List<String>> cities,String startingCity){

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(startingCity);
        visited.add(startingCity);

        while(!queue.isEmpty()){
           String curntCity = queue.poll();
           for(String neibour:cities.get(curntCity)){
               if(!queue.contains(neibour)){
                   queue.add(neibour);
                   visited.add(neibour);
               }
           }
        }
        System.out.println(visited.toString());


    }

    public static void main(String[] args) {
        GraphCity graphCity = new GraphCity();
        graphCity.startBFS();
    }

}
