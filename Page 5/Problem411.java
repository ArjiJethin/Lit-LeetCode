public class Problem411 {
    public static void main(String[] args) {
        // Example usage
        String target = "apple";
        String[] dictionary = { "blade", "plain", "amber", "abandon", "apple" };
        Solution solution = new Solution();
        String result = solution.minAbbreviation(target, dictionary);
        System.out.println(result); // Expected output: "a2e"
    }
}

class Solution {
    public String minAbbreviation(String target, String[] dictionary) {
        int length = target.length();
        int totalCount = 1 << length;
        String minAbbr = target;
        int minLength = length;
        for (int i = totalCount; i > 0; i--) {
            String abbr = generateAbbreviation(target, i);
            if (abbr.length() > minLength)
                continue;
            boolean flag = true;
            for (String word : dictionary) {
                if (word.length() == length) {
                    String abbr2 = generateAbbreviation(word, i);
                    if (abbr2.equals(abbr)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                if (abbr.length() < minLength) {
                    minAbbr = abbr;
                    minLength = abbr.length();
                }
            }
        }
        return minAbbr;
    }

    public String generateAbbreviation(String word, int num) {
        StringBuffer sb = new StringBuffer();
        int consecutiveCount = 0;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            int cur = num & 1;
            if (cur == 1)
                consecutiveCount++;
            else {
                if (consecutiveCount > 0) {
                    sb.append(consecutiveCount);
                    consecutiveCount = 0;
                }
                sb.append(word.charAt(i));
            }
            num >>= 1;
        }
        if (consecutiveCount > 0)
            sb.append(consecutiveCount);
        return sb.toString();
    }
}