package com.mjc813;

import java.util.Scanner;

public class sec13 {
    public void howToUseVariable() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("x 값 입력");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);

        System.out.print("y 값 입력");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);

        int result = x + y;
        System.out.println("X + Y: " + result);
        System.out.println();

        while (true) {
            System.out.print("입력문자열");
            String data = scanner.nextLine();
            if (data.equals("q")) {
                break;
            }
            System.out.println("출력 문자열: " + data);
            System.out.println();
        }
    }
}
