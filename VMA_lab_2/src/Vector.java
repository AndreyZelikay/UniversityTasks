import java.util.ArrayList;

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

    public static Vector getNullVector(int size){
        Vector nullVector = new Vector();
        for(int i = 0; i < size; i++){
            nullVector.addCoordinate((double) 0);
        }
        return nullVector;
    }

    public void addCoordinate(Double coefficient){
        elements.add(coefficient);
    }

    public void setCoordinate( int position, Double coordinate){
        elements.set(position,coordinate);
    }

    public Double multiply(Vector vector) throws Exception {
        if(vector.getSize() != this.getSize()){
            throw new Exception("Not possible to multiply!");
        }

        double result = 0;

        for(int i = 0; i< elements.size(); i++){
            result+= this.get(i)*vector.get(i);
        }
        return result;
    }
    
    public Vector substractVector(Vector vector){
        Vector result = new Vector();
        for(int i = 0; i < vector.getSize(); i++){
            result.addCoordinate(this.get(i) - vector.get(i));
        }
        return result;
    }

    public Vector multiply(double coefficient){
        Vector result = new Vector();
        for(int i = 0; i < elements.size(); i++){
            result.addCoordinate(this.get(i)*coefficient);
        }
        return result;
    }

    public Double get(int index){
        return elements.get(index);
    }

    public int getSize(){
        return elements.size();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Double element: elements){
            result.append(element).append(" ");
        }
        return result.toString();
    }
}
