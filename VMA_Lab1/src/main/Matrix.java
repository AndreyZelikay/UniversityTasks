package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Matrix {

    private ArrayList<ArrayList<Double>> list;
    private double determinant;

    public double getDeterminant() {
        return determinant;
    }

    public void setDeterminant(double determinant) {
        this.determinant *= determinant;
    }

    public Matrix(){
        this.list = new ArrayList<>();
        this.determinant = 1;
    }

    public Matrix(int size) {
        list = new ArrayList<>();
        for(int i = 0;i<size;i++){
            ArrayList<Double> stringList = new ArrayList<>();
            for(int j = 0; j < size ;j++){
                stringList.add((double) Math.round(((Math.random() * 20) -10)*100)/100);
            }
            list.add(stringList);
        }this.determinant = 1;
    }

    public Matrix(ArrayList<ArrayList<Double>> list){
        this.list = list;
        this.determinant = 1;
    }

    public void copyOf(Matrix matrix){
        ArrayList<ArrayList<Double>> bufferList = new ArrayList<>();
        for(int i = 0; i< matrix.getSize(); i++){
            ArrayList<Double> stringList = new ArrayList<>(matrix.getElements().get(i));
            bufferList.add(stringList);
        }
        this.list = bufferList;
    }

    public void choiceHighElement(){
        int indexOfMax = 0;
        for(int i = 0; i < list.size(); i++){
            if(Math.abs(list.get(i).get(0)) > Math.abs(list.get(indexOfMax).get(0))){
                indexOfMax = i;
            }
        }
        if(indexOfMax != 0) {
            Collections.swap(list, 0, indexOfMax);
            determinant*=-1;
        }
    }

    public Matrix subMatrix(int numFirstString, int numFirstColumn, int numLastString, int numLastColumn){
        ArrayList<ArrayList<Double>> bufferList = new ArrayList<>();
        for(int i = numFirstString; i <= numLastString; i++){
            bufferList.add(new ArrayList<>((list.get(i).subList(numFirstColumn,numLastColumn+1))));
        }
        return new Matrix(bufferList);
    }

    public void implace(int stringOfMatrix, int column, Matrix matrix){
        for(int i = stringOfMatrix; i < stringOfMatrix + matrix.getSize(); i++){
            for(int j = column; j < column + matrix.getElements().get(i-stringOfMatrix).size(); j++){
                this.list.get(i).set(j,matrix.getElements().get(i-stringOfMatrix).get(j-column));
            }
        }
    }

    public void addColumn(ArrayList<Double> column){
        int i = 0;
        for(ArrayList<Double> stringOfMatrix : list){
            stringOfMatrix.add(column.get(i));
            i++;
        }
    }

    public ArrayList<ArrayList<Double>> getElements(){
        return list;
    }

    public int getSize(){
        return list.size();
    }

    public void shareStringByFirstElement(int index){
        double firstElement = list.get(index).get(0);
        list.get(index).set(0, (double) 1);
        for(int i = 1; i < list.get(index).size(); i++){
            list.get(index).set(i,list.get(index).get(i)/firstElement);
        }
    }
    public void substractFirstLine(int index){
        double firstElement = list.get(index).get(0);
        for(int i = 0; i < list.get(index).size(); i++) {
            list.get(index).set(i, list.get(index).get(i)-list.get(0).get(i)*firstElement);
        }
    }
    public Matrix getReverseMatrix(){
        Matrix extendedMatrix = new Matrix();
        extendedMatrix.copyOf(this);
        int[] a = new int[]{1,2,3};
        for(int i = 0; i < list.size(); i++) {
            ArrayList<Double>stringOfUnitMatrix = new ArrayList<>(Collections.nCopies(list.size(), (double) 0));
            stringOfUnitMatrix.set(i,1.00);
            extendedMatrix.addColumn(stringOfUnitMatrix);
        }
        Matrix bufferMatrix = new Matrix();
        bufferMatrix.copyOf(extendedMatrix);
        for(int j = 0; j < extendedMatrix.getSize(); j++){
            bufferMatrix.shareStringByFirstElement(0);
            for(int k = 1; k < bufferMatrix.getSize();k++){
                bufferMatrix.substractFirstLine(k);
            }
            extendedMatrix.implace(j,j,bufferMatrix);
            bufferMatrix = bufferMatrix.subMatrix(1,1,bufferMatrix.getSize()-1, bufferMatrix.getElements().get(0).size()-1);
        }
        Matrix reverseMatrix = new Matrix(extendedMatrix.getSize());
        for(int k = extendedMatrix.getSize(); k < extendedMatrix.getSize()*2; k++) {
            ArrayList<Double> column = new ArrayList<>(Collections.nCopies(extendedMatrix.getSize(), (double) 0));
            for (int i = extendedMatrix.getSize() - 1; i >= 0; i--) {
                double sum = 0;
                for (int j = 0; j < extendedMatrix.getSize(); j++) {
                    double element = extendedMatrix.getElements().get(i).get(j);
                    if (element != 1 && element != 0) {
                        sum += element * column.get(j);
                    }
                }
                column.set(i, (extendedMatrix.getElements().get(i).get(k) - sum));
            }
            reverseMatrix.addColumn(column);
        }
        reverseMatrix.getElements();
        return reverseMatrix.subMatrix(0,reverseMatrix.getSize(),reverseMatrix.getSize()-1,reverseMatrix.getSize()*2-1);
    }
    public Matrix multiply(Matrix matrix){
        ArrayList<ArrayList<Double>> multipliedMatrixElements = new ArrayList<>();
        for(int i = 0; i < list.size();i++){
            ArrayList<Double> stringOfMultipliedMatrixElements = new ArrayList<>();
            for(int k = 0 ; k < list.size(); k++) {
                double sum = 0;
                for (int j = 0; j < list.size(); j++) {
                    sum += list.get(i).get(j) * matrix.getElements().get(j).get(k);
                }
                stringOfMultipliedMatrixElements.add(sum);
            }
            multipliedMatrixElements.add(stringOfMultipliedMatrixElements);
        }
        return new Matrix(multipliedMatrixElements);
    }

    public void printMatrix(){
        for(ArrayList<Double> stringOfMatrix : list){
            for(Double element : stringOfMatrix){
                System.out.format("%.2f ", Math.abs(element));
            }
            System.out.println();
        }
    }
}
