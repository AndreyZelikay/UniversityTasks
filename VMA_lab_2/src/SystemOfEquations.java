public class SystemOfEquations {

    private Matrix coefficientMatrix;
    private Vector receivedX;
    private Vector vectorF;
    private Vector exactX;

    public SystemOfEquations(Matrix coefficients) throws Exception {
        this.coefficientMatrix = coefficients;
        this.exactX = new Vector(coefficients.getSize());
        this.vectorF = coefficients.multiply(exactX);
    }

    public void setReceivedX(Vector receivedX) {
        this.receivedX = receivedX;
    }

    public Vector getVectorF() {
        return vectorF;
    }

    public int getSize(){
        return coefficientMatrix.getSize();
    }

    public Double getElement(int line, int column){
        return coefficientMatrix.getLine(line).get(column);
    }

    @Override
    public String toString(){
        StringBuilder system = new StringBuilder();
        system.append("Coefficient matrix: ").append("\n")
                .append(coefficientMatrix).append("\n")
                .append("Vector f: ").append(vectorF).append("\n")
                .append("Exact solution: ").append(exactX).append("\n")
                .append("Received solution: ").append(receivedX).append("\n");
        return system.toString();
    }

    public Vector getReceivedX() {
        return receivedX;
    }

    public Matrix getCoefficientMatrix() {
        return coefficientMatrix;
    }

    public Vector getExactX() {
        return exactX;
    }
}
