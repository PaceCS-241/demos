import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AllTheSorts {
    public static void main(String[] args) {
        Integer[] randomNumbers = generateRandomArr();

        SortingFunction javaArraySort = (Integer[] arr) -> Arrays.sort(arr);
        SortingFunction selectionSort = (Integer[] arr) -> {
            for(int j = 0; j < arr.length-1; j++) {
                int iMin = j;
                for(int i = j+1; i < arr.length; i++) {
                    if(arr[i] < arr[iMin]) {
                        iMin = i;
                    }
                }
                if(iMin != j) {
                    int temp = arr[j];
                    arr[j] = arr[iMin];
                    arr[iMin] = temp;
                }
            }
        };
        SortingFunction insertionSort = (Integer[] arr) -> {
            for(int i = 1; i < arr.length - 1; i++) {
                int j = i;
                while(j > 0 && arr[j-1] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    j--;
                }
            }
        };

        // run them one at a time
        // System.out.println("Built in Java Array Sort");
        // SortingFunction.timeit(javaArraySort, randomNumbers);

        System.out.println("Selection Sort");
        SortingFunction.timeit(selectionSort, randomNumbers);

        // System.out.println("Insertion Sort");
        // SortingFunction.timeit(insertionSort, randomNumbers);
        
    }

    static Integer[] generateRandomArr() {
        Random rand = new Random();
        Integer[] randNums = new Integer[10000];
        for(int i = 0; i < 10000; i++) {
            randNums[i] = rand.nextInt();
        }
        return randNums;
    }
}

interface SortingFunction {
    void run(Integer[] arr);

    static void timeit(SortingFunction sf, Integer[] arr) {
        long startTime = System.currentTimeMillis();
        sf.run(arr);
        long endTime = System.currentTimeMillis();
        long runTime = (endTime - startTime);
        System.out.printf("Runtime: %d ms\n", runTime);
    }
}