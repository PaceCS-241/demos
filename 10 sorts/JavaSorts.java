import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JavaSorts {
    public static void main(String[] args) {
        System.out.println();

        int[] nums = {6, 8, 15, 1, -22, 7, 5};
        System.out.printf("Original array: %s\n", Arrays.toString(nums));

        // sort the array in place with Arrays sort method
        Arrays.sort(nums);
        System.out.printf("Sorted array: %s\n", Arrays.toString(nums));

        System.out.println();

        ArrayList<Song> songs = new ArrayList<>();
        { songs.add(new Song("Imagine", 187));
        songs.add(new Song("Fast Car", 297));
        songs.add(new Song("The Pass", 291));
        songs.add(new Song("Why Worry",511));
        songs.add(new Song("Simple Man", 357));
        songs.add(new Song("Rebel Rebel", 270));
        songs.add(new Song("Turn Off the News", 181));
        }

        System.out.printf("Songs: %s\n", Arrays.toString(songs.toArray()));

        // sort songs with Collections sort using Song.compareTo method (Comparable)
        Collections.sort(songs);
        System.out.printf("Songs sorted by length: %s\n", Arrays.toString(songs.toArray()));

        // use list.sort method to sort songs with custom ComparseSongs Comparator
        songs.sort(new CompareSongs());
        System.out.printf("Songs sorted by title: %s\n", Arrays.toString(songs.toArray()));
    }
    
}

class Song implements Comparable<Song> {
    String songTitle;
    Double songLength; // in seconds

    public Song(String title, double length) {
        songTitle = title;
        songLength = length;    
    }

    @Override
    public int compareTo(Song o) {
        // this will compare songs based on length
        if(this.songLength < o.songLength) { // this is shorter
            return -1;
        } else if(this.songLength > o.songLength) { // this is longer
            return 1;
        } else { // both are equivalent
            return 0;
        }
    }

    @Override
    public String toString() {
        return songTitle + " (" + songLengthToString() + ")";
    }

    private String songLengthToString() {
        int mins = (int)Math.floor(songLength) / 60;
        int secs = (int)Math.floor(songLength) % 60;
        return String.format("%d:%02d", mins, secs);
    }
}

class CompareSongs implements Comparator<Song> {

    @Override
    public int compare(Song o1, Song o2) {
        // compare songs based on title
        String o1title = o1.songTitle;
        String o2title = o2.songTitle;
        return o1title.compareTo(o2title);
    }
    
}