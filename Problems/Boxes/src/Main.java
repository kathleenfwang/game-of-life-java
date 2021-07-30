import java.util.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // write your code here
        final String INCOMPATIBLE = "Incompatible";
        Scanner scanner = new Scanner(System.in);
        String result = "";
        int[] box1 = new int[3];
        int[] box2 = new int[3];

        for (int i =0;i<3;i++) {
            box1[i] = scanner.nextInt();
        }
        for (int i =0;i<3;i++) {
            box2[i] = scanner.nextInt();
        }
        Arrays.sort(box1);
        Arrays.sort(box2);
        int bigger1 = 0;
        int bigger2 = 0;
        for (int i =0;i<box1.length;i++) {
            if (box1[i] > box2[i]) bigger1 +=1;
            else if (box1[i] < box2[i]) bigger2 +=1;
             else {
                 result = INCOMPATIBLE;
                 break;
            }
        }
        if (result.equals(INCOMPATIBLE)) {
            System.out.println(INCOMPATIBLE);
        }
        else {
            System.out.println(bigger1 > bigger2 ? "Box 1 > Box 2" : "Box 1 < Box 2");
        }

    }
}