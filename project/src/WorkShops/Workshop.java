package WorkShops;

import Address.Address;
import TelephoneNumber.TelephoneNumber;
import WorkShops.AutoRepairShop.Master.Master;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static WorkShops.AutoRepairShop.Functions.printArrayList;
import static WorkShops.AutoRepairShop.TransformFile.writeToStringEnd;

public abstract class Workshop {

    private String name;
    private ArrayList<TelephoneNumber> telephoneNumbers;
    private Address address;
    protected String file;
    private Date openingDate;

    public Workshop(String name, TelephoneNumber telephoneNumber, Address address) {
        this.telephoneNumbers = new ArrayList<>();
        this.telephoneNumbers.add(telephoneNumber);
        this.address = address;
        this.name = name;
    }

    public void setTelephoneNumbers(ArrayList<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public void addTelephoneNumber(String number){
        if(telephoneNumbers == null){
            telephoneNumbers = new ArrayList<>();
        }
        try {
            telephoneNumbers.add(new TelephoneNumber(number));
            writeToStringEnd(number, file, 1);
        } catch (IllegalArgumentException e){
            System.out.println("Illegal telephone number " + number);
        }
    }

    public void setOpeningDate(Date date) {
        this.openingDate = date;
    }

    public abstract void setMasters(ArrayList<Master> masters);
    public abstract void addMaster(Master master);

    @Override
    public String toString(){
        StringBuilder data = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM dd yy");
        data.append("Name: ").append(name).append("\n")
                .append("Address: ").append(address).append("\n")
                .append("Telephone numbers: ").append(printArrayList(telephoneNumbers)).append("\n")
                .append("Opening date: ").append((openingDate!=null) ? dateFormat.format(openingDate) : "Opening date hasn't inputted yet").append("\n");
        return data.toString();
    }
}
