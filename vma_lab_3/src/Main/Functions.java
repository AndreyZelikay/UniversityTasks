package Main;

public class Functions {

    public static Double maxVectorRate(Vector firstVector, Vector secondVector) throws Exception {
        double max = (double) 0;
        if(firstVector.size() != secondVector.size()){
            throw new Exception("Not possible to count!");
        }

        for(int i = 0; i < firstVector.size(); i++){
            if(Math.abs(firstVector.getCoordinate(i) - secondVector.getCoordinate(i)) > max){
                max = Math.abs(firstVector.getCoordinate(i) - secondVector.getCoordinate(i));
            }
        }
        return max;
    }

    public static Vector rationing(Vector vector){
        return vector.multiply(1 / vector.getMaxCoordinate());
    }

    public static int[] getOptimalElement(Matrix matrix){
        int[] coordinates = new int[2];
        double[][] offDiagonalElements = new double[matrix.size()][matrix.size() - 1];
        double maxSumOfSquares = 0;
        int lineOfMax = 0;
        for(int i = 0; i < matrix.size(); i++){
            int k = 0;
            for(int j = 0; j < matrix.size(); j++){
                if(i != j) {
                    offDiagonalElements[i][k] = matrix.getElement(i, j);
                    k++;
                }
            }
            double sumOfSquares = getSumOfSquares(offDiagonalElements[i]);
            if(sumOfSquares > maxSumOfSquares){
                maxSumOfSquares = sumOfSquares;
                lineOfMax = i;
            }
        }
        double max = 0;
        int column = 0;
        for(int i = 0; i < offDiagonalElements[lineOfMax].length; i++){
            if(Math.abs(offDiagonalElements[lineOfMax][i]) > max){
                max = Math.abs(offDiagonalElements[lineOfMax][i]);
                column = (i < lineOfMax) ? i : i + 1;
            }
        }
        coordinates[0] = lineOfMax;
        coordinates[1] = column;
        return coordinates;
    }

    public static Matrix getJacobi(Matrix matrix, int i, int j){
        double tg = 2 * matrix.getElement(i, j) / (matrix.getElement(i, i) - matrix.getElement(j, j));
        double bufferValue = 1 / Math.sqrt(1 + Math.pow(tg,2));
        Double cos = Math.sqrt((1 + bufferValue) / 2);
        Double sin = Math.signum(tg)*Math.sqrt((1 - bufferValue) / 2);
        Matrix result = new Matrix();
        for(int m = 0; m < matrix.size(); m++){
            Vector line = new Vector();
            for(int l = 0; l < matrix.size(); l++){
                if(m == l) {
                    if (m == i || m == j) {
                        line.addCoordinate(cos);
                    }
                    else {
                        line.addCoordinate((double) 1);
                    }
                }
                else if(m == i && l == j) {
                    line.addCoordinate(-sin);
                }
                else if(m == j && l ==i){
                    line.addCoordinate(sin);
                }
                else {
                    line.addCoordinate((double) 0);
                }
            }
            result.addLine(line);
        }
        return result;
    }

    private static double getSumOfSquares(double[] array){
        double sumOfSquares = 0;
        for(Double element : array){
            sumOfSquares += Math.pow(element, 2);
        }
        return sumOfSquares;
    }
}
