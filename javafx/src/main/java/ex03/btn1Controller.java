package ex03;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class btn1Controller implements Initializable{

	@FXML
	public Button btn1; // fxml 에서 fx:id가 "btn1" 객체를 참조 =>(실제로 실행되는 코드) private Button btn1 = new Button(); 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn1.setOnAction(e -> System.out.println("안녕하세요"));
		
	}
	
	public void click(ActionEvent e) {
		System.out.println("버튼을 클릭 하였습니다.");
	}

}
