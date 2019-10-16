import java.util.ArrayList;

public class CountNorms {
    public static double maxNorm(Vector a, Vector b){
        double max = 0;
        for(int i = 0; i < a.getSize();i++){
            if((Math.abs(a.getElement(i)-b.getElement(i))) > max){
                max = a.getElement(i)-b.getElement(i);
            }
        }
        return max;
    }

    public static Vector mulriplyMatrixtoVector(Matrix matrix, Vector vector){
        Vector result = new Vector();
        for(ArrayList<Double> stringOfMatrix : matrix.getElements()){
            double sum = 0;
            for(int i = 0; i< stringOfMatrix.size();i++){
                sum+=stringOfMatrix.get(i)*vector.getElement(i);
            }
            result.add(sum);
        }
        return result;
    }
}
