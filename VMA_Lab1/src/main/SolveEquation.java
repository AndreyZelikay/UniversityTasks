package main;

import java.util.ArrayList;
import java.util.Collections;

public class SolveEquation {

    public static ArrayList<Double> byGauss(SystemOfEquations systemOfEquations){
        ArrayList<Double> xVector = new ArrayList<>(Collections.nCopies(systemOfEquations.getSolutions().size(), (double) 0));
        Matrix matrix = new Matrix();
        double determinant = 1;
        matrix.copyOf(systemOfEquations.getCoefficientMatrix());
        matrix.addColumn(systemOfEquations.getSolutions());
        Matrix bufferMatrix = new Matrix();
        bufferMatrix.copyOf(matrix);
        for(int j = 0; j < matrix.getSize(); j++){
            bufferMatrix.choiceHighElement();
            determinant *= bufferMatrix.getElements().get(0).get(0)*bufferMatrix.getDeterminant();
            bufferMatrix.shareStringByFirstElement(0);
            for(int k = 1; k < bufferMatrix.getSize();k++){
                bufferMatrix.substractFirstLine(k);
            }
            matrix.implace(j,j,bufferMatrix);
            bufferMatrix = bufferMatrix.subMatrix(1,1,bufferMatrix.getSize()-1,bufferMatrix.getSize());
        }
        systemOfEquations.getCoefficientMatrix().setDeterminant(determinant);
        for(int i = matrix.getSize() - 1; i >= 0; i--){
            double sum = 0;
            for(int j = 0; j < matrix.getSize(); j++){
                double element = matrix.getElements().get(i).get(j);
                if(element != 1 && element != 0){
                    sum += element*xVector.get(j);
                }
            }
            xVector.set(i,(matrix.getElements().get(i).get(matrix.getElements().get(i).size()-1) - sum));
        }
        return xVector;
    }
}
