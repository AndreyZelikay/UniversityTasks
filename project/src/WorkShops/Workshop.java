package WorkShops;

import Address.Address;
import WorkShops.AutoRepairShop.Master.Master;
import TelephoneNumber.TelephoneNumber;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static WorkShops.AutoRepairShop.Functions.printArrayList;
import static WorkShops.AutoRepairShop.TransformFile.writeToStringEnd;

public abstract class Workshop {

    protected String name;
    protected ArrayList<TelephoneNumber> telephoneNumbers;
    protected Address address;


    public Workshop(String name, TelephoneNumber telephoneNumber, Address address) {
        this.telephoneNumbers = new ArrayList<>();
        this.telephoneNumbers.add(telephoneNumber);
        this.address = address;
        this.name = name;
    }

    public void setMasters(ArrayList<Master> masters) {
        this.masters = masters;
    }

    public void setTelephoneNumbers(ArrayList<TelephoneNumber> telephoneNumbers) {
        this.telephoneNumbers = telephoneNumbers;
    }

    public void addTelephoneNumber(String number){
        if(telephoneNumbers == null){
            telephoneNumbers = new ArrayList<>();
        }
        telephoneNumbers.add(new TelephoneNumber(number));
        writeToStringEnd( new TelephoneNumber(number), file, 1);
    }

    public abstract void setOpeningDate(Date date);

    @Override
    public String toString(){
        StringBuilder data = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM dd yy");
        data.append("Name: ").append(name).append("\n")
                .append("Telephone numbers: ").append(printArrayList(telephoneNumbers)).append("\n")
                .append()
    };
}
