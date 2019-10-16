import java.util.HashMap;

public class SolveSystem {
    public static Vector byMethodOFProhonka(HashMap<String,Vector> mapXF, HashMap<String,Vector> mapABC){
        Vector y = new Vector();
        Vector alpha = new Vector();
        Vector beta = new Vector();

        alpha.add(mapABC.get("b").getElement(0)/mapABC.get("c").getElement(0));
        for(int i = 1; i < mapABC.get("c").getSize()-1; i++){
            alpha.add(mapABC.get("b").getElement(i)/
                    (mapABC.get("c").getElement(i)-alpha.getElement(i-1)*mapABC.get("a").getElement(i)));
        }

        beta.add(mapXF.get("f").getElement(0)/mapABC.get("c").getElement(0));
        for(int i = 1; i < mapABC.get("c").getSize(); i++){
            beta.add((mapXF.get("f").getElement(i)+beta.getElement(i-1)*mapABC.get("a").getElement(i))/
                    (mapABC.get("c").getElement(i)-alpha.getElement(i-1)*mapABC.get("a").getElement(i)));
        }

        y.add(beta.getElement(beta.getSize()-1));
        int k = 0;
        for(int i = beta.getSize() - 2; i >= 0; i-- ){
            y.add(alpha.getElement(i)*y.getElement(k)+beta.getElement(i));
            k++;
        }
        y.reverse();
        return y;
    }
}
