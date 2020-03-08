import java.util.Scanner;
public class Main {
    private static Convert TestNumber;
    public static void main(String[] args) {
        while (true) {
            long num;
            Scanner t = new Scanner(System.in);
            System.out.print("Введите число от 1 до 999.999.999.999 [число с минусом писать {-}]: ");
            num = (long) t.nextDouble();
            System.out.println(TestNumber.WR(num));
        }
    }
}
