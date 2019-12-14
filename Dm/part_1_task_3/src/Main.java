import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numsOfVertexes;
        int numsOfEdges;
        ArrayList[] adjacencyList;
        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);
            numsOfVertexes = scanner.nextInt();
            numsOfEdges = scanner.nextInt();
            adjacencyList = new ArrayList[numsOfVertexes];
            for(int i = 0; i < adjacencyList.length; i++){
                adjacencyList[i] = new ArrayList<Integer>();
                adjacencyList[i].add(0);
            }
            for(int i = 0; i < numsOfEdges;i++){
                int vertex1 = scanner.nextInt();
                int vertex2 = scanner.nextInt();
                adjacencyList[vertex1 - 1].set(0,adjacencyList[vertex1 - 1].size());
                adjacencyList[vertex1 - 1].add(vertex2);
                adjacencyList[vertex2 - 1].set(0,adjacencyList[vertex2 - 1].size());
                adjacencyList[vertex2 - 1].add(vertex1);
            }
            FileWriter fileWriter = new FileWriter("output.txt");
            for(ArrayList adjacency : adjacencyList){
                for(Object element : adjacency) {
                    StringBuilder sb = new StringBuilder();
                    sb.append((int)element).append(" ");
                    fileWriter.write(sb.toString());
                }
                fileWriter.write("\n");
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
