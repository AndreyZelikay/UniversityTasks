import java.util.ArrayList;

public class Matrix {

    private ArrayList<Vector> elements;

    public Matrix(){
        elements = new ArrayList<>();
    }

    public Matrix(int size){
        elements = new ArrayList<>();
        for(int i = 0; i < size; i++){
            Vector line = new Vector();
            for(int j = 0; j< size; j++){
                line.addCoordinate((double) (i+j));
            }
            elements.add(line);
        }
    }

    public Matrix getTransMatrix(){
        Matrix matrix = new Matrix();
        for(int i = 0; i < this.getSize(); i++){
            Vector line = new Vector();
            for(int j = 0; j < this.getSize(); j++){
                line.addCoordinate(this.getLine(j).get(i));
            }
            matrix.addLine(line);
        }
        return matrix;
    }

    public void addLine(Vector line){
        elements.add(line);
    }


    public int getSize(){
        return elements.size();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(Vector line : elements){
            result.append(line).append("\n");
        }
        return result.toString();
    }

    public Vector multiply(Vector vector) throws Exception {
        if(vector.getSize()!=this.getSize()){
            throw new Exception("Not possible to multiply!");
        }

        Vector result = new Vector();

        for(Vector line : elements){
            result.addCoordinate(line.multiply(vector));
        }

        return result;
    }

    public Matrix multiply(Matrix matrix) throws Exception {
        Matrix result = new Matrix();
        Matrix transMatrix = matrix.getTransMatrix();
        for(int i = 0; i < matrix.getSize(); i++){
            result.addLine(this.multiply(transMatrix.getLine(i)));
        }
        return result.getTransMatrix();
    }

    public Vector getLine(int index){
        return elements.get(index);
    }

}
