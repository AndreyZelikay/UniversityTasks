import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("input.txt");
            Scanner scanner = new Scanner(fileReader);

            String function = scanner.nextLine();

            fileReader.close();

            String[] prefixFunctions = {"~"};

            String[] elements = function.split(" ");

            ArrayList<String> output = new ArrayList();

            Stack<String> stack = new Stack<>();

            Map<String, Integer> variables = new HashMap<>();

            for (String element : elements) {
                if (isVariable(element)){
                    output.add(element);
                    variables.put(element, 0);
                }
                else if(isNumber(element)){
                    output.add(element);
                }
                else if(!element.equals(")")){
                    stack.push(element);
                }
                else {
                    String operation = stack.pop();
                    while (!operation.equals("(")) {
                        output.add(operation);
                        operation = stack.pop();
                    }
                }
            }

            while (!stack.empty()){
                output.add(stack.pop());
            }

            Map<String,Integer>[] truthTable = generateTruthTable(variables);

            int[] result = new int[truthTable.length];

            for(int i = 0; i < truthTable.length; i++) {
                for (String element : output) {
                    if(isNumber(element)){
                        stack.push(element);
                    } else if(isVariable(element)){
                        stack.push(truthTable[i].get(element).toString());
                    }else {
                        if (isPrefixFunction(element, prefixFunctions)) {
                            String firstElement = stack.pop();
                            stack.push(doPrefixOperation(firstElement, element));
                        } else {
                            String secondElement = stack.pop();
                            String firstElement = stack.pop();
                            stack.push(doBinaryOperation(firstElement, secondElement, element));
                        }
                    }
                }

                result[i] = Integer.parseInt(stack.pop());
            }

            FileWriter fileWriter = new FileWriter("output.txt");

            for(int element: result){
                fileWriter.write(Integer.toString(element));
            }

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isVariable(String str){
        return str.charAt(0) == 'x';
    }

    private static boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch (IllegalArgumentException e){
            return false;
        }
    }

    private static boolean isPrefixFunction(String str, String[] prefixFunctions){
        return Arrays.binarySearch(prefixFunctions, str) >= 0;
    }

    private static String doBinaryOperation(String firstElement, String secondElement, String operation){
        int firstOperand = Integer.parseInt(firstElement);
        int secondOperand = Integer.parseInt(secondElement);
        if(operation.equals("!")){
            return Integer.toString((firstOperand == secondOperand && firstOperand ==  0 ) ? 1 : 0);
        }
        if(operation.equals("|")){
            return Integer.toString((firstOperand == secondOperand && firstOperand ==  1 ) ? 0 : 1);
        }
        if(operation.equals("^")){
            return Integer.toString((firstOperand != secondOperand ) ? 1 : 0);
        }
        if(operation.equals("<=>")){
            return Integer.toString((firstOperand == secondOperand ) ? 1 : 0);
        }
        if(operation.equals("->")){
            return Integer.toString((firstOperand == 1 && secondOperand == 0) ? 0 : 1);
        }
        if(operation.equals("/\\")){
            return Integer.toString((firstOperand == 1 && secondOperand == 1) ? 1 : 0);
        }
        if(operation.equals("\\/")){
            return Integer.toString((firstOperand == 0 && secondOperand == 0) ? 0 : 1);
        }
        return null;
    }

    private static String doPrefixOperation(String element, String operation){
        if(operation.equals("~")){
            return Integer.toString((Integer.parseInt(element)==1) ? 0 : 1);
        }
        return null;
    }

    private static Map<String,Integer>[] generateTruthTable(Map<String,Integer> variables){
        Map<String,Integer>[] truthTable = new HashMap[(int) Math.pow(2,variables.size())];

        for(int i = 0; i < truthTable.length; i++){
            truthTable[i] = new HashMap<>();
        }

        for(int i = 0; i < truthTable.length; i++){
            String binaryString = Integer.toBinaryString(i);
            int j;
            for(j = 0 ; j < variables.size() - binaryString.length(); j++){
                int index = j + 1;
                truthTable[i].put("x" + index, 0);
            }
            for(int k = 0; k < binaryString.length(); k++){
                int index = j + 1;
                truthTable[i].put("x" + index, Character.getNumericValue(binaryString.charAt(k)));
                j++;
            }
        }
        return truthTable;
    }
}
