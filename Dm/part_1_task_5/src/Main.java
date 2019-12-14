import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] p;
        int numOfVerteges;
        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);
            numOfVerteges = scanner.nextInt();
            p = new int[numOfVerteges];
            Arrays.fill(p,0);
            for(int i = 0; i < numOfVerteges; i++){
                for(int j = 0; j < numOfVerteges; j++){
                    int element = scanner.nextInt();
                    if(element == 1){
                        p[j] = i + 1;
                    }
                }
            }
            FileWriter fileWriter = new FileWriter("output.txt");
            for(int value : p){
                StringBuilder sb = new StringBuilder();
                sb.append(value).append(" ");
                fileWriter.write(sb.toString());
            }
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
