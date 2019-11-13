public class Main {

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3);
        try {
            SystemOfEquations system = new SystemOfEquations(matrix.multiply(matrix.getTransMatrix()));
            System.out.println("0.2 "+RelaxMethod.solveSystem(system,  0.2, (Math.pow(10,-5)))+" "+ Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
            System.out.println("0.5 "+RelaxMethod.solveSystem(system,  0.5, (Math.pow(10,-5)))+" "+ Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
            System.out.println("0.8 "+RelaxMethod.solveSystem(system,  0.8, (Math.pow(10,-5)))+" "+ Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
            System.out.println("1 "+RelaxMethod.solveSystem(system, (double) 1, (Math.pow(10,-5)))+" "+ Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
            System.out.println("1.3 "+RelaxMethod.solveSystem(system, 1.3, (Math.pow(10,-5)))+" "+ Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
            System.out.println("1.5 "+RelaxMethod.solveSystem(system, 1.5, (Math.pow(10,-5)))+" "+ Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
            System.out.println("1.8 "+RelaxMethod.solveSystem(system, 1.8, (Math.pow(10,-5)))+" "+ Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
            System.out.println("-----------------------------------------");
            System.out.println(GradientDescent.solveSystem(system, (Math.pow(10,-5))));
            System.out.println(system);
            System.out.println("accurate: " + Functions.maxVectorRate(system.getExactX(),system.getReceivedX()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
