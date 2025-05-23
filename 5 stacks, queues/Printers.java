import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class Printers {
        public static void main(String[] args) {
            Printer gerald = new Printer();

            gerald.add(30);
            gerald.add(42);
            gerald.add(666);

            System.out.println(gerald.printTime());

        }
}

class Printer {
    Deque<Integer> queue;

    public Printer() {
        queue = new ArrayDeque<>();

    }

    public void add(int pages) {
        queue.add(pages);
    }

    public float printTime() {
        int pages = 0;
        Iterator<Integer> i = queue.iterator();
        while(i.hasNext()) {
            pages += i.next();
        }
        
        float time = pages / 10;
        return time;
    }
}
