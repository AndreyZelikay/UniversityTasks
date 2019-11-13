public class GradientDescent {

    public static int solveSystem(SystemOfEquations system, double accuracy) throws Exception {
        Vector previousX = new Vector();
        system.setReceivedX(Functions.getFirstX(system));
        int iteration = 0;
        do{
            previousX = system.getReceivedX();
            Vector r = system.getCoefficientMatrix().multiply(previousX).substractVector(system.getVectorF());
            system.setReceivedX(previousX.substractVector(r.multiply(r.multiply(r)/system.getCoefficientMatrix().multiply(r).multiply(r))));
            iteration++;
        }while(Functions.maxVectorRate(previousX, system.getReceivedX()) >= accuracy);
        return iteration;
    }
}
