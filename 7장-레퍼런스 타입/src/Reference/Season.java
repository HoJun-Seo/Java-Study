package Reference;

enum Season {
	SPRING("봄"), SUMMER("여름"), FALL("가을"), WINTER("겨울"); //생성자 파라미터 값으로 넘겨줄 문자열을 작성한다.
	final private String name; //final private : 열거 상수들을 다른 값과 연관지으려 할 때 반드시 작성해야 할 키워드 
	Season(String name){
		this.name = name; //파라미터 값으로 필드를 초기화한다.
	}
	String value() { //열거 상수에 연관된 값을 리턴하는 메소드
		return name;
	}
}
