package System;

public class ResourceUser {
	ResourceUser() {
		System.out.println("시스템 자원을 할당 받습니다.");
	}
	void use() {
		System.out.println("시스템 자원을 사용합니다.");
	}
	protected void finalize() {
		System.out.println("시스템 자원의 할당을 해제합니다.");
	}
}
