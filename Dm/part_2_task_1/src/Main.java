import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);

            int numOfVertex = scanner.nextInt();
            int[][] matrix = new int[numOfVertex][numOfVertex];

            int counter = 0;
            for(int i = 0; i < numOfVertex; i++){
                for(int j = 0; j < numOfVertex; j++){
                    int element = scanner.nextInt();
                    matrix[i][j] = element;
                    if(element == 1){
                       counter++;
                    }
                }
            }

            boolean[] flags = new boolean[numOfVertex];
            Arrays.fill(flags,false);
            sdf(matrix, 0 , flags);

            int passedVertex = 0;
            for (boolean flag : flags) {
                if (flag) {
                    passedVertex++;
                }
            }

            FileWriter fileWriter = new FileWriter("output.txt");
            if(passedVertex == numOfVertex && counter/2 == numOfVertex-1){
                fileWriter.write("Yes");
            } else {
                fileWriter.write("No");
            }
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sdf(int[][] matrix, int vertex, boolean[] flags){
        flags[vertex] = true;
        for(int i = 0; i < matrix.length; i++){
            if(matrix[vertex][i] == 1 && !flags[i]){
                sdf(matrix, i, flags);
            }
        }
    }
}
