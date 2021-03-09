package ex06.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class menuBarController implements Initializable{
	@FXML private TextArea txtArea;
	@FXML private Button btnNew;
	@FXML private Button btnOpen;
	@FXML private Button btnSave;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnSave.setOnAction(e -> saveAction(e));
		btnNew.setOnAction(e -> newAction(e));
		btnOpen.setOnAction(e -> openAction(e));
	}
	
	public void newAction(ActionEvent e) {
		System.out.println("새 파일");
		txtArea.appendText("새 파일이 생성 되었습니다.\n");
	}
	public void openAction(ActionEvent e) {
		System.out.println("불러오기");
		txtArea.appendText("파일을 불러왔습니다.\n");
	}
	public void saveAction(ActionEvent e) {
		System.out.println("저장하기");
		txtArea.appendText("파일이 저장 되었습니다.\n");
	}
	public void closeAction(ActionEvent e) {
		System.out.println("닫기");
		Platform.exit();
	}

}
