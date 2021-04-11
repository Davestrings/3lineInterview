package interviewpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Interview {

//    public static void main(String[] args) {
//        int[] arr = {6, 0, 9, 3,4,8,7, 30};
//        System.out.println(smallestMissingNumber(arr));
//    }

    // Cases
    // all numbers are negative
    // only zero
    // all numbers are in range
    // array is empty

    public static int smallestMissingNumber(int[] intArray){
        // variable declaration and initialization
        int firstNumber, lastNumber;
        List<Integer> alist = new ArrayList<Integer>();
        List<Integer> newList = new ArrayList<Integer>();

        // sorting the array
        Arrays.sort(intArray);

        // creating a list of positive integers from array
        createList(intArray, alist);
        if(alist.isEmpty()) return 1;

        // getting the upper limit and lower limit from list
        firstNumber = alist.get(0);
        lastNumber = alist.get(alist.size() -1);

        // generating a range
        List<Integer> numberRange = generateRange(firstNumber, lastNumber);

        // finding the missing numbers
        findMissingNumber(alist, numberRange, newList);

        // getting the smallest number from the list
        Integer smallest = getSmallestNumber(newList);
        if (smallest != null && smallest == 0) return 1;
        if (smallest != null) return smallest;
        return lastNumber + 1;
    }

    private static void createList(int[] intArray, List<Integer> alist) {
        for (int i : intArray) {
            if(i >= 0)
                alist.add(i);
        }
    }

    private static Integer getSmallestNumber(List<Integer> newList) {
        if(!newList.isEmpty()){
            return newList.get(0);
        }
        return null;
    }

    private static void findMissingNumber(List<Integer> alist, List<Integer> numberRange, List<Integer> newList) {
        for(int i : numberRange){
            if(!alist.contains(i)){
                newList.add(i);
            }
        }
    }

    private static List<Integer> generateRange(int start, int end){
        return IntStream.rangeClosed(start, end)
                .boxed()
                .collect(Collectors.toList());
    }
}
