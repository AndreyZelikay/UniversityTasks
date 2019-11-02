import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<Vertex,ArrayList<Pair>> adjacencyList;

    public Graph(){
        adjacencyList = new HashMap<>();
    }

    public void addEdge(Vertex firstVertex, Vertex secondVertex, int weight) {
        this.addVertex(firstVertex);
        this.addVertex(secondVertex);

        this.getAdjacency(firstVertex).add(new Pair(secondVertex, weight));
        this.getAdjacency(secondVertex).add(new Pair(firstVertex, weight));
    }

    public ArrayList<Pair> getAdjacency(Vertex vertex){
        for(HashMap.Entry<Vertex,ArrayList<Pair>> adjacency : adjacencyList.entrySet()){
            if(adjacency.getKey().equals(vertex)) {
                return adjacency.getValue();
            }
        }
        return null;
    }

    public void addVertex(Vertex vertex){
        for(HashMap.Entry<Vertex,ArrayList<Pair>> adjacency : adjacencyList.entrySet()){
            if(adjacency.getKey().equals(vertex)) {
                return;
            }
        }
        adjacencyList.put(vertex, new ArrayList<>());
    }

    public ArrayList<String> getShortestRoute(Vertex fromVertex, Vertex toVertex){
        ArrayList<String> route = new ArrayList<>();
        return route;
    }

}
