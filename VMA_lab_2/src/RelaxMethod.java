import java.util.ArrayList;

public class RelaxMethod {

    public static int solveSystem(SystemOfEquations system, Double omega, Double accuracy) throws Exception {
        ArrayList<Vector> receivedX = new ArrayList<>();
        receivedX.add(Vector.getNullVector(system.getSize()));
        receivedX.add(Functions.getFirstX(system));
        int k = 0;
        do
        {
            receivedX.add(Vector.getNullVector(system.getSize()));
            for(int i = 0; i < system.getSize(); i++){
                double firstSum = 0;
                for(int j = 0; j < i; j++){
                    firstSum+=receivedX.get(2).get(j)*system.getElement(i,j)/system.getElement(i,i);
                }
                double secondSum = 0;
                for(int j = i + 1; j < system.getSize(); j++){
                    secondSum+=receivedX.get(1).get(j)*system.getElement(i,j)/system.getElement(i,i);
                }
                receivedX.get(2).setCoordinate(i,(1-omega)*receivedX.get(1).get(i) - omega*secondSum - omega*firstSum + omega*system.getVectorF().get(i)/system.getElement(i,i));
            }
            receivedX.remove(0);
            k++;
        } while(Functions.maxVectorRate(receivedX.get(1), receivedX.get(0)) >= accuracy);
        system.setReceivedX(receivedX.get(1));
        return k+1;
    }


}
