package MainPackage;

import java.text.NumberFormat;
import java.util.*;

public class Matrix {
    private ArrayList<ArrayList<Integer>> elements;

    public Matrix(int size){
        elements = new ArrayList();
        for(int i = 0;i < size;i++) {
            ArrayList<Integer> string = new ArrayList();
            int evenElements = 0;
            for (int j = 0; j < size; j++) {
                string.add((int) (Math.random() * 100));
                if(string.get(j)%2 == 0 && string.get(j) > 0){
                    evenElements+=string.get(j);
                }
            }
            string.add(evenElements);
            elements.add(string);
        }
    }

    public void sortByСharacteristic(){
        Collections.sort(elements, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(final ArrayList<Integer> entry1, final ArrayList<Integer> entry2) {
              return entry1.get(entry1.size() - 1) - entry2.get(entry2.size() - 1);
            }
        });
    }

    public void sortFirstString(int from, int to) throws IndexOutOfBoundsException{
            if(from < 0 || to > elements.get(0).size()) {
                throw new IndexOutOfBoundsException("Index out of range");
            }
            Collections.sort(elements.get(0).subList(from, to));
    }

    public int getElem(int i, int j) throws IndexOutOfBoundsException {
        return elements.get(i).get(j);
    }

    public int[] findElem(int elem) throws NoSuchElementException {
        int index = 0;
        int[] result = new int[2];
        int numberOfString = 0;
        for(ArrayList<Integer> i : elements) {
            Collections.sort(i);
            index = Collections.binarySearch(i.subList(0, i.size()-1), elem);
            if(index >= 0){
                result[0] = ++numberOfString;
                result[1] = ++index;
                return result;
            }
            numberOfString++;
        }
        throw new NoSuchElementException("No such element");
    }

    public void printMatrix() throws MatrixException{
        if(elements.isEmpty()) {
            throw new MatrixException("matrix is empty");
        }

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        for(int i = 0; i < 2;i++) {
            for (int j = 0; j < elements.size(); j++) {
                System.out.print(numberFormat.format(elements.get(i).get(j)) + "\t");
            }
            numberFormat = NumberFormat.getPercentInstance();
            System.out.println();
        }

        for(int i = 2;i < elements.size();i++) {
            for (int j = 0; j < elements.size(); j++) {
                    System.out.print(elements.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }
}
