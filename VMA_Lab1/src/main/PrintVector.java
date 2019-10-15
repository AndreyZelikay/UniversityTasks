package main;

import java.util.ArrayList;

public class PrintVector {
    public static void print(ArrayList<Double> vector){
        for(double value:vector){
            System.out.format("%.2f ",value);
        }
        System.out.println();
    }
}
