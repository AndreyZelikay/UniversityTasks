import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);

            int size = scanner.nextInt();
            int numOfVertexes = 7;
            boolean isEulerCount = true;

            ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

            for(int i = 0; i < numOfVertexes; i++){
                adjacencyList.add(new ArrayList<>());
            }

            for(int i = 0; i < size; i++){
                int firstVertex = scanner.nextInt();
                int secondVertex = scanner.nextInt();

                adjacencyList.get(firstVertex).add(secondVertex);
                adjacencyList.get(secondVertex).add(firstVertex);
            }

            boolean[] flags = new boolean[numOfVertexes];
            Arrays.fill(flags, false);

            int position = 0;
            for(int i = 0; i < adjacencyList.size(); i++){
                if(adjacencyList.get(i).size() != 0){
                    position = i;
                    break;
                }
            }

            dfs( position, adjacencyList, flags);

            for(int i = 0; i < adjacencyList.size(); i++){
                if(!flags[i] && adjacencyList.get(i).size() != 0){
                    isEulerCount = false;
                    break;
                }
                if(flags[i] && adjacencyList.get(i).size() % 2 != 0){
                    isEulerCount = false;
                    break;
                }
            }

            FileWriter fileWriter = new FileWriter("output.txt");

            if(isEulerCount){
                fileWriter.write("Yes");
            } else {
                fileWriter.write("No");
            }

            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    private static void dfs(int vertex, ArrayList<ArrayList<Integer>> adjacencyList, boolean[] flags){
        flags[vertex] = true;
        for (Integer element : adjacencyList.get(vertex)) {
            if (!flags[element]) {
                dfs(element, adjacencyList, flags);
            }
        }
    }
}
