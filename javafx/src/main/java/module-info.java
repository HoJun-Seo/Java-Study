module javafx {
	// 모듈 접근 허용
	exports javafx;
	exports ex03;
	exports ex04;
	exports ex05;

	//모듈 내에 패키지 접근 허용
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	
	//모듈 내에 패키지에 있는 클래스 접근
	opens ex04;
}