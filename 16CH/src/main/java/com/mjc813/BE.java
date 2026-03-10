package com.mjc813;

public class BE {
    static void main(){
        Button btnOK = new Button();
        btnOK.setClickListener(()-> {
            System.out.println("OK 버튼을 클릭했ㅅㅂ니다");
        });
        btnOK.click();

        Button btnCancel = new Button();
        btnCancel.setClickListener(()-> {
            System.out.println("Cansel 버튼을 클릭했ㅅㅂ니다");
        });
        btnCancel.click();

    }
}
