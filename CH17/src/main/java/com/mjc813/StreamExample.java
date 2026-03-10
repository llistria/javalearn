package com.mjc813;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class StreamExample {
    static void main() {
        Set<String>set = new HashSet<>();
        set.add("전서현");
        set.add("김준식");
        set.add("유은후");

        Stream<String> stream = set.stream();
        stream.forEach(System.out::println);
    }
}
