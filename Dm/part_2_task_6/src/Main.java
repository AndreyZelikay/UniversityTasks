import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("input.txt");

            Scanner scanner = new Scanner(fileReader);

            int numOfVertexes = scanner.nextInt();
            int numOfEdges = scanner.nextInt();

            boolean isSimpleGraph = true;
            boolean isMultiGraph = true;

            if(numOfEdges > numOfVertexes*(numOfVertexes-1)/2){
                isSimpleGraph = false;
            }

            ArrayList[] adjacencyList = new ArrayList[numOfVertexes];

            for (int i = 0; i < adjacencyList.length; i++) {
                adjacencyList[i] = new ArrayList();
            }

            for(int i = 0; i < numOfEdges; i++){
                int firstVertex = scanner.nextInt() - 1;
                int secondVertex = scanner.nextInt() - 1;

                if(firstVertex == secondVertex){
                    isSimpleGraph = false;
                    isMultiGraph = false;
                    break;
                }
                else if(isSimpleGraph && adjacencyList[firstVertex].indexOf(secondVertex) != -1){
                    isSimpleGraph = false;
                }
                else {
                    adjacencyList[firstVertex].add(secondVertex);
                    adjacencyList[secondVertex].add(firstVertex);
                }
            }

            FileWriter fileWriter = new FileWriter("output.txt");

            if(isSimpleGraph){
                fileWriter.write("Yes\nYes\nYes");
            }
            else if(isMultiGraph){
                fileWriter.write("No\nYes\nYes");
            }
            else {
                fileWriter.write("No\nNo\nYes");
            }

            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }
}
