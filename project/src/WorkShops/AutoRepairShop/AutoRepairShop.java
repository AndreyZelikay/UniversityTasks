package WorkShops.AutoRepairShop;

import Address.Address;
import Interfaces.ParsableFromFile;
import WorkShops.AutoRepairShop.Master.Master;
import TelephoneNumber.TelephoneNumber;
import WorkShops.Workshop;

import java.util.*;

import static WorkShops.AutoRepairShop.Functions.parse;
import static WorkShops.AutoRepairShop.Functions.printArrayList;
import static WorkShops.AutoRepairShop.TransformFile.writeToStringEnd;

public class AutoRepairShop extends Workshop  implements ParsableFromFile{

    private ArrayList<CarBrand> typeOfRepairingCars;
    private ArrayList<Master> masters;

    public AutoRepairShop(String name, TelephoneNumber telephoneNumber, Address address,String nameOfFile){
        super(name, telephoneNumber, address);
        this.file = nameOfFile;
    }

    public static AutoRepairShop parseFromFile(String nameOfFile) {
        try {
            return parse(nameOfFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addTypeOfRepairingCar(String nameOfBrand) {
        if(typeOfRepairingCars == null){
            typeOfRepairingCars = new ArrayList<>();
        }

        try {
            this.typeOfRepairingCars.add(CarBrand.valueOf(nameOfBrand));
            writeToStringEnd(nameOfBrand, file, 4);
        } catch (IllegalArgumentException e){
            System.out.println("No such brand!");
        }
    }

    @Override
    public void addMaster(Master master) {
        if(masters == null){
            masters = new ArrayList<>();
        }
        this.masters.add(master);
    }

    @Override
    public void setMasters(ArrayList<Master> masters) {
        this.masters = masters;
    }

    public void setTypeOfRepairingCars(ArrayList<CarBrand> typeOfRepairingCars) {
        this.typeOfRepairingCars = typeOfRepairingCars;
    }

    @Override
    public String toString(){
        StringBuilder data = new StringBuilder();
        data.append(super.toString())
                .append("Masters:\n").append(printArrayList(masters)).append("\n")
                .append("Type of repairing cars:\n").append(printArrayList(typeOfRepairingCars)).append("\n");
        return data.toString();
    }
}
