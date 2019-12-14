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

            int numOfVertex = scanner.nextInt();
            int[][] matrix = new int[numOfVertex][numOfVertex];

            for(int i = 0; i < numOfVertex; i++){
                for(int j = 0; j < numOfVertex; j++){
                    int element = scanner.nextInt();
                    matrix[i][j] = element;
                }
            }

            FileWriter fileWriter = new FileWriter("output.txt");

            boolean[] flags = new boolean[matrix.length];
            Arrays.fill(flags,false);
            ArrayList<Integer> spanningTree = getSpanningTree(matrix);

            if(spanningTree != null) {
                fileWriter.write(spanningTree.size()/2 + "\n");
                for (int i = 0; i < spanningTree.size(); i += 2) {
                    fileWriter.write(spanningTree.get(i) + " " + spanningTree.get(i + 1));
                    fileWriter.write("\n");
                }
            } else{
                fileWriter.write("-1");
            }

            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> getSpanningTree(int[][] matrix){
        boolean[] flags = new boolean[matrix.length];
        Arrays.fill(flags,false);
        ArrayList<Integer> spanningTree = new ArrayList<>();
        sdf(matrix, 0 ,0, flags, spanningTree);

        int passedVertex = 0;
        for (boolean flag : flags) {
            if (flag) {
                passedVertex++;
            }
        }
        return (passedVertex == matrix.length) ? spanningTree : null;
    }

    private static void sdf(int[][] matrix, int vertex, int parent, boolean[] flags, ArrayList<Integer> spanningTree){
        flags[vertex] = true;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[vertex][i] == 1 && i != parent && !flags[i]){
                spanningTree.add(vertex + 1);
                spanningTree.add(i + 1);
                sdf(matrix, i, vertex, flags,spanningTree);
            }
        }
    }
}
