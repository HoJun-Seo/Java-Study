package ex06.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class DialogController implements Initializable{
	
	@FXML private Button btnOpen;
	@FXML private Button btnSave;
	@FXML private Button btnDir;
	@FXML private Button btnPopup;
	@FXML private Button btnCustom;
	
	// root 컨테이너를 이용해서 자신이 소속된 윈도우 창을 추출
	@FXML private HBox hbox;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnOpen.setOnAction(event -> open(event));
		btnSave.setOnAction(event -> save(event));
		btnDir.setOnAction(event -> dir(event));
		btnPopup.setOnAction(event -> popup(event));
		btnCustom.setOnAction(event -> custom(event));
	}

	private Stage primaryStage;
	public void  setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void open(ActionEvent event) {
		System.out.println("open....");
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Text Files", "*.txt"),
				new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
				new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
				new ExtensionFilter("All Files", "*.*")
				);
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		if(selectedFile != null) {
			System.out.println("선택된 파일의 경로 : " + selectedFile.getPath());
			System.out.println("선택된 파일의 이름 : " + selectedFile.getName());
		}
	}
	public void save(ActionEvent event) {
		System.out.println("save....");
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("All Files", "*.*")
				);
		File selectedFile = fileChooser.showOpenDialog(hbox.getScene().getWindow());
		if(selectedFile != null) {
			System.out.println("선택된 파일의 경로 : " + selectedFile.getPath());
			System.out.println("선택된 파일의 이름 : " + selectedFile.getName());
		}
	}
	public void dir(ActionEvent event) {
		System.out.println("dir....");
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDir = directoryChooser.showDialog(hbox.getScene().getWindow());
		if(selectedDir != null) {
			System.out.println("dir 선택 : " + selectedDir.getPath());
		}
	}
	
	public void custom(ActionEvent event) {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("확인");
		
		try {
			AnchorPane anchorPane = 
					(AnchorPane)FXMLLoader.load(getClass().getResource("/ex06/view/customView.fxml"));
			
			Label txtTitle = (Label)anchorPane.lookup("#txtMessage");
			Button btnOk = (Button) anchorPane.lookup("#btnOk");
			
			btnOk.setOnAction(e -> dialog.close());
			
			Scene scene = new Scene(anchorPane);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void popup(ActionEvent event)  {
		Popup popup = new Popup();
		
		HBox hbox;
		try {
			hbox = (HBox)FXMLLoader.load(getClass().getResource("/ex06/view/popupView.fxml"));
			ImageView imageView = (ImageView) hbox.lookup("#imgView");
			Label lblMessage = (Label) hbox.lookup("#lblMessage");
			imageView.setImage(new Image(getClass().getResource("/ex06/images/dialog-help.png").toString()));
			lblMessage.setText("메세지가 변경 되었습니다.");
			
			popup.getContent().add(hbox);
			popup.setAutoHide(true); // 자동숨김 : 팝업창 없애기
			popup.show(primaryStage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
