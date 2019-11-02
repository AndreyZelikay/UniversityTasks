import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), StandardCharsets.UTF_8));
            Scanner scanner = new Scanner(br);
            scanner.nextLine();
            while(scanner.hasNext()){
                String route = scanner.nextLine();
                String[] data = route.split(" ");
                Vertex vertex1 = new Vertex(data[0]);
                Vertex vertex2 = new Vertex(data[1]);
                graph.addEdge(vertex1,vertex2,Integer.parseInt(data[2]));
                br.close();
            }
            graph.getShortestRoute(new Vertex("Минск"), new Vertex("Заславль"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
