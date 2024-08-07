import java.util.*;

public class Solution {
    private Map<Integer, String> numToWords;

    public Solution() {
        numToWords = new HashMap<>();
        numToWords.put(0, "Zero");
        numToWords.put(1, "One");
        numToWords.put(2, "Two");
        numToWords.put(3, "Three");
        numToWords.put(4, "Four");
        numToWords.put(5, "Five");
        numToWords.put(6, "Six");
        numToWords.put(7, "Seven");
        numToWords.put(8, "Eight");
        numToWords.put(9, "Nine");
        numToWords.put(10, "Ten");
        numToWords.put(11, "Eleven");
        numToWords.put(12, "Twelve");
        numToWords.put(13, "Thirteen");
        numToWords.put(14, "Fourteen");
        numToWords.put(15, "Fifteen");
        numToWords.put(16, "Sixteen");
        numToWords.put(17, "Seventeen");
        numToWords.put(18, "Eighteen");
        numToWords.put(19, "Nineteen");
        numToWords.put(20, "Twenty");
        numToWords.put(30, "Thirty");
        numToWords.put(40, "Forty");
        numToWords.put(50, "Fifty");
        numToWords.put(60, "Sixty");
        numToWords.put(70, "Seventy");
        numToWords.put(80, "Eighty");
        numToWords.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return numToWords.get(0);
        }

        List<String> parts = new ArrayList<>();

        if (num >= 1000000000) {
            int billions = num / 1000000000;
            parts.add(threeNumToWords(billions));
            parts.add("Billion");
            num %= 1000000000;
        }

        if (num >= 1000000) {
            int millions = num / 1000000;
            parts.add(threeNumToWords(millions));
            parts.add("Million");
            num %= 1000000;
        }

        if (num >= 1000) {
            int thousands = num / 1000;
            parts.add(threeNumToWords(thousands));
            parts.add("Thousand");
            num %= 1000;
        }

        if (num > 0) {
            parts.add(threeNumToWords(num));
        }

        return String.join(" ", parts);
    }

    private String threeNumToWords(int num) {
        if (num == 0) {
            return "";
        }

        List<String> words = new ArrayList<>();

        if (num >= 100) {
            int hundreds = num / 100;
            words.add(numToWords.get(hundreds));
            words.add("Hundred");
            num %= 100;
        }

        if (num > 0) {
            if (num <= 20) {
                words.add(numToWords.get(num));
            } else {
                int tens = num / 10 * 10;
                int units = num % 10;
                words.add(numToWords.get(tens));
                if (units > 0) {
                    words.add(numToWords.get(units));
                }
            }
        }

        return String.join(" ", words);
    }

    // Example usage
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberToWords(1234567));  // Output: One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven
    }
}
