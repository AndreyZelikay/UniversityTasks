import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int numsOfVertexes;
        Integer[] P;
        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);
            numsOfVertexes = scanner.nextInt();
            P = new Integer[numsOfVertexes];
            Arrays.fill(P,0);
            for(int i = 0; i < numsOfVertexes-1;i++){
                int vertex1 = scanner.nextInt();
                int vertex2 = scanner.nextInt();
                P[vertex2 - 1] = vertex1;
            }
            FileWriter fileWriter = new FileWriter("output.txt");
            for(int element : P){
                StringBuilder sb = new StringBuilder();
                sb.append(element).append(" ");
                fileWriter.write(sb.toString());
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
