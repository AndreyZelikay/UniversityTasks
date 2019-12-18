package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Matrix {

    private ArrayList<Vector> elements;

    public Matrix(){
        elements = new ArrayList<>();
    }

    public Matrix(int size){
        elements = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Vector line = new Vector();
            for(int j = 0; j< size; j++){
                line.addCoordinate((double) (i+j));
            }
            elements.add(line);
        }
    }

    public void parseFromFile(String fileName) throws IOException {
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        int size = scanner.nextInt();
        for(int i = 0; i < size; i++){
            Vector line = new Vector();
            for(int j = 0; j < size; j++){
                line.addCoordinate(scanner.nextDouble());
            }
            elements.add(line);
        }
        fileReader.close();
    }

    public void addLine(Vector line){
        elements.add(line);
    }

    public int size(){
        return elements.size();
    }

    public Matrix getTransMatrix(){
        Matrix matrix = new Matrix();
        for(int i = 0; i < this.size(); i++){
            Vector line = new Vector();
            for(int j = 0; j < this.size(); j++){
                line.addCoordinate(this.elements.get(j).getCoordinate(i));
            }
            matrix.addLine(line);
        }
        return matrix;
    }

    public Matrix multiply(Matrix matrix) throws Exception {
        Matrix result = new Matrix();
        Matrix transMatrix = matrix.getTransMatrix();
        for(int i = 0; i < matrix.size(); i++){
            result.addLine(this.multiply(transMatrix.elements.get(i)));
        }
        return result.getTransMatrix();
    }

    public Vector multiply(Vector vector) throws Exception {
        if(vector.size()!=this.size()){
            throw new Exception("Not possible to multiply!");
        }

        Vector result = new Vector();

        for(Vector line : elements){
            result.addCoordinate(line.multiply(vector));
        }

        return result;
    }

    public Matrix multiply(int coefficient){
        Matrix result = new Matrix();
        for(Vector line: elements){
            Vector resultLine = new Vector();
            for(int i = 0; i < line.size(); i++){
                resultLine = line.multiply(coefficient);
            }
            result.addLine(resultLine);
        }
        return result;
    }

    public Matrix add(Matrix matrix){
        Matrix result = new Matrix();
        for(int i = 0; i < matrix.size(); i++){
            Vector line = this.elements.get(i).add(matrix.elements.get(i));
            result.addLine(line);
        }
        return result;
    }

    public Double getElement(int i, int j){
        return elements.get(i).getCoordinate(j);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Vector line : elements){
            result.append(line).append("\n");
        }
        return result.toString();
    }
}
