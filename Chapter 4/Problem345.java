public class Problem345 {
    public static void main(String[] args) {
        // Example usage
        String s = "hello";
        Solution solution = new Solution();
        System.out.println(solution.reverseVowels(s)); // Output: "holle"
    }
}

class Solution {
    public String reverseVowels(String s) {
        char[] a = s.toCharArray();

        int l = 0; // left
        int r = a.length - 1; // right

        while (l < r) {
            if (isVowel(a[l]) && isVowel(a[r])) {
                swap(a, l++, r--);
            } else if (isVowel(a[l])) {
                r--;
            } else {
                l++;
            }
        }

        return new String(a);
    }

    private boolean isVowel(char b) { // The letters A, E, I, O, and U are called vowels
        char c = Character.toLowerCase(b);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private void swap(char[] cs, int start, int end) {
        char temp = cs[start];
        cs[start] = cs[end];
        cs[end] = temp;
    }
}
