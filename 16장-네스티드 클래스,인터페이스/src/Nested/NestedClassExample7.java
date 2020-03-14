package Nested;

import java.util.HashMap;
/*
 * 메소드 본체 안에 선언된 네스티드 클래스를 로컬 이너 클래스(local inner class) 라고 한다. - 특정 메소드 안에서만 필요한 클래스를 작성하게 되는 경우
 * 로컬 이너 클래스는 메소드 본체 안에서 어느 위치에 선언해도 상관 없지만, 그 클래스를 사용하는 다른 명령문 들 보다는 앞에 와야 한다.
 */
public class NestedClassExample7 {
	public static void main(String[] args) {
		class ContactInfo{
			//로컬 이너 클래스
			String address;
			String phoneNo;
			ContactInfo(String address, String phoneNo){
				this.address = address;
				this.phoneNo = phoneNo;
			}
		}
		HashMap<String, ContactInfo> hashtable = new HashMap<String, ContactInfo>();
		hashtable.put("이순희", new ContactInfo("서울시 강남구", "02-547-0000"));
		hashtable.put("한지영", new ContactInfo("서울시 성북구", "02-920-0000"));
		hashtable.put("박철규", new ContactInfo("경기도 고양시", "031-915-0000"));
		ContactInfo obj = hashtable.get("한지영");
		System.out.println("<한지영의 연락처>");
		System.out.println("주소 : " + obj.address);
		System.out.println("전화번호 : " + obj.phoneNo);
	}
}
