import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String,Vector> mapABC = Functions.generateABC(10);
        Functions.printMapOfVectors(mapABC);
        Matrix matrix = Matrix.generateSpecialMatrix(10, mapABC);
        System.out.println("Matrix A:");
        matrix.printMatrix();
        HashMap<String,Vector> mapXF = Functions.createRandomSystem(matrix);
        System.out.print("f: ");
        mapXF.get("f").print();
        System.out.print("\n"+"x: ");
        mapXF.get("x").print();
        System.out.print("\n" + "y: ");
        Vector y = SolveSystem.byMethodOFProhonka(mapXF,mapABC);
        y.print();
        System.out.println("\n"+"Norm of nevyazka: "+
                CountNorms.maxNorm(mapXF.get("f"),CountNorms.mulriplyMatrixtoVector(matrix,y)));
        System.out.println("Norm of error: " +
                CountNorms.maxNorm(mapXF.get("x"),y));
    }
}
