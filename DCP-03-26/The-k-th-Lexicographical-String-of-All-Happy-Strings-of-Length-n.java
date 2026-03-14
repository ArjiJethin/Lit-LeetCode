1class Solution {
2
3    List<String> happyStrings = new ArrayList<>();
4
5    public String getHappyString(int n, int k) {
6        String currentString = "";
7        // Generate all happy strings of length n
8        generateHappyStrings(n, currentString);
9
10        // Check if there are at least k happy strings
11        if (happyStrings.size() < k) return "";
12
13        return happyStrings.get(k - 1);
14    }
15
16    protected void generateHappyStrings(int n, String currentString) {
17        // If the current string has reached the desired length, add it to the
18        // list
19        if (currentString.length() == n) {
20            happyStrings.add(currentString);
21            return;
22        }
23
24        // Try adding each character ('a', 'b', 'c') to the current string
25        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
26            // Skip if the current character is the same as the last character
27            if (
28                currentString.length() > 0 &&
29                currentString.charAt(currentString.length() - 1) == currentChar
30            ) continue;
31
32            // Recursively generate the next character
33            generateHappyStrings(n, currentString + currentChar);
34        }
35    }
36}