package main;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        String mainString;
        String separators;
        String[] arrayOfWords = new String[50];
        int number;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input first string:");
        mainString = scanner.nextLine();
        System.out.println("Input second string:");
        separators = scanner.nextLine();
        if(!StringCheck.isStringContainsSeparators(mainString, separators)){
            System.out.println("No such separators in first string!");
            System.exit(0);
        }

        //arrayOfWords = mainString.split(separators);
        StringTokenizer stringTokenizer = new StringTokenizer(mainString,separators);
        int i = 0;
        while (stringTokenizer.hasMoreTokens()){
            arrayOfWords[i] = stringTokenizer.nextToken();
            i++;
        }
        arrayOfWords = Arrays.copyOf(arrayOfWords,i);
        int[] arrayOfBinaryNumbers = new int[arrayOfWords.length];
        String[] arrayOfRussianWords = new String[arrayOfWords.length];

        i = 0;
        int j = 0;
        for (String bufStr:arrayOfWords){
         try {
             int binaryNumber = Integer.parseInt(bufStr,2);
             arrayOfBinaryNumbers[i] = binaryNumber;
             i++;
         }
         catch (NumberFormatException ex){
             if(StringCheck.isRussianWord(bufStr)){
                 arrayOfRussianWords[j] = bufStr;
                 j++;
             }
         }
        }

        System.out.println("Russian words:");
        OutputArray.outputStringArray(arrayOfRussianWords);

        System.out.println("Array of binary elements:");
        OutputArray.outputIntegerArray(arrayOfBinaryNumbers);

        System.out.println("Input number to find:");
        number = scanner.nextInt();
        StringBuffer sb = new StringBuffer(mainString);
        String minusNumber = String.format("% d",-number);
        if(mainString.contains(Integer.toString(number))){
            System.out.println("Index of p:");
            System.out.println(mainString.indexOf(Integer.toString(number)));
            sb.insert(mainString.indexOf(Integer.toString(number))+
                            Integer.toString(number).length(),
                            minusNumber);
            System.out.println("Add element after the p:\n"+sb);
        }
        else {
            try {
                sb.insert(sb.indexOf(
                        Integer.toString(StringCheck.firstIntegerElement(arrayOfWords))) +
                                Integer.toString(StringCheck.firstIntegerElement(arrayOfWords)).length(),
                                minusNumber);
                System.out.println("Add element after the first integer number:"+sb);
            }
            catch (NoSuchElementException ex) {
                System.out.println("No position to insert -P");
            }
        }

        System.out.println("Delete last element more than p");
        StringBuffer sb1 = new StringBuffer(mainString);
        try {
            sb1.delete(sb1.lastIndexOf(Integer.toString(StringCheck.lastIntegerNumberMoreThanP(arrayOfWords, number))),
                    sb1.lastIndexOf(Integer.toString(StringCheck.lastIntegerNumberMoreThanP(arrayOfWords, number))) +
                            Integer.toString(StringCheck.lastIntegerNumberMoreThanP(arrayOfWords, number)).length());
            System.out.println(sb1);
        }
        catch (NoSuchElementException ex){
            System.out.println("No such element");
        }

    }
}
