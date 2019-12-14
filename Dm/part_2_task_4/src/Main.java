import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        try {
            FileReader fileReader = new FileReader("input.in");
            Scanner scanner = new Scanner(fileReader);
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            boolean[] flags = new boolean[size];
            Arrays.fill(flags, false);

            dfs(0, flags, matrix);

            int counter = 0;
            for (boolean flag : flags) {
                if (flag) {
                    counter++;
                }
            }

            FileWriter fileWriter = new FileWriter("output.out");

            if (counter == size) {
                fileWriter.write("YES");
            } else {
                fileWriter.write("NO");
            }

            fileWriter.close();
            fileReader.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void dfs(int vertex, boolean[] flags, int[][] matrix){
        flags[vertex] = true;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[vertex][i] == 1 && !flags[i]){
                dfs(i, flags, matrix);
            }
        }
    }
}
