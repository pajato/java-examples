import java.util.Locale;

/**
 * Implement a regular expression function isMatch that supports the '.' and '*' symbols. The
 * function receives two strings - text and pattern - and should return true if the text matches the
 * pattern as a regular expression. For simplicity, assume that the actual symbols '.' and '*' do
 * not appear in the text string and are used as special symbols only in the pattern string.
 *
 * In case you aren’t familiar with regular expressions, the function determines if the text and
 * pattern are the equal, where the '.' is treated as a single a character wildcard (see third
 * example), and '*' is matched for a zero or more sequence of the previous letter (see fourth and
 * fifth examples). For more information on regular expression matching, see the Regular Expression
 * Wikipedia page.
 *
 * Explain your algorithm, and analyze its time and space complexities.
 */
class Main {

    static boolean isMatch(String text, String pattern) {
        // Handle boundary conditions.
        if (text == null || pattern == null)
            return false;

        // Handle non-trivial cases, those with non-null text and pattern strings by walking the
        // pattern string to ensure that the text is a match.
        int textIndex = 0;
        char matchChar;
        for (int patternIndex = 0; patternIndex < pattern.length(); patternIndex++) {
            // Handle the case where the input is empty and the pattern is of the form "x*".
            String currentText = textIndex < text.length() ? text.substring(textIndex) : "";
            String currentPattern = pattern.substring(patternIndex);
            System.out.println(String.format(Locale.US, "Iterating on (%s, %s)", currentText, currentPattern));
            if (isEmptyMatch(currentText, currentPattern))
                return true;

            // ...
            if (currentPattern.startsWith(".*"))
                // Accept the input text.
                return true;
            else if (currentPattern.startsWith("."))
                // Accept this character.
                textIndex++;
            else if (currentPattern.length() > 1 && currentPattern.charAt(1) == '*') {
                // Match zero or more occurrences of the character at current pattern position 0.
                // First handle the non-match case.
                if (currentPattern.charAt(0) != currentText.charAt(0))
                    // No match, just adjust the indices and continue.
                    patternIndex++;
                else {
                    int pIndex = 0;
                    int tIndex = 0;
                    while (currentPattern.charAt(pIndex) == 'a') {
                        // tbd.
                    }
                }
                // Match the current character
                if (currentText.charAt(0) != currentPattern.charAt(0))
                    return false;
        }
            // Ensure that the input text has at least one more character. If not, then there is no
            // match.
            char textChar = textIndex < text.length() ? text.charAt(textIndex++) : (char)-1;
            char patternChar = pattern.charAt(patternIndex);
            switch (patternChar) {
                case '.':
                    // Ensure that there is a text character and continue, else fail.
                    if (textChar == -1)
                        return isEmptyMatch("", pattern.substring(patternIndex));
                    break;
                default:
                    // In this case, there are two scenarios:
                    // 1) the next pattern char is a * in which case "globbing" is done;
                    // 2) the next pattern char is not a * in which case the current characters must
                    //    match.
                    if (patternIndex + 1 < pattern.length()) {
                        // Detect globbing.
                        if (pattern.charAt(patternIndex + 1) == '*') {
                            // Perform globbing.
                            int matchCount = 0;
                            while (textChar != -1 && (patternChar == '.' || textChar == patternChar)) {
                                matchCount++;
                                textChar = textIndex < text.length() ? text.charAt(textIndex++) : (char) -1;
                            }
                            patternIndex++;
                            if (matchCount == 0)
                                textIndex--;
                        } else
                            // The current characters must match.
                            if (textChar != patternChar)
                                return false;
                    } else {
                        // There are no more pattern characters.  This one must match.
                        if (textChar != patternChar)
                            return false;
                    }
                    break;
            }
        }
                return textIndex == text.length();
    }

    public static void main(String[] args) {
        process(null, null, false);
        process("", "a*", true);
        process("aa", "a", false);
        process("aa", "aa", true);
        process("abc", "a.c", true);
        process("abbb", "ab*", true);
        process("acd", "ab*c.", true);
        process("abaa", "a.*a*", true);
    }

    private static void process(String input, String pattern, boolean expected) {
        boolean actual = isMatch(input, pattern);
        String answer = actual == expected ? "correct." : "wrong!";
        final String format = "isMatch(%s, %s) is %s";
        System.out.println(String.format(Locale.US, format, input, pattern, answer));
    }

    private static boolean isEmptyMatch(String text, String pattern) {
        System.out.println(String.format(Locale.US, "isEmptyMatch(%s, %s)", text, pattern));
        return text.isEmpty() && !pattern.isEmpty() && pattern.length() > 1 && pattern.charAt(1) == '*';
    }
}
