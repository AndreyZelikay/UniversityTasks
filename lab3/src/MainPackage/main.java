package MainPackage;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        int k = 10;
        Matrix matrix = new Matrix(k);
        Scanner in = new Scanner(System.in);
        try {
            matrix.printMatrix();
            matrix.sortByСharacteristic();
            System.out.println();
            matrix.printMatrix();
            matrix.sortFirstString(0,5);
            System.out.println();
            matrix.printMatrix();
        } catch (MatrixException | IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Enter element to find");
            int elem = in.nextInt();
            System.out.println("Index of your element is: " + Arrays.toString(matrix.findElem(elem)));
            matrix.printMatrix();
        } catch (NoSuchElementException | MatrixException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
