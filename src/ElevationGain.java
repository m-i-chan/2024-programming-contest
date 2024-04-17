import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ElevationGain {
    public static void main(String[] args) {
        // Takes input line by line, splits over the spaces, and adds it to a list of integer lists.
        // Iterates over the list of integer lists to see if they meet predesignated benchmarks. Prints the index
        // that the list met those benchmarks.
        Scanner scnr = new Scanner(System.in);
        List<List<Integer>> inputs = new ArrayList<>();
        List<Integer> hike = new ArrayList<>();
        while (scnr.hasNext()) {
            String inString = scnr.nextLine();
            if (inString.equals("-1")) break;
            String[] inStringSplit = inString.split("\\s");
            for (String temp : inStringSplit) {
                if (Integer.parseInt(temp) != -1) {
                    hike.add(Integer.parseInt(temp));
                } else {
                    inputs.add(hike);
                    hike = new ArrayList<>();
                }
            }
        }
        for (List<Integer> i: inputs) {
            printArray(benchmarks(i));
        }
    }
    public static int[] benchmarks(List<Integer> hike) {
        int[] out = new int[3];
        Arrays.fill(out, -1);
        int i = 0;
        int elevationGain = 0;
        for (int j = 0; j < hike.size()-1; j++) {
            if (hike.get(j) < hike.get(j+1)) {
                elevationGain += hike.get(j+1) - hike.get(j);
                if (elevationGain >= (16*Math.pow(2,i))) {
                    out[i] = j+1;
                    i++;
                }
            }
        }
        return out;
    }
    public static void printArray(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
    }
}
