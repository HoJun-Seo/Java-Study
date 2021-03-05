package ex06;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class list_tableViewController implements Initializable {
	@FXML
	private ListView<String> listView;
	@FXML
	private TableView<Phone> tableView;
	@FXML
	private ImageView imageView;
	
	@Override
	public void initialize(URL locatSion, ResourceBundle resources) {
		// ListView : 문자열 배열을 저장하여 뷰
		listView.setItems(FXCollections.observableArrayList(
				"갤럭시s1","갤럭시s2","갤럭시s3","갤럭시s4",
				"갤럭시s5","갤럭시s6","갤럭시s7"
				));
		
		listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					tableView.getSelectionModel().select(newValue.intValue());
					// 선택된 인덱스 위치로 스크롤 시킴
					tableView.scrollTo(newValue.intValue());
			}
		});
		
		
		// TableView : 사용작 정의 객체을 저장하여 뷰
		ObservableList<Phone> phoneList = FXCollections.observableArrayList(
				new Phone("갤럭시s1", "phone01.png"),
				new Phone("갤럭시s2", "phone02.png"),
				new Phone("갤럭시s3", "phone03.png"),
				new Phone("갤럭시s4", "phone04.png"),
				new Phone("갤럭시s5", "phone05.png"),
				new Phone("갤럭시s6", "phone06.png"),
				new Phone("갤럭시s7", "phone07.png")
				);
		
		// TableView column와 Phone객체의 멤버변수 맵핑하기
		// fxml에서 작성된 tableView(bean)의 column을 연결
		TableColumn tcSmartPhone = tableView.getColumns().get(0);
		tcSmartPhone.setCellValueFactory(
			new PropertyValueFactory("smartPhone")
		);
		tcSmartPhone.setStyle("-fx-alignment: CENTER;");
		
		TableColumn tcImage = tableView.getColumns().get(1);
		tcImage.setCellValueFactory(
			new PropertyValueFactory("image")
	    );
		tcImage.setStyle("-fx-alignment: CENTER;");
		
		// 컬럼너비 설정
		tcSmartPhone.prefWidthProperty().bind(
				tableView.widthProperty().divide(100).multiply(40));
		tcImage.prefWidthProperty().bind(
				tableView.widthProperty().divide(100).multiply(60));
		tableView.setItems(phoneList);
		
		//tableView항목이 변경될때 마다 이미지뷰 내용이 바뀜
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phone>() {

			@Override
			public void changed(ObservableValue<? extends Phone> observable, Phone oldValue, Phone newValue) {
				if (newValue != null) {
					imageView.setImage(new Image(
							getClass().getResource("images/"+newValue.getImage()).toString()
							));
				}
			}
		});
		
	}

	// 확인버튼 클릭시 호출하는 메서드
	public void OkAction(ActionEvent e) {
		String item = listView.getSelectionModel().getSelectedItem();
		System.out.println("ListView 스마트폰 : "+item);
		
		Phone phone = tableView.getSelectionModel().getSelectedItem();
		System.out.println("TableView 스마트폰 : "+phone.getSmartPhone());
		System.out.println("TableView 이미지 : "+phone.getImage());
		
	}
	// 취소 버튼 클릭시 호출하는 메서드
	public void ExitAction(ActionEvent e) {
		Platform.exit();
	}
}
