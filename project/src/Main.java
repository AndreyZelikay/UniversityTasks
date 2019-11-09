import WorkShops.AutoRepairShop.AutoRepairShop;

public class Main {

    public static void main(String[] args) {
        AutoRepairShop autoRepairShop = AutoRepairShop.parseFromFile("input.txt");

        autoRepairShop.addTelephoneNumber("+375292044021");
        autoRepairShop.addTelephoneNumber("+375123");
        autoRepairShop.addTypeOfRepairingCar("Renault");
        System.out.println(autoRepairShop);
    }
}
