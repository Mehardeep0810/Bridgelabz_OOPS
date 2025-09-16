package Assigned6.level2;

class PalindromeChecker {
    String text;

    boolean isPalindrome() {
        String reversed = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        return text.equalsIgnoreCase(reversed);
    }
}

public class Palindrome {
    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();
        checker.text = "Madam";

        if (checker.isPalindrome()) {
            System.out.println(checker.text + " is a palindrome.");
        } else {
            System.out.println(checker.text + " is not a palindrome.");
        }
    }
}