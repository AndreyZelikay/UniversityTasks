import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Function {

    public static int INF = 1000;

    public static HashMap<String, ArrayList> DijkstraAlgoritm(HashMap<Vertex,ArrayList<Pair>> adjacencyList, Vertex fromVertex){
        ArrayList<Vertex> parents = new ArrayList<>(adjacencyList.size());
        ArrayList<Integer> distances = new ArrayList<>(adjacencyList.size());
        boolean[] isUsed = new boolean[adjacencyList.size()];
        Arrays.fill(isUsed, false);
        Collections.fill(distances,INF);
        //distances.set(adjacencyList.get())
        for(int i = 0; i < adjacencyList.size(); i++){


        }

        HashMap<String, ArrayList> results = new HashMap<>();
        results.put("parents", parents);
        results.put("distances", distances);
        return results;
    }
}
