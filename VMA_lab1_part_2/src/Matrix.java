import java.util.ArrayList;
import java.util.HashMap;

public class Matrix {

    private ArrayList<ArrayList<Double>> elements;

    public Matrix(){
        elements = new ArrayList<>();
    }

    public Matrix(ArrayList<ArrayList<Double>> list){
        elements = list;
    }

    public static Matrix generateSpecialMatrix(int size, HashMap<String,Vector> mapABC){
        ArrayList<ArrayList<Double>> elements = new ArrayList<>();
        for(int i = 0; i < size ; i++){
            ArrayList<Double> stringElements = new ArrayList<>();
            for(int j = 0; j < size; j++){
                if(i==j){
                    stringElements.add(mapABC.get("c").getElement(i));
                }
                else if(j==i+1){
                    stringElements.add(-mapABC.get("b").getElement(i));
                }
                else if(j==i-1){
                    stringElements.add(-mapABC.get("a").getElement(i));
                } else{
                   stringElements.add(0.00);
                }
            }
            elements.add(stringElements);
        }
        return new Matrix(elements);
    }

    public void printMatrix(){
        for(ArrayList<Double> stringElements :elements) {
            for(Double element: stringElements){
                System.out.format("%.2f ",element);
            }
            System.out.println();
        }
    }

    public int getSize(){
        return elements.size();
    }

    public ArrayList<ArrayList<Double>> getElements() {
        return elements;
    }
}
