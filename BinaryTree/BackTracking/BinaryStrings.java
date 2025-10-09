public class BinaryStrings {
    public static void generate(int n, String current) {
        // Base case
        if (current.length() == n) {
            System.out.println(current);
            return;
        }

        // Recursive case: choose 0 or 1
        generate(n, current + "0");
        generate(n, current + "1");
    }

    public static void main(String[] args) {
        int n = 3;
        generate(n, "");
    }
}


