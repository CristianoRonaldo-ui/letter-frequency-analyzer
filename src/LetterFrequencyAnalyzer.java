import java.util.Scanner;

public class LetterFrequencyAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Letter Frequency Analyzer ===");
        System.out.println("Type a sentence to analyze, or type 'exit' to quit.");

        boolean running = true;

        while (running) {
            System.out.print("\nEnter text: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                running = false;
                continue;
            }
            int[] counts = new int[26];

            for (char ch : input.toCharArray()) {
                char lower = Character.toLowerCase(ch);
                if (lower >= 'a' && lower <= 'z') {
                    int index = lower - 'a';
                    counts[index]++;
                }
            }

            boolean anyLetterFound = false;

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    anyLetterFound = true;
                    char letter = (char) ('a' + i);
                    String bar = "*".repeat(counts[i]);
                    System.out.printf("%c : %s (%d)%n", letter, bar, counts[i]);
                }
            }

            if (!anyLetterFound) {
                System.out.println("No letters found in that input.");
            }
        }

    }

}