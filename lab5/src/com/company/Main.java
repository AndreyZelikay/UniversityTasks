package com.company;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> telephoneNumbers = new ArrayList<>();
        ArrayList<String> correctTelephoneNumbers = new ArrayList<>();
        ArrayList<String> incorrectTelephoneNumbers = new ArrayList<>();
        try {
            FileReader fileReader= new FileReader("input.txt");
            Scanner scan = new Scanner(fileReader);

            while (scan.hasNextLine()) {
                telephoneNumbers.add(scan.nextLine());
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Pattern pattern = Pattern.compile("^(([+]?375(29|44|33|25))|8017)[0-9]{7}");
        for(String number: telephoneNumbers){
            Matcher matcher = pattern.matcher(number);
            if(matcher.matches()){
                correctTelephoneNumbers.add(number);
            }
            else{
                incorrectTelephoneNumbers.add(number);
            }
        }
        System.out.println();
        /*Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(), matcher.end()));
        }*/
    }
}
