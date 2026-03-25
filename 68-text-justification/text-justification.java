import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int lineLen = 0;

            // Step 1: pick words for current line
            while (j < words.length &&
                   lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // Step 2: Last line OR single word
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }

                // fill remaining spaces at end
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
            // Step 3: Normal full justification
            else {
                int totalSpaces = maxWidth - lineLen;
                int spaceEach = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int spaces = spaceEach + (extra > 0 ? 1 : 0);

                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }

                        if (extra > 0) extra--;
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}