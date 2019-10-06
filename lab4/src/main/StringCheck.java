package main;


import java.util.NoSuchElementException;

public class StringCheck {
    public static boolean isRussianWord(String word){
        char[] wordLetters = new char[word.length()];
        word.getChars(0,word.length(),wordLetters,0);
        for(char letter: wordLetters){
            if((letter < 'А' || letter > 'Я')  && (letter < 'а' || letter > 'я')){
                return false;
            }
        }
        return true;
    }
    public static int firstIntegerElement(String[] arrayOfWords) throws NoSuchElementException{
        for(String word : arrayOfWords){
            try {
                return  Integer.parseInt(word);
            }
            catch (NumberFormatException ex){

            }
        }
        throw new NoSuchElementException();
    }
    public static boolean isStringContainsSeparators(String firstString,String separators){
        char[] secondStringLetters = new char[separators.length()];
        separators.getChars(0,separators.length(),secondStringLetters,0);
        for(char letter : secondStringLetters){
            if(firstString.indexOf(letter)!=-1) {
                return true;
            }
        }
        return false;
    }
    public static int lastIntegerNumberMoreThanP(String[] arrayOfWords, int p){
        int number = 0;
        for(String word : arrayOfWords){
            try {
                if(Integer.parseInt(word) > p){
                    number = Integer.parseInt(word);
                }
            }
            catch (NumberFormatException ex){

            }
        }
        if(number == 0) {
            throw new NoSuchElementException();
        }
        return number;
    }
}
