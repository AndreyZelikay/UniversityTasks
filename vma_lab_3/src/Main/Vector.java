package Main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.util.stream.Stream;

public class Vector {

    private ArrayList<Double> elements;

    public Vector(){
        elements = new ArrayList<>();
    }

    public Vector(int size){
        elements = new ArrayList<>();
        for(int i = 0; i < size; i++){
            elements.add((double) i);
        }
    }

    public void parseFromFile(String fileName) throws IOException {
        if(elements.size() != 0){
            throw new IOException("unable to parse!");
        }
        FileReader fileReader = new FileReader(fileName);
        Scanner scanner = new Scanner(fileReader);
        int size = scanner.nextInt();
        for(int i = 0; i < size; i++){
            elements.add(scanner.nextDouble());
        }
        fileReader.close();
    }

    public Vector add(Vector vector){
        Vector result = new Vector();
        for(int i = 0; i < elements.size(); i++){
            result.addCoordinate(this.elements.get(i) + vector.elements.get(i));
        }
        return result;
    }

    public void addCoordinate(Double coefficient){
        elements.add(coefficient);
    }

    public void setCoordinate( int position, Double coordinate){
        elements.set(position,coordinate);
    }

    public Double multiply(Vector vector) throws Exception {
        if(vector.size() != this.size()){
            throw new Exception("Not possible to multiply!");
        }

        double result = 0;

        for(int i = 0; i< elements.size(); i++){
            result+= this.getCoordinate(i)*vector.getCoordinate(i);
        }
        return result;
    }
    
    public Vector div(Vector vector) {
        Vector result = new Vector();
        for(int i = 0; i < elements.size(); i++){
            result.addCoordinate(elements.get(i) / vector.elements.get(i));
        }
        return result;
    }

    public Vector multiply(double coefficient){
        Vector result = new Vector();
        for(int i = 0; i < elements.size(); i++){
            result.addCoordinate(this.getCoordinate(i)*coefficient);
        }
        return result;
    }

    public Double getCoordinate(int index){
        return elements.get(index);
    }

    public Double getMaxCoordinate(){
        return elements.stream().mapToDouble(v -> v).max().getAsDouble();
    }

    public int size(){
        return elements.size();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Double element: elements){
            result.append(String.format("%8.2f",element)).append(" ");
        }
        return result.toString();
    }
}
