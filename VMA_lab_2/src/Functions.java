public class Functions {

    public static double getRandomValue(){
        return (double) Math.round((Math.random()*20-10)*100)/100;
    }

    public static Double maxVectorRate(Vector firstVector, Vector secondVector) throws Exception {
        double max = (double) 0;
        if(firstVector.getSize() != secondVector.getSize()){
            throw new Exception("Not possible to count!");
        }

        for(int i = 0; i < firstVector.getSize(); i++){
            if(Math.abs(firstVector.get(i) - secondVector.get(i)) > max){
                max = Math.abs(firstVector.get(i) - secondVector.get(i));
            }
        }
        return max;
    }

    public static Vector getFirstX(SystemOfEquations system){
        Vector vector = new Vector();
        for(int i = 0; i < system.getSize(); i++){
            vector.addCoordinate(system.getVectorF().get(i)/system.getElement(i,i));
        }
        return vector;
    }
}
