import java.util.ArrayList;
import java.util.HashMap;

public class Functions {

    public static HashMap<String,Vector> generateABC(int size){
        HashMap<String,Vector> mapABC = new HashMap<>();
        Vector a = new Vector(1);
        Vector b = new Vector();
        Vector c = new Vector();
        c.add(Functions.generateNotNullValueBetweenRange(-10,10));
        for(int i = 1; i < size - 1;i++){
            c.add((double)  Math.round(((Math.random() * 20) -10)*100)/100);
        }
        c.add(Functions.generateNotNullValueBetweenRange(-10,10));
        b.add(Functions.generateNotNullValueBetweenRange(-c.getElement(0),c.getElement(0)));
        for(int i = 1; i < size - 1;i++) {
            a.add(Functions.generateNotNullValueBetweenRange(-c.getElement(i),c.getElement(i)));
            while(true) {
                b.add(Functions.generateNotNullValueBetweenRange(-c.getElement(i),c.getElement(i)));
                if((Math.abs(b.getElement(i))+Math.abs(a.getElement(i))) < Math.abs(c.getElement(i))){
                    break;
                }
                b.removeLast();
            }
        }
        a.add(Functions.generateNotNullValueBetweenRange(-c.getElement(c.getSize()-1),c.getElement(c.getSize()-1)));
        mapABC.put("a",a);
        mapABC.put("b",b);
        mapABC.put("c",c);
        return mapABC;
    }

    public static double generateNotNullValueBetweenRange(double from,double to){
        double value;
        while(true){
            value =(double)  Math.round(((Math.random() * ((to - from)))+from)*100)/100;
            if(value!=0)
                return value;
        }
    }

    public static void printMapOfVectors(HashMap<String,Vector> mapABC){
        for(HashMap.Entry<String,Vector> entry: mapABC.entrySet()){
            System.out.print(entry.getKey()+": ");
            entry.getValue().print();
            System.out.println();
        }
    }

    public static HashMap<String,Vector> createRandomSystem(Matrix matrixOfCoefficients){
        HashMap<String,Vector> mapXF = new HashMap<>();
        Vector x = new Vector();
        Vector f = new Vector();
        x.randomFill(matrixOfCoefficients.getSize());
        for(ArrayList<Double> stringOfMatrix : matrixOfCoefficients.getElements()){
            double sum = 0;
            int i = 0;
            for(Double element : stringOfMatrix){
                sum+=element*x.getElement(i);
                i++;
            }
            f.add(sum);
        }
        mapXF.put("x",x);
        mapXF.put("f",f);
        return mapXF;
    }
}
