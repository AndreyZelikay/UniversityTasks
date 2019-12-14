import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numsOfVertexes;
        int numsOfEdges;
        Integer[][] matrix;
        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);
            numsOfVertexes = scanner.nextInt();
            numsOfEdges = scanner.nextInt();
            matrix = new Integer[numsOfVertexes][numsOfVertexes];
            for(int i = 0; i< numsOfVertexes; i++) {
                Integer[] nullArray = new Integer[numsOfVertexes];
                Arrays.fill(nullArray, 0);
                matrix[i] = nullArray;
            }
            for(int i = 0; i < numsOfEdges; i++){
                int vertex1 = scanner.nextInt();
                int vertex2 = scanner.nextInt();
                matrix[vertex1 - 1][vertex2 - 1] = 1;
                matrix[vertex2 - 1][vertex1 - 1] = 1;
            }
            FileWriter fileWriter = new FileWriter("output.txt");
            for (Integer[] matrixString : matrix) {
                for (Integer element : matrixString) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(element).append(" ");
                    fileWriter.write(sb.toString());
                }
                fileWriter.write("\n");
            }
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
