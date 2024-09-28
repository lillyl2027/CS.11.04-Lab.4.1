public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String parentheses) {
        int count = 0;

        for (int i = 0; i < parentheses.length(); i++) {
            if (parentheses.charAt(i) == '(') {
                count++;
            } else if (parentheses.charAt(i) == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }


    // 2. reverseInteger
    public static String reverseInteger(int num) {

        String str = "";
        while (num > 0) {
            int lastDigit = num % 10;
            str = str + lastDigit;
            num = num / 10;
        }

        return str;
    }

    // 3. encryptThis


    public static String encryptThis(String unencrypted) {
        String[] message = unencrypted.split(" "); // using arrays to split input into array of words based on space character
        StringBuilder encryptedFullMessage = new StringBuilder(); // stores encrypted message in stringbuilder (so I can edit it)
        for (int i = 0; i < message.length; i++) {
            String word = message[i];
            StringBuilder encryptedWord = new StringBuilder(); //  encrypted singular word in stringbuilder

            encryptedWord.append((int) word.charAt(0)); // replacing first letter with character code - manual casting

            if (word.length() > 1) { // switching second and last letter
                encryptedWord.append(word.charAt(word.length() - 1));
                if (word.length() > 3) {
                    encryptedWord.append(word.substring(2, word.length() - 1));
                }
                if (word.length() > 2) {
                    encryptedWord.append(word.charAt(1));
                }
            }
            encryptedFullMessage.append(encryptedWord); // adding encrypted word to encrypted full message
            if (i < message.length - 1) {
                encryptedFullMessage.append(" ");
            }
        }

        return encryptedFullMessage.toString();
    }



// 4. decipherThis
public static String decipherThis(String str) {
    String[] words = str.split(" ");
    StringBuilder output = new StringBuilder();

    for (String word : words) {
        String firstLetterCode = "";
        StringBuilder deciphered = new StringBuilder();

        for (int i = 0; i < word.length() && Character.isDigit(word.charAt(i)); i++) { // Extract the numerical code for the first letter
            firstLetterCode += word.charAt(i);
        }

        char firstLetter = (char) Integer.parseInt(firstLetterCode); // convert the numerical code to a character
        deciphered.append(firstLetter);
        String restOfWord = word.substring(firstLetterCode.length());

        if (restOfWord.length() > 1) { // append and rearrange
            deciphered.append(restOfWord.charAt(restOfWord.length() - 1));
            deciphered.append(restOfWord, 1, restOfWord.length() - 1);
            deciphered.append(restOfWord.charAt(0));
        } else {
            deciphered.append(restOfWord);
        }

        output.append(deciphered).append(" ");
    }

    return output.toString().trim();
}
}
