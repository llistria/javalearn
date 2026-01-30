package clsqjsanswp;

public class Example {
    public static void action(A a) {
        a.method1();

        if (a instanceof C c) {
            // 다운캐스팅
            c.method2();
        }


    }

    public static void main() {
        action(new B());
        action(new C());
    }
}
