package ex06.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ex06.ProductVo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class tableViewController implements Initializable{
	
	@FXML private TableView<ProductVo> tableView;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		ObservableList<ProductVo> list = FXCollections.observableArrayList(
				new ProductVo("a001","아메리카노",4000, true, "A"),
				new ProductVo("a002","까페라떼",4300, false, "B"),
				new ProductVo("a003","까페모카",4500, true, "C")
			);
		
		
		// fxml 에서 생성한 테이블 컬럼을 객체변수에 연결
		TableColumn tc1 = tableView.getColumns().get(0);
		TableColumn tc2 = tableView.getColumns().get(1);
		TableColumn tc3 = tableView.getColumns().get(2);
		TableColumn tc4 = tableView.getColumns().get(3);
		TableColumn tc5 = tableView.getColumns().get(4);
		TableColumn tc6 = tableView.getColumns().get(5);
		
		/* TableColumn <-> 데이터(ProductVo) 속성 매핑*/
		tc1.setCellValueFactory(new PropertyValueFactory("productNo"));
		tc2.setCellValueFactory(new PropertyValueFactory("productName"));
		tc3.setCellValueFactory(new PropertyValueFactory("price"));
		tc4.setCellValueFactory(new PropertyValueFactory("checkYn"));
		tc5.setCellValueFactory(new PropertyValueFactory("checkYn"));
		tc6.setCellValueFactory(new PropertyValueFactory("productCode"));
		
		tableView.setItems(list);
	}
}
