public class Problem379 {
    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory(3);
        System.out.println(phoneDirectory.get()); // returns 0
        System.out.println(phoneDirectory.check(1)); // returns true
        System.out.println(phoneDirectory.get()); // returns 1
        System.out.println(phoneDirectory.get()); // returns 2
        System.out.println(phoneDirectory.check(2)); // returns false
        phoneDirectory.release(2); // release number 2 back to the directory
        System.out.println(phoneDirectory.check(2)); // returns true
    }
}

class PhoneDirectory {

    private boolean[] provided;

    /**
     * Initialize your data structure here
     * 
     * @param maxNumbers - The maximum numbers that can be stored in the phone
     *                   directory.
     */
    public PhoneDirectory(int maxNumbers) {
        provided = new boolean[maxNumbers];
    }

    /**
     * Provide a number which is not assigned to anyone.
     * 
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        for (int i = 0; i < provided.length; ++i) {
            if (!provided[i]) {
                provided[i] = true;
                return i;
            }
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !provided[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        provided[number] = false;
    }
}