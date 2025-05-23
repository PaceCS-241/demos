import java.util.Arrays;
import java.util.HashMap;

public class RecursionExamples {
    static HashMap<String, Integer> substrings;
    public static void main(String[] args) {
        // test base case
        countdown(0);
        countdown(-5);
        // test recursion
        countdown(5);

        // System.out.println(factorial(0));
        // System.out.println(factorial(4));

        // int[] sortedArray = {4,8,15,24,51,77,101,220};
        // System.out.println(binarySearch(sortedArray, 101, 0, sortedArray.length - 1));
        // substrings = new HashMap<>();
        // findRepeatSubstrings("ababab", 2);
        // System.out.println(Arrays.asList(substrings));
        // System.out.println(findSubstring("ababab", "ba"));

        String[] a = {"test", "blue", "good morning", "beach ball"};
        System.out.println(arraySearch(a, "blue"));
    }

    public static void countdown(int n) {
        if(n <= 0) {
            // base case, no more numbers to count down
            System.out.println("Blastoff!");
            return;
        }
        // recusive case: print number, decrement, recurse
        System.out.print(n + " ... ");
        countdown(--n);
    }
    
    public static int factorial(int n) {
        if(n <= 1)
            // base case, return 1
            return 1;
        // recursive case
        return n * factorial(n-1);
    }

    public static int fibonacci(int n) {
        if (n <= 0) // first base case
            return 0;
        else if (n == 1) //second base case
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static double gcd(int m, int n) {
        // make sure m, n > 0; m > n
        if (m <= 0 || n <= 0)
            return -1;
        if(n > m) {
            // swap n, m
            int temp = n;
            n = m;
            m = temp;
        }
        if (m % n == 0) // base case
            return n;
        return gcd(n, m % n);
    }

    /** Recursive binary search method
     * @param arr array to be searched. pre-sorted
     * @param target item to search for
     * @param i starting index
     * @param j ending index
     * @return index of target; -1 if not found
     */
    public static int binarySearch(int[] arr, int target, int i, int j) {
        if(j == i) // not found
            return -1;
        int middle = (i + j) / 2;
        if(target == arr[middle])
            return middle;
        if(target < arr[middle]) // search left half
            return binarySearch(arr, target, i, middle - 1);
        return binarySearch(arr, target, middle + 1, j);
    }

    public static int arraySearch(String[] arr, String target) {
        if(arr.length == 0) {
            throw new IndexOutOfBoundsException();
        }
        if(arr[0].equals(target)) {
            return 0;
        }
        // create a new array removing the first element
        String[] newArr = new String[arr.length-1];
        System.arraycopy(arr, 1, newArr, 0, arr.length-1);
        return 1 + arraySearch(newArr, target);
    }

    // String[] a = {"test", "blue", "good morning", "beach ball"};
        // System.out.println(arraySearch(a, "blue"));

    // /** Helper method for finding repeated substrings of characters of a given length
    //  * @param str The string to search
    //  * @param n substring length
    //  * @return void. Fills a global arraylist of pair objects
    //  */
    // public static void findRepeatSubstrings(String str, int n) {
    //     // loop through the parent string, if substring isn't already in the substring
    //     // dictionary, go hunting
        
    // }

    // /** Recursive method for counting substring frequency
    //  * @param str parent string
    //  * @param sub substring to count
    //  * @return returns frequency count
    //  */
    // public static int findSubstring(String str, String sub) {
        
    // }
}