public class Working {
    private static String numinT;

    private static int desZn;
    private static int edZn;
    private static int test1;

    private static int bill;
    private static int mill;
    private static int thou;
    private static int toThou;
    private static long numN;
    private static long numMax = 999999999999999L;

    private static final String[][] textMillN = {{"", "", "", ""},
            {"миллиардов ", "миллионов ", "тысячь ", ""},
            {"миллиард ", "миллион ", "тысяча ", ""},
            {"миллиарда ", "миллиона ", "тысячи ", ""},
            {"миллиардов ", "миллионов ", "тысячь ", ""}};

    private static final String[] s11to19 = {"десять ", "одинадцать ", "двенадцать ", "тринадцать ", "четырнадцать ", "пятнадцать ",
            "шеснадцать ", "семьнадцать ", "восемьнадцать ", "девятнадцать ", "девятнадцать "};

    private static final String[][] sT = {{"", "од", "дв", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"},
            {"", "десять ", "двадцать ", "тридцать ", "сорок ", "пятьдесят ", "шестьдесят ", "семьдесят ", "восемьдесят ", "девяносто "},
            {"", "сто ", "двести ", "триста ", "четыреста ", "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "}};

    public static String WR(long number) {
        numN = number;
        numinT = "";

        if (number < 0) {
            numinT = "Минус ";
            numN = -numN;
        }
        if (numN == 0) {
            numinT = "Ноль ";
        }

        if (numN < -numMax || numN > numMax) {
            return numinT = "Число выходит за границы.";
        }
        bill = (int) (numN / 1000000000);
        mill = (int) (numN - (bill * 1000000000)) / 1000000;
        thou = (int) (numN - (bill * 1000000000) - (mill * 1000000)) / 1000;
        toThou = (int) (numN % 1000);

        numinT = numinT + WtoT(bill, 0) + WtoT(mill, 1) + WtoT(thou, 2) + WtoT(toThou, 3);
        return numinT;
    }

    private static String WtoT(int numericalValue, int index) {
        numinT = "";
        int sot = numericalValue / 100;
        edZn = numericalValue % 10;
        desZn = (numericalValue - (sot * 100)) / 10;
        if (desZn == 1) numinT = sT[2][sot] + s11to19[edZn];
        else numinT = sT[2][sot] + sT[1][desZn] + sT[0][edZn];

        if (index == 2) {
            if (edZn == 1 && desZn != 1) numinT = numinT + "на ";
            else if (edZn == 2 & desZn != 1) numinT = numinT + "е ";
            if (edZn > 1 && desZn != 1) numinT = numinT + " ";
        } else {
            if (edZn == 1 && desZn != 1) numinT = numinT + "ин ";
            if (edZn == 2 & desZn != 1) {
                numinT = numinT + "а ";
            } else if (edZn != 0 & desZn != 1) numinT = numinT + " ";
        }

        test1 = 0;
        if (numericalValue != 0 ) {
            if (edZn == 0 || desZn == 1 )   test1 = 1;
            else if (edZn == 1)              test1 = 2;
            else if (edZn > 1 & edZn < 5)  test1 = 3;
            else                            test1 = 4;}
        numinT = numinT + textMillN[test1][index];
        return numinT;
    }
}