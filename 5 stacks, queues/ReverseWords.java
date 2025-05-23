import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords1 q = new ReverseWords1();
        String w = q.reverseTheWords("Write a method that accepts a string and reverses the order of the words using a stack");
        System.out.println(w);
    }
}

class ReverseWords1 {
    protected Deque<String> stack;
    protected StringBuilder stringB;

    public ReverseWords1() {
        stack = new ArrayDeque<String>();
        stringB = new StringBuilder();
    }

    public String reverseTheWords(String s) {
        String[] words = s.split("\\s+");
        for(int i = 0; i < words.length; i++) {
            stack.push(words[i]);
        }
        while (!stack.isEmpty()) {
            stringB.append(stack.pop());
            stringB.append(" ");
        }
        return stringB.toString();
    }
}