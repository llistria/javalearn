/**package com.mjc813;

import java.util.Scanner;

public class BankApp {
    public void bank(){
        Account account = new Account();

        account.setBalance

        String[] names = new String[100]; // 배열의 길이 설정
        int[] numbers = new int[100];

        // 배열의 길이
        int size = names.length;

        Scanner sc = new Scanner(System.in);


        Scanner scanner = new Scanner(System.in);
        System.out.print("선택(1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료)");
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);

        if(x == 1){
            System.out.println("계좌생성");
            for (int i = 0; i < size; i++) {
                // 문자열 입력
                System.out.println("이름을 입력하세요");
                names[i] = sc.next();

                // 숫자형 입력
                System.out.println("숫자를 입력하세요");
                numbers[i] = sc.nextInt();

                for (int y = 0; y < size; y++) {
                    System.out.println(y + "번째 이름:" + names[y] + ", 숫자:" + numbers[y]);
                }
            }
        }
        if(x == 2){
            System.out.println("계좌목록");
        }
        if(x == 3){
            System.out.println("예금");
        }
        if(x == 4){
            System.out.println("출금");
        }
        if(x == 5){
            System.out.println("종료");
        }
    }

}
 **/
