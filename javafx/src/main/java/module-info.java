module javafx {
	// 모듈 접근 허용
	exports javafx;
	exports ex03;
	exports ex04;
	exports ex05;
	exports ex06;
	exports ex07;

	//모듈 내에 패키지 접근 허용
	requires javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.base;
	requires lombok;
	requires javafx.media;
	
	//모듈 내에 패키지에 있는 클래스 접근
	opens ex04;
	opens ex06;
	opens ex06.dto;
	opens ex06.controller;
	opens ex07;
}