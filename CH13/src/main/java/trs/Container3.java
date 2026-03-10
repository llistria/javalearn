package trs;

import lombok.Getter;

@Getter
public class Container3<T, T1> {

    private T key;
    private T1 value;

    public void set(T key, T1 value) {
        this.key = key;
        this.value = value;
    }

}