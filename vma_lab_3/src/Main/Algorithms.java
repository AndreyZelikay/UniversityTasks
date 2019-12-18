package Main;

public class Algorithms {
    public static void degreeMethod(Matrix matrix, Vector start, Double accuracy) throws Exception {
        Vector result = new Vector();
        Vector previous = new Vector();
        Vector lambdaPrevious = new Vector();
        Vector lambdaNext = new Vector();
        previous = start;
        result = matrix.multiply(previous);
        lambdaNext = previous.div(result);
        int counter = 0;
        do {
            lambdaPrevious = lambdaNext;
            result = matrix.multiply(previous);
            if(counter % 10 == 0){
                result = Functions.rationing(result);
            }
            lambdaNext = result.div(previous);
            previous = result;
            counter++;
        } while(Functions.maxVectorRate(lambdaNext, lambdaPrevious) > accuracy);
        System.out.println(lambdaNext.getCoordinate(0));
        System.out.println(Functions.rationing(result));
        System.out.println(counter);
    }

    public static void jacobiMethod(Matrix matrix, Double accuracy) throws Exception {
        int[] coordinateOfOptimal = Functions.getOptimalElement(matrix);
        Matrix result = matrix;
        Matrix q = new Matrix();
        int counter = 0;
        while (Math.abs(result.getElement(coordinateOfOptimal[0], coordinateOfOptimal[1])) > accuracy){
            Matrix jacobi = Functions.getJacobi(result, coordinateOfOptimal[0], coordinateOfOptimal[1]);
            result = jacobi.getTransMatrix().multiply(result.multiply(jacobi));
            q = (q.size() != 0) ? q.multiply(jacobi) : jacobi;
            coordinateOfOptimal = Functions.getOptimalElement(result);
            counter++;
        }
        System.out.println(counter);
        System.out.println(result);
        System.out.println(q);
    }
}
