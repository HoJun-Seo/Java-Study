package System;
/*
 * 자바 프로그램의 실행에 관련된 메소드 - gc method
 * 메모리 내의 불필요한 객체들을 제거하는 가비지 컬렉터를 더 빨리 작동시켜야 할 경우 System class 의 gc method 를 사용할 수 있다.
 * 이 메소드를 호출한다고 가비지 컬렉터가 즉시 실행된다는 보장은 없지만, 자바 가상 기계는 최대한 빨리 실행되도록 스케줄을 조정할 것이다.
 * 이 프로그램과 Resource class 를 통해 확인할 수 있듯이 가비지 컬렉터는 객체를 제거하기 전에 그 객체의 finalize method 를 호출한다.
 * 그런데 때로는 객체를 제거하는 것이 목적이 아니라, finalize method 를 실행하는 것만이 목적일 수 있다.
 * 그럴때는 gc method 대신 runFinalization method 를 호출하면 된다.
 * System.runFinalization(); - 가비지 컬렉터가 제거 대상 객체들의 finalize method 를 가급적 빨리 호출하도록 요청하는 메소드
 * 이 메소드도 gc method 처럼 finalize method 를 즉시 호출한다는 보장은 없지만, 가비지 컬렉터로 하여금 finalize method 가
 * 가능한 빨리 호출되도록 요청하는 역할을 한다.
 */
public class SystemExample8 {
	public static void main(String[] args) {
		ResourceUser obj = new ResourceUser(); //ResourceUser 객체를 생성한다.
		obj.use(); //ResourceUser 객체를 사용한다.
		obj = null; //ResourceUser 객체를 더 이상 필요치 않은 상태로 만든다.
		System.gc(); //System class 의 gc method 를 호출한다.
	}
}
