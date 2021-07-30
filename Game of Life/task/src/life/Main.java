
package life;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static int len = 0;
    public static int seed = 0;
    public static int generation = 0;

    public static void main(String[] args) {
          start();
          GameOfLife game = new GameOfLife(len,seed,generation);
          game.findGeneration();
          game.print();
        ;
    }
    private static void start() {
        Scanner scanner = new Scanner(System.in);
        len = Integer.parseInt(scanner.next());
        seed = Integer.parseInt(scanner.next());
        generation = Integer.parseInt(scanner.next());
    }
}
