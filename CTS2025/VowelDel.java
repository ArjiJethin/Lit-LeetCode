public class VowelDel {
    static String deleteVowels(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (!"AEIOUaeiou".contains(ch + "")) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "Hello World!";
        String output = VowelDel.deleteVowels(input);
        System.out.println("Original String: " + input);
        System.out.println("String after deleting vowels: " + output);
    }
}
