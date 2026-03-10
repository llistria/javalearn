package trs;

public class CE {
    static <S> void main(){
        Container<String, S> container1 = new Container<String, S>();
  container1.set("홍길동");
        String str = container1.get();

        Container<Integer, S> container2 = new Container<Integer, S>();
        container2.set(6);
        int value = container2.get();
    }
}
