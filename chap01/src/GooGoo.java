public class GooGoo
{
    public static void main(String[] args) {
        for (int i = 1; i < 10; i = i + 3) {
            for (int j = 1; j < 10; j++) {
                for (int k = i; k < i + 3; k++) {
                    System.out.print(k + "X" + j + "=" + j * k + "\t");
                }
                System.out.println();
            }
            System.out.println("**************************");
        }
    }
}