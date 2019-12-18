package Main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        int k = 8;
        Matrix b = new Matrix();
        Matrix c = new Matrix();
        Vector startY = new Vector();
        try {
            b.parseFromFile("B.txt");
            c.parseFromFile("C.txt");
            startY.parseFromFile("Y.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Matrix a = b.add(c.multiply(k));
        System.out.println(a);
        Algorithms.degreeMethod(a,startY,Math.pow(10,-6));
        Algorithms.jacobiMethod(a,Math.pow(10,-6));
    }
}
