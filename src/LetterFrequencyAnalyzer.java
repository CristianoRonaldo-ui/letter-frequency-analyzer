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
            int totalLetters = 0;

            for (char ch : input.toCharArray()) {
                char lower = Character.toLowerCase(ch);
                if (lower >= 'a' && lower <= 'z') {
                    int index = lower - 'a';
                    counts[index]++;
                    totalLetters++;
                }
            }

            boolean anyLetterFound = false;

            int maxCount = 0;
            char maxLetter = ' ';
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 0) {
                    anyLetterFound = true;
                    char letter = (char) ('a' + i);
                    String bar = "*".repeat(counts[i]);
                    double percentage = (counts[i] * 100.0) / totalLetters;
                    System.out.printf("%c : %s (%d, %.1f%%)%n", letter, bar, counts[i], percentage);
                    if (counts[i] > maxCount) {
                        maxCount = counts[i];
                        maxLetter = letter;
                    }
                }
            }

            if (!anyLetterFound) {
                System.out.println("No letters found in that input.");
            } else {
                System.out.println("Most frequent letter: '" + maxLetter + "' (" + maxCount + " times)");
            }
        }

    }

}