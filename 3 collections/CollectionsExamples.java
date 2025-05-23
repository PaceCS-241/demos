import java.util.ArrayList;
import java.util.Iterator;

public class CollectionsExamples {
    public static void main(String[] args) {
        
        String[] strArray = new String[10];
        strArray[0] = "Hello, world";
        System.out.println(strArray.length); // 10


        ArrayList<String> strList = new ArrayList<>();
        strList.add("Hello, world");
        System.out.println(strList.size()); // 1

        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(9);
        intList.add(18);
        intList.add(27);

        intList.get(0); // 9
        intList.remove(2);

        System.out.println(intList); // [9, 18]

        // a foreach loop used to calculate the average of an arraylist of ints
        int sum = 0; 
        for(int num : intList) {
            sum += num;
        }
        int avg = sum / intList.size();

        System.out.println(avg);

        // using an iterator to calculate the average of an arraylist of ints
        Iterator<Integer> iter = intList.iterator();

        sum = 0;
        while(iter.hasNext()) {
            sum += iter.next();
        }
        avg = sum / intList.size();

        System.out.println(avg);
        
    }
}
