package com.mjc813;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UseObject {
    private String id;
    private String name;

    @Override
    public boolean equals(Object ob) {
        // this 와 매개변수 ob 를 비교해서 같을때 true 를 리턴
        if ( ob instanceof UseObject object  // 매개변수 ob 가 UseObject 클래스형 인지 체크
                && this.hashCode() == object.hashCode() // 자기의 주소와 매개변수 ob 객체의 주소가 같은지 체크
                && this.getId().equals( object.getId() ) // 자기의 id 멤버변수와 ob 객체의 id 멤버변수 값이 같은지 체크
                && this.getName().equals( object.getName() ) // 자기의 name 멤버변수와 ob 객체의 name 멤버변수 값이 같은 체크
        ) {
            return true;    // 4가지 가 모두 같으면 true 를 리턴
        }
        return false; // 하나라도 틀리면 false 를 리턴
    }

    //	@Override
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Object 의 clone 메소드를 오버라이드 할때는 객체 복사를 깊은 복사를 시킬려고 한다.
        // 멤버변수들의 값을 이용하여 새로운 객체를 만들어서 리턴하는 형태로 자주 사용된다.
        return new UseObject(this.getId(), this.getName());
    }

    //	@Override
//	public int hashCode() {
//		int num = super.hashCode();
//		return num;
//	}
}
