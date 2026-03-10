package trs;

public class CE2 {
    static void main(){
        Container3<String, String> container1 = new Container3<String,String>();
        container1.set("홍길동", "도적");
        String name1 = container1.getKey();
        String job = container1.getValue();

        Container3<String, Integer> container2 = new Container3<String, Integer>();
        container2.set("홍길동",35);
        String name2 = container2.getKey();
        int age = container2.getValue();

        System.out.println(age);
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(job);

    }
}
