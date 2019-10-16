import java.util.ArrayList;
import java.util.Collections;

public class Vector {

    private ArrayList<Double> elements;
    int startIndex;

    public Vector(){
        elements = new ArrayList<>();
        startIndex = 0;
    }

    public Vector(int startIndex){
        elements = new ArrayList<>();
        this.startIndex = startIndex;
    }

    public Double getElement(int i){
        return elements.get(i-startIndex);
    }

    public void add(double element){
        elements.add(element);
    }

    public int getSize(){
        return elements.size();
    }

    public void removeLast(){
        elements.remove(elements.size()-1);
    }

    public void print(){
        for(double element : elements){
            System.out.format("%.2f ",element);
        }
    }

    public void randomFill(int size){
        for(int i = 0; i < size; i++){
            elements.add(Functions.generateNotNullValueBetweenRange(-10,10));
        }
    }

    public void reverse(){
        Collections.reverse(elements);
    }
}
