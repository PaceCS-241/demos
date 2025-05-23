import java.util.Random;

public class LogSort {

    public static void main(String[] args) {
        
    }
    
    static Integer[] generateRandomArr() {
        Random rand = new Random();
        Integer[] randNums = new Integer[10];
        for(int i = 0; i < 10; i++) {
            randNums[i] = rand.nextInt();
        }
        return randNums;
    }   
}