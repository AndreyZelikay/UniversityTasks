import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("input.in");
            Scanner scanner = new Scanner(fileReader);

            int numOfVertex = scanner.nextInt();
            int[][] matrix = new int[numOfVertex][numOfVertex];

            for (int i = 0; i < numOfVertex; i++) {
                for (int j = 0; j < numOfVertex; j++) {
                    int element = scanner.nextInt();
                    matrix[i][j] = element;
                }
            }

            int[] flags = new int[matrix.length + 1];
            Arrays.fill(flags, 0);

            for(int i = 0; i < matrix.length; i++){
                dfs(flags, i, matrix, 1);
                if(flags[flags.length - 1] == 1){
                    break;
                }
            }

            ArrayList<Integer> strangers = new ArrayList<>();

            for(int i = 0; i < flags.length - 1; i++){
                if(flags[i] == 1){
                    strangers.add(i + 1);
                }
            }

            if(strangers.size() == matrix.length){
                for(int i = 0; i < matrix.length / 2 ; i++){
                    strangers.remove(strangers.size() - 1);
                }
            }

            FileWriter fileWriter = new FileWriter("output.out");

            if(flags[flags.length - 1] == 1){
                fileWriter.write("NO");
            } else{
                fileWriter.write("YES" + "\n");
                for(int stranger: strangers){
                    fileWriter.write(stranger + " ");
                }
            }

            fileWriter.close();
            fileReader.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void dfs(int[] flags, int vertex, int[][] matrix, int flag){
        if(flags[vertex] == 0) {
            flags[vertex] = flag;
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[vertex][i] == 1 && flags[i] == 0){
                dfs(flags, i, matrix, getFlag(flag));
            } else if(matrix[vertex][i] == 1 && flags[i] == flags[vertex]){
                flags[flags.length - 1] = 1;
            }
        }
    }

    private static int getFlag(int flag){
        return flag == 1 ? 2 : 1;
    }
}
