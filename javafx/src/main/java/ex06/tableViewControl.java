package ex06;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class tableViewControl extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		// 최상위 컨테이너(root)
		BorderPane root = new BorderPane();
		// 테이블 뷰 정의
		TableView<ProductVo> tableView = new TableView<ProductVo>();
		// 테이블 컬럼 정의
		TableColumn<ProductVo, String> tc1 = new TableColumn<ProductVo, String>("품목 번호");
		TableColumn<ProductVo, String> tc2 = new TableColumn<ProductVo, String>("품목 명");
		TableColumn<ProductVo, Integer> tc3 = new TableColumn<ProductVo, Integer>("단가");
		
		// 테이블 컬럼과 데이터타입 멤버 변수와 맵핑
		tc1.setCellValueFactory(new PropertyValueFactory<ProductVo,String>("productNo"));
		tc2.setCellValueFactory(new PropertyValueFactory<ProductVo,String>("productName"));
		tc3.setCellValueFactory(new PropertyValueFactory<ProductVo,Integer>("price"));
		
		// 컬럼에 스타일 적용
		tc1.setStyle("-fx-alignment:CENTER");
		tc2.setStyle("-fx-alignment:CENTER-LEFT");
		tc3.setStyle("-fx-alignment:CENTER");
		
		// 데이터 목록 추가
		ProductVo v1 = new ProductVo("A001", "아메리카노", 4000, false, "");
		ProductVo v2 = new ProductVo("A002", "카페라떼", 4300, false, "");
		ProductVo v3 = new ProductVo("A003", "카페모카", 4500, false, "");
		
		ObservableList<ProductVo> list = FXCollections.observableArrayList(v1,v2,v3);
		tableView.setItems(list);
		
		tableView.getColumns().setAll(tc1,tc2,tc3);
		root.setCenter(tableView);
		
		Scene scene = new Scene(root, 400, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
