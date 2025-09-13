import java.util.*;

public class Aptitude1 {
    public static int balance(int a, int m, int rs) {
        while (a != m) {
            if (a > m) {
                return (rs - (a - m));
            } else if (a < m) {
                return (rs + (m - a));
            } else {
                return (rs);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int m = sc.nextInt();
        int rs = sc.nextInt();
        sc.close();

        int bal = balance(a, m, rs);
        System.out.println(bal);
    }
}