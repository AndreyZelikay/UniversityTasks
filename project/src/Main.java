import WorkShops.AutoRepairShop.AutoRepairShop;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        AutoRepairShop autoRepairShop = AutoRepairShop.parseFromFile("input.txt");

        autoRepairShop.addTelephoneNumber("+375292044021");
        autoRepairShop.addTelephoneNumber("+375123");
        autoRepairShop.addTypeOfRepairingCar("Renault");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(autoRepairShop.getName() + ".ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(autoRepairShop);

            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream(autoRepairShop.getName() + ".ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            AutoRepairShop parsedRepairShop = (AutoRepairShop) objectInputStream.readObject();

            objectInputStream.close();

            System.out.println(parsedRepairShop);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
        XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(autoRepairShop.getName() + ".xml"));

        xmlEncoder.writeObject(autoRepairShop);

        xmlEncoder.close();

        XMLDecoder xmlDecoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(autoRepairShop.getName() + ".xml")));

        AutoRepairShop parsedXmlRepairShop = (AutoRepairShop) xmlDecoder.readObject();

        xmlDecoder.close();

        System.out.println(parsedXmlRepairShop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
