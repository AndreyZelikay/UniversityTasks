package main;

import java.util.ArrayList;
import java.util.Collections;

public class SolveEquation {

    public static ArrayList<Double> byGauss(SystemOfEquations systemOfEquations){
        ArrayList<Double> xVector = new ArrayList<>(Collections.nCopies(systemOfEquations.getSolutions().size(), null));
        Matrix matrix = new Matrix();
        double determinant = 1;
        matrix.copyOf(systemOfEquations.getCoefficientMatrix());
        matrix.addColumn(systemOfEquations.getSolutions());
        Matrix bufferMatrix = new Matrix();
        bufferMatrix.copyOf(matrix);
        for(int j = 0; j < matrix.getSize(); j++){
            bufferMatrix.choiceHighElement();
            determinant *= bufferMatrix.getElements().get(0).get(0)*bufferMatrix.getDeterminant();
            if(bufferMatrix.getElements().get(0).get(0)==0){
                if(bufferMatrix.getElements().get(0).get(bufferMatrix.getSize()-1) !=0 ) {
                    boolean isPossibleToSolve = false;
                    for (int i = 0; i < bufferMatrix.getElements().get(0).size(); i++) {
                        if (bufferMatrix.getElements().get(0).get(i) != 0) {
                            isPossibleToSolve = true;
                            break;
                        }
                    }
                    if(!isPossibleToSolve){
                        System.out.println("Can not solve this system!!!");
                        System.exit(0);
                    }
                }
                xVector.set(j,(double) Math.round(((Math.random() * 20) -10)*100)/100);
                System.out.println("x"+j+"was generate randomly!");
            }
            bufferMatrix.shareStringByFirstElement(0);
            for(int k = 1; k < bufferMatrix.getSize();k++){
                bufferMatrix.substractFirstLine(k);
            }
            matrix.implace(j,j,bufferMatrix);
            bufferMatrix = bufferMatrix.subMatrix(1,1,bufferMatrix.getSize()-1,bufferMatrix.getSize());
        }
        systemOfEquations.getCoefficientMatrix().setDeterminant(determinant);
        for(int i = matrix.getSize() - 1; i >= 0; i--){
            if(xVector.get(i)==null) {
            double sum = 0;
            for(int j = 0; j < matrix.getSize(); j++){
                double element = matrix.getElements().get(i).get(j);
                if(element != 1 && element != 0){
                    sum += element*xVector.get(j);
                }
            }
                xVector.set(i, (matrix.getElements().get(i).get(matrix.getElements().get(i).size() - 1) - sum));
            }
        }
        return xVector;
    }
}
