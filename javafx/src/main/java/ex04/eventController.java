package ex04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class eventController implements Initializable {
	
	// FXML 에서 작성된 태그 요소를 참조하는 변수 선언
	@FXML private Button btn1;
	@FXML private Button btn2;
	@FXML private Button btn3;
	@FXML private TextField txt1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 버튼의 클릭이벤트 : OnAction 메소드로 처리
//		btn1.setOnAction(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent event) {
//				System.out.println("버튼1 클릭했습니다.");
//			}
//		});
		btn1.setOnAction(e ->{
			System.out.println("버튼1 람다식 클릭했습니다.");
			txt1.setText("버튼1 클릭");
		});
		btn2.setOnAction(e -> click2(e));
		btn3.setOnAction(e -> click3(e));
	}
	
	public void click2(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("버튼2 메소드 호출 클릭했습니다.");
		txt1.setText("버튼2 클릭");
	}

	// 호출할 메소드 정의
	public void click3(ActionEvent e) {
		System.out.println("버튼3 클릭했습니다.");
		txt1.setText("버튼3 클릭");
	}
}
