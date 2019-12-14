import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("in.txt");
            Scanner scanner = new Scanner(fileReader);
            int numVertex = scanner.nextInt();

            long startTime = System.currentTimeMillis();

            ArrayList<Integer>[] adjacencyList = new ArrayList[numVertex];

            for(int i = 0; i < numVertex; i++){
                int size = scanner.nextInt();
                ArrayList<Integer> adjacency = new ArrayList<>();
                for(int j = 0; j < size; j++){
                    adjacency.add(scanner.nextInt() - 1);
                }
                adjacencyList[i] = adjacency;
            }

            int maxTime = 0;
            int firstVertex = 0;

            boolean isPossible = false;

            for(int i = 0; i < numVertex; i++){
                boolean[] flags = new boolean[numVertex];
                Arrays.fill(flags,false);

                ArrayDeque<Integer> queue = new ArrayDeque<>();

                int[] distance = new int[numVertex];

                int[] counter = new int[1];

                distance[0] = 0;
                queue.addLast(i);
                flags[i] = true;
                bfs(adjacencyList, queue, flags, distance, counter);
                if(counter[0] == numVertex){
                    int time = Arrays.stream(distance).max().getAsInt();
                    if(maxTime <= time){
                        maxTime = time;
                        firstVertex = i + 1;
                    }
                    isPossible = true;
                }

                long finishTime = System.currentTimeMillis();
                if(finishTime - startTime > 250){
                    flags = new boolean[numVertex];
                    Arrays.fill(flags,false);

                    queue = new ArrayDeque<>();

                    distance = new int[numVertex];

                    maxTime = 0;
                    firstVertex = 0;
                    for(int j = 0; j < numVertex; j++){
                        if(!flags[j]){
                            distance[0] = 0;
                            queue.addLast(j);
                            flags[j] = true;
                            counter[0] = 0;
                            bfs(adjacencyList, queue, flags, distance,counter);
                            if(counter[0] == numVertex){
                                int time = Arrays.stream(distance).max().getAsInt();
                                if(maxTime < time){
                                    maxTime = time;
                                    firstVertex = i + 1;
                                }
                            } else{
                                isPossible = false;
                                break;
                            }
                        }
                    }
                    break;
                }
            }

            FileWriter fileWriter = new FileWriter("out.txt");

            if(isPossible) {
                fileWriter.write(maxTime + "\n" + firstVertex);
            } else {
                fileWriter.write("impossible");
            }

            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.print(e.getMessage());
        }
    }

    private static void bfs(ArrayList<Integer>[] adjacencyList, ArrayDeque<Integer> queue, boolean[] flags, int[] dst, int[] counter){
        while(!queue.isEmpty()) {
            int vertex = queue.pollFirst();
            for (int element: adjacencyList[vertex]) {
                if (!flags[element]) {
                    queue.addLast(element);
                    flags[element] = true;
                    dst[element] = dst[vertex] + 1;
                }
            }
            counter[0]++;
        }
    }
}
