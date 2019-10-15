package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int n = 0;
        Scanner in  = new Scanner(System.in);
        System.out.println("Input size of matrix");
        n = in.nextInt();
        Matrix matrix = new Matrix(n);
        SystemOfEquations systemOfEquations = SystemOfEquations.makeRandomSystem(matrix);
        systemOfEquations.printSystem();
        System.out.println("Exact solution:");
        PrintVector.print(systemOfEquations.getxVector());
        System.out.println("Received solution:");
        ArrayList<Double> xVector = SolveEquation.byGauss(systemOfEquations);
        PrintVector.print(xVector);
        System.out.println("Max residual rate: " + systemOfEquations.maxResidualRate(xVector));
        System.out.println("Max residual error: " + systemOfEquations.maxResidualError(xVector));
        System.out.println("Determinant: " + systemOfEquations.getCoefficientMatrix().getDeterminant());
        System.out.println("A*A^(-1): ");
        matrix.multiply(matrix.getReverseMatrix()).printMatrix();
    }
}
