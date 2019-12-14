import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int numsOfVertexes;
        int numsOfEdges;
        Integer degrees[];
        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);
            numsOfVertexes = scanner.nextInt();
            numsOfEdges = scanner.nextInt();
            degrees = new Integer[numsOfVertexes];
            Arrays.fill(degrees,0);
            for(int i = 0; i < numsOfEdges*2;i++){
                int vertex = scanner.nextInt();
                degrees[vertex - 1] = degrees[vertex - 1]+1;
            }
            Arrays.sort(degrees, (a,b) -> -Integer.compare(a,b));
            FileWriter fileWriter = new FileWriter("output.txt");
            for(int i = 0; i< degrees.length; i++){
                StringBuilder sb = new StringBuilder();
                sb.append(degrees[i]).append(" ");
                fileWriter.write(sb.toString());
            }
            fileReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
