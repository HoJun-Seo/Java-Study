package ex06;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class buttonController implements Initializable{
	@FXML CheckBox chk1;
	@FXML CheckBox chk2;
	@FXML ImageView chkImageView;
	@FXML ToggleGroup group;
	@FXML ImageView radioImageView;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chk1.setOnAction(e -> checked(e));
		chk2.setOnAction(e -> checked(e));
		
		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				Image image = new Image(getClass().getResource("images/"+newValue.getUserData().toString()+".png").toString());
				radioImageView.setImage(image);
			}
		});
	}
	
	public void checked(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("e" + e.toString());
		// 2개 항목 체크 시
		if(chk1.isSelected() && chk2.isSelected()) {
			// URL 경로를 문자열로 표현을 해주기 위해 toString 메소드 사용
			chkImageView.setImage(new Image(getClass().getResource("images/KakaoTalk_20200608_214040380.jpg").toString()));
		} else if(chk1.isSelected()) { // 첫번째 항목만 체크 시
			chkImageView.setImage(new Image(getClass().getResource("images/david-baylis-final3.jpg").toString()));
		} else if(chk2.isAllowIndeterminate()) { //두번째 항목만 체크 시
			chkImageView.setImage(new Image(getClass().getResource("images/david-baylis-final3.jpg").toString()));
		} else { // 2개 항목 모두 미체크 시
			chkImageView.setImage(new Image(getClass().getResource("images/캡처.jpg").toString()));
		}
	}

	public void Exit(ActionEvent e) {
		Platform.exit();
	}

}
