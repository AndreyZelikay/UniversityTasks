package main;

public class OutputArray {
    public static void outputIntegerArray(int[] array){
        boolean isEmpty = true;
        for(int elem : array) {
            if (elem != 0) {
                isEmpty = false;
                break;
            }
        }
        if(!isEmpty) {
            for (int elem : array) {
                if (elem != 0) {
                    System.out.print(elem + " ");
                }
            }
            System.out.println();
        }
        else{
            System.out.println("Array is empty!");
        }
    }

    public static void outputStringArray(String[] array){
        boolean isEmpty = true;
        for(String elem : array) {
            if (elem != null) {
                isEmpty = false;
                break;
            }
        }
        if(!isEmpty) {
            for (String elem : array) {
                if (elem != null) {
                    System.out.print(elem + " ");
                }
            }
            System.out.println();
        }
        else{
            System.out.println("Array is empty!");
        }
    }
}
