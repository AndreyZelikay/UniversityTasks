import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);
            int numVertex = scanner.nextInt();

            int[][] matrix = new int[numVertex][numVertex];

            for(int i = 0; i < numVertex; i++){
                for(int j = 0; j < numVertex; j++){
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int[] flags = new int[numVertex];
            Arrays.fill(flags,0);

            ArrayDeque<Integer> queue = new ArrayDeque<>();

            int[] previousFlag = new int[1];

            for(int i = 0; i < numVertex; i++){
                if(flags[i] == 0){
                    queue.addLast(i);
                    bfs(matrix, queue, flags, previousFlag);
                }
            }

            FileWriter fileWriter = new FileWriter("output.txt");

            for(int flag: flags){
                fileWriter.write(flag + " ");
            }

            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    private static void bfs(int[][] matrix, ArrayDeque<Integer> queue, int[] flags, int[] previousFlag){
        while(!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            if(flags[vertex] == 0) {
                flags[vertex] = ++previousFlag[0];
            }
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[vertex][i] == 1 && flags[i] == 0) {
                    queue.addLast(i);
                }
            }
        }
    }
}
