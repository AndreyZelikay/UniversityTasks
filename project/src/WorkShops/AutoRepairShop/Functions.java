package WorkShops.AutoRepairShop;

import Address.Address;
import TelephoneNumber.TelephoneNumber;
import WorkShops.AutoRepairShop.Master.Master;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Functions {

    public static String printArrayList(ArrayList arrayList){
        StringBuilder result = new StringBuilder();
        if(arrayList != null){
            for(Object element: arrayList){
                result.append(element).append("\n");
            }
            return result.toString();
        }
        return "no information";
    }

    static AutoRepairShop parse(String nameOfFile) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
        String name = reader.readLine();
        ArrayList<TelephoneNumber> numbers = parseNumbers(reader);
        Address address = new Address(reader.readLine());

        AutoRepairShop repairShop = new AutoRepairShop(name, numbers.get(0), address, nameOfFile);

        repairShop.setTelephoneNumbers(numbers);
        repairShop.setOpeningDate(parseDate(reader.readLine()));
        repairShop.setTypeOfRepairingCars(parseTypesCars(reader));
        repairShop.setMasters(parseMasters(reader));
        reader.close();
        return repairShop;
    }

    private static Date parseDate(String date){
        DateFormat formatter = new SimpleDateFormat("MM dd yy");
        try {
            return formatter.parse(date);
        } catch(ParseException e){
            return null;
        }
    }

    private static ArrayList<Master> parseMasters(BufferedReader reader){
        ArrayList<Master> masters = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                Master master = new Master(line,null,null,null);
                masters.add(master);
            }
            return masters;
        } catch (Exception e){
            return null;
        }
    }

    private static ArrayList<TelephoneNumber> parseNumbers(BufferedReader reader) throws IOException {
        String[] stringNumbers = reader.readLine().split(" ");
        ArrayList<TelephoneNumber> numbers = new ArrayList();
        for(String number: stringNumbers){
            numbers.add(new TelephoneNumber(number));
        }
        return numbers;
    }

    private static ArrayList parseTypesCars(BufferedReader reader) throws IOException {
        String[] stringCars = reader.readLine().split(" ");
        ArrayList<CarBrand> cars = new ArrayList<>();
        for(String car: stringCars){
            try {
                cars.add(CarBrand.valueOf(car));
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return cars;
    }

}
