package WorkShops.AutoRepairShop;

import Address.Address;
import Interfaces.ParsableFromFile;
import WorkShops.AutoRepairShop.Master.Master;
import TelephoneNumber.TelephoneNumber;
import WorkShops.Workshop;

import java.text.SimpleDateFormat;
import java.util.*;

import static WorkShops.AutoRepairShop.Functions.parse;
import static WorkShops.AutoRepairShop.Functions.printArrayList;
import static WorkShops.AutoRepairShop.TransformFile.writeToStringEnd;

public class AutoRepairShop extends Workshop implements ParsableFromFile {

    private Date openingDate;
    private ArrayList<CarBrand> typeOfRepairingCars;
    private ArrayList<Master> masters;
    private String file;

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

    public void addMaster(Master master) {
        if(masters == null){
            masters = new ArrayList<>();
        }
        this.masters.add(master);
    }

    @Override
    public void setOpeningDate(Date date) {
        this.openingDate = date;
    }

    public void setTypeOfRepairingCars(ArrayList<CarBrand> typeOfRepairingCars) {
        this.typeOfRepairingCars = typeOfRepairingCars;
    }



    @Override
    public String toString(){
        StringBuilder data = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM dd yy");
        data.append("Name: ").append(name).append("\n")
                .append("Telephone numbers: ").append(printArrayList(telephoneNumbers)).append("\n")
                .append("Opening date: ").append((openingDate!=null) ? dateFormat.format(openingDate) : "Opening date hasn't inputted yet").append("\n")
                .append("Masters:\n").append(printArrayList(masters)).append("\n")
                .append("Type of repairing cars:\n").append(printArrayList(typeOfRepairingCars)).append("\n");
        return data.toString();
    }
}
