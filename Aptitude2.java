import java.util.*;

public class Aptitude2 {
    public static int GetBMICategory(int wt, float h) {
        float type = wt / (h * h);
        if (type < 18) {
            return 0;
        } else if (type >= 18 && type < 25) {
            return 1;
        } else if (type >= 25 && type < 30) {
            return 2;
        } else if (type >= 30 && type < 40) {
            return 3;
        } else {
            return 4;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wt = sc.nextInt(); // weight in Kg
        float h = sc.nextFloat(); // Height in metres
        sc.close();

        int cat = GetBMICategory(wt, h);
        System.out.println("BMI Category Type: " + cat);
    }
}
