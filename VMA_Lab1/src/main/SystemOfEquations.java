package main;

import java.util.ArrayList;

public class SystemOfEquations {

    private Matrix coefficientMatrix;
    private ArrayList<Double> solutions;
    private  ArrayList<Double> xVector;

    public Matrix getCoefficientMatrix() {
        return coefficientMatrix;
    }

    public void setCoefficientMatrix(Matrix coefficientMatrix) {
        this.coefficientMatrix = coefficientMatrix;
    }

    public ArrayList<Double> getSolutions() {
        return solutions;
    }

    public void setSolutions(ArrayList<Double> solutions) {
        this.solutions = solutions;
    }

    public SystemOfEquations(Matrix coefficientMatrix, ArrayList<Double> solutions){
        this.coefficientMatrix = coefficientMatrix;
        this.solutions = solutions;
        xVector = new ArrayList<>();
    }

    public SystemOfEquations(Matrix coefficientMatrix, ArrayList<Double> solutions, ArrayList<Double> xVector){
        this.coefficientMatrix = coefficientMatrix;
        this.solutions = solutions;
        this.xVector = xVector;
    }

    public static SystemOfEquations makeRandomSystem(Matrix matrix){
        ArrayList<Double> customSolutions = new ArrayList<>();
        ArrayList<Double> customXVector = new ArrayList<>();
        for(int i = 0; i < matrix.getSize();i++){
            customXVector.add((double) Math.round(((Math.random() * 20) -10)*100)/100);
        }
        for(ArrayList<Double> stringOfMatrix : matrix.getElements()) {
            double solution = (double) 0;
            int i = 0;
            for(Double coefficient : stringOfMatrix){
                solution += coefficient*customXVector.get(i);
                i++;
            }
            customSolutions.add(solution);
        }

        SystemOfEquations system = new SystemOfEquations(matrix,customSolutions,customXVector);
        return system;
    }

    public void printSystem() {
        int i = 0;
        int j = 0;
        for(ArrayList<Double> stringOfMatrix : coefficientMatrix.getElements()){
            if(stringOfMatrix.get(1) >= 0) {
                System.out.print(stringOfMatrix.get(0) + "x + ");
            }
            else {
                System.out.print(stringOfMatrix.get(0) + "x - ");
            }
            for(j = 1; j < coefficientMatrix.getSize()-1; j++){
                if(stringOfMatrix.get(j+1) >= 0) {
                    System.out.print(Math.abs(stringOfMatrix.get(j)) + "x + ");
                }
                else {
                    System.out.print(Math.abs(stringOfMatrix.get(j)) + "x - ");
                }
            }
            System.out.print(Math.abs(stringOfMatrix.get(j))+ "x ");
            System.out.format("= %2.2f%n",solutions.get(i));
            i++;
        }
    }

    public double maxResidualRate(ArrayList<Double> xVector){
        ArrayList<Double> receivedSolutions = new ArrayList<>();
        for(ArrayList<Double> stringOfMatrix : coefficientMatrix.getElements()){
            double solution = 0;
            int i = 0;
            for(double coefficient : stringOfMatrix){
                solution+=coefficient*xVector.get(i);
                i++;
            }
            receivedSolutions.add(solution);
        }
        double max = 0;
        for(int i = 0; i< receivedSolutions.size(); i++){
            if(Math.abs(receivedSolutions.get(i)-solutions.get(i)) > max){
                Math.abs(max = receivedSolutions.get(i)-solutions.get(i));
            }
        }
        return max;
    }

    public double maxResidualError(ArrayList<Double> xVector){
        double max = 0;
        for(int i = 0; i < this.xVector.size(); i++){
            if(Math.abs(this.xVector.get(i) - xVector.get(i)) > max){
                max = Math.abs(this.xVector.get(i) - xVector.get(i));
            }
        }
        return max;
    }

    public ArrayList<Double> getxVector(){
        return xVector;
    }
}
