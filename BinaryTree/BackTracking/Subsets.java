package BackTracking;
import java.util.*;

public class Subsets {
    public static void findSubsets(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        // Choice 1: include element
        current.add(arr[index]);
        findSubsets(arr, index + 1, current);

        // Backtrack (remove last choice)
        current.remove(current.size() - 1);

        // Choice 2: exclude element
        findSubsets(arr, index + 1, current);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        findSubsets(arr, 0, new ArrayList<>());
    }
}

