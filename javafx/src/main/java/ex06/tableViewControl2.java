package ex06;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class tableViewControl2 extends Application {

	@Override
	public void start(Stage primaryStage) {
		// 최상위 컨테이너 작성
		BorderPane root = new BorderPane();
		// 컨트롤 작성(UI)
		TableView<ProductVo> tableView = new TableView<ProductVo>();
		
		// 컬럼 생성
		TableColumn<ProductVo, String> tc1 = new TableColumn<ProductVo, String>("품목 번호");
		TableColumn<ProductVo, String> tc2 = new TableColumn<ProductVo, String>("품목 명");
		TableColumn<ProductVo, Integer> tc3 = new TableColumn<ProductVo, Integer>("단가");
		
		// 테이블 컬럼 -> ProductVo 멤버변수 매핑
		tc1.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productNo"));
		tc2.setCellValueFactory(new PropertyValueFactory<ProductVo, String>("productName"));
		tc3.setCellValueFactory(new PropertyValueFactory<ProductVo, Integer>("price"));
		
		// 테이블 컬럼에 스타일 적용
		tc1.setStyle("-fx-alignment : CENTER");
		tc2.setStyle("-fx-alignment : CENTER-LEFT");
		tc3.setStyle("-fx-alignment : CENTER-RIGHT");
		
		// 테이블 컬럼 너비 비율 설정
		tc1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.2));
		tc2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.5));
		tc3.prefWidthProperty().bind(tableView.widthProperty().multiply(0.3));
		
		tableView.getColumns().setAll(tc1,tc2,tc3);
		root.setCenter(tableView);
		
		FlowPane pane = new FlowPane();
		pane.setPadding(new Insets(10)); // 컨테이너 안 쪽 여백
		pane.setVgap(10);
		pane.setPrefSize(100, 100);
		pane.setMinWidth(150);
		root.setRight(pane);
		
		Button btn1 = new Button("자료 등록");
		Button btn2 = new Button("자료 추가");
		Button btn3 = new Button("자료 삭제");
		Button btn4 = new Button("자료 선택(셀 단위)");
		Button btn5 = new Button("자료 선택(행 단위)");
		
		btn1.prefWidthProperty().bind(pane.widthProperty().subtract(20));
		btn2.prefWidthProperty().bind(pane.widthProperty().subtract(20));
		btn3.prefWidthProperty().bind(pane.widthProperty().subtract(20));
		btn4.prefWidthProperty().bind(pane.widthProperty().subtract(20));
		btn5.prefWidthProperty().bind(pane.widthProperty().subtract(20));
		
		pane.getChildren().addAll(btn1,btn2,btn3,btn4,btn5);
		
		BorderPane pane2 = new BorderPane();
		pane2.setPadding(new Insets(10));
		root.setBottom(pane2);
		
		TextArea textArea = new TextArea();
		textArea.setPrefHeight(60);
		pane2.setCenter(textArea);
		
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		//----- 이벤트에 따른 기능 처리 ----//
		
		// 1. 자료 등록
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				ProductVo v1 = new ProductVo("A001", "아메리카노", 4000, false, "");
				ProductVo v2 = new ProductVo("A001", "카페라떼", 4300, false, "");
				ProductVo v3 = new ProductVo("A001", "카페모카", 4500, false, "");
				
				// tableView 에 객체(자료) 넣기
				ObservableList<ProductVo> list = FXCollections.observableArrayList(v1,v2,v3);
				tableView.setItems(list);
			}
		});
		
		// 2. 자료 추가
		btn2.setOnAction(e -> {
			ProductVo v4 = new ProductVo("A004", "딸기주스", 5500, false, "");
			tableView.getItems().add(v4);
		});
		
		// 3. 자료 삭제
		// 삭제하고자 하는 행의 인덱스 번호 추출
		btn3.setOnAction(e -> {
			
			int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
			if(selectedIndex >= 0) {
				tableView.getItems().remove(selectedIndex);
			} else {
				// 자료가 없을 경우 처리하는 부분 : 안내 메시지 출력
				String msg = "삭제할 데이터를 선택 후 실행하시기 바랍니다.";
				Alert alert = new Alert(AlertType.INFORMATION, msg);
				alert.setHeaderText("자료 삭제 안내");
				alert.show();
			}
		});
		
		// 4. 셀 단위 선택 이벤트 처리
		btn4.setOnAction(e -> {
			// 셀 단위 선택 할 수 있게 설정 : true
			tableView.getSelectionModel().setCellSelectionEnabled(true);
			ObservableList<TableColumn<ProductVo, ?>> columns = tableView.getColumns(); 
			
			// 1행 1열의 데이터가 있을 경우 자료 선택
			if(columns.size() > 0 && tableView.getItems().size() > 0) {
				TableColumn<ProductVo, ?> tableColumn = tableView.getColumns().get(0);
				tableView.getSelectionModel().select(0, tableColumn);
			}
			
			String msg = "테이블의 셀을 클릭해 보세요";
			Alert alert = new Alert(AlertType.INFORMATION, msg);
			alert.setHeaderText("테이블 셀 선택 기능");
			alert.show();
		});
		
		// 5. 행 단위 선택 이벤트 처리
		btn5.setOnAction(e -> {
			// 행 단위 선택 설정 : false
			tableView.getSelectionModel().setCellSelectionEnabled(false);
			ObservableList<TableColumn<ProductVo, ?>> columns = tableView.getColumns();
			
			if(tableView.getItems().size() > 0) {
				tableView.getSelectionModel().select(0);
			}
			
			String msg = "테이블의 셀을 클릭해 보세요";
			Alert alert = new Alert(AlertType.INFORMATION, msg);
			alert.setHeaderText("테이블 행 선택 기능");
		});
		
		// 6. 테이블 클릭 이벤트
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ProductVo>() {

			@Override
			public void changed(ObservableValue<? extends ProductVo> observable, ProductVo oldValue,
					ProductVo newValue) {
				
				// 선택 값을 TestArea 에 나타내기
				String productNo = newValue.getProductNo();
				String productName = newValue.getProductName();
				int price = newValue.getPrice();
				
				textArea.setText("품목 번호 : " + productNo + "\n" + "품목 명 : " + productName + "\n" + "단가 : " + price);
			}
		});
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
