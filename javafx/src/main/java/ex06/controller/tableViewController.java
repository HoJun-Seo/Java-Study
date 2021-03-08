package ex06.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ex06.ProductVo;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class tableViewController implements Initializable{
	
	@FXML private TableView<ProductVo> tableView;
	@FXML private TextArea txtArea;
	
	
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
		
		tc4.setCellFactory(new Callback<TableColumn<ProductVo, Boolean>, TableCell<ProductVo, Boolean>>() {
			
			public TableCell<ProductVo, Boolean> call(TableColumn<ProductVo, Boolean> param){
				TableCell<ProductVo, Boolean> tableCell = new TableCell<ProductVo, Boolean>(){
					
					// Button 객체 생성
					private Button btn = new Button("버튼1");
					{
						btn.setStyle("-fx-font-size:12px; -fx-padding:0");
						btn.setMaxHeight(20); btn.minHeight(20);
						btn.setPrefSize(100,20);
						
						// button 이벤트 처리
						btn.setOnAction(event -> {
							int index = getTableRow().getIndex();
							
							ProductVo productVo2 = tableView.getItems().get(index);
							productVo2.setProductCode("B");
							
							tableView.refresh();
							tableView.getSelectionModel();
							System.out.println("버튼1 클릭...");
						});
					}
					// 초기화 블록 끝
					
					@Override
					protected void updateItem(Boolean item, boolean empty) {
						super.updateItem(item, empty);
						
						if (item != null && item == true && !empty) {
							this.setGraphic(btn);
						} else {
							this.setGraphic(null);
						}
					}
					
				};
				return tableCell;
			}
		});
		
		tc5.setCellFactory(new Callback<TableColumn<ProductVo, Boolean>, TableCell<ProductVo, Boolean>>() {
			
			public TableCell<ProductVo, Boolean> call(TableColumn<ProductVo, Boolean> param) {
				TableCell<ProductVo, Boolean> tableCell = new TableCell<ProductVo, Boolean>(){
				
				// checkbox 생성
				private CheckBox check = new CheckBox(); 
				// 초기화 블럭 시작
				{
					check.setAlignment(Pos.CENTER);
					
					check.setOnAction(event -> {
						int index = getTableRow().getIndex();
						// 테이블에 해당되는 객체 맵핑해서 멤버 변수 값을 조회
						ProductVo productVo = tableView.getItems().get(index);
						
						if(productVo != null) {
							productVo.setCheckYn(check.isSelected());
						}
						tableView.refresh();
						tableView.getSelectionModel().select(index);
						
						System.out.println("check 클릭... " + productVo.isCheckYn());
					});
				}
				// 초기화 블록 끝
				
				protected void updateItem(Boolean item, boolean empty) {
					super.updateItem(item, empty);
					
					if(item != null && !empty) {
						check.setSelected(item);
						this.setGraphic(check);
					} else {
						this.setGraphic(null);
					}
				};
				};
				return tableCell;
			}
		});
		
		tc6.setCellFactory(new Callback<TableColumn<ProductVo, String>, TableCell<ProductVo, String>>() {

			@Override
			public TableCell<ProductVo, String> call(TableColumn<ProductVo, String> param) {
				TableCell<ProductVo, String> tableCell = new TableCell<ProductVo, String>(){
					
					// 콤보 객체 생성
					private ComboBox<String> combo = new ComboBox<String>();
					
					// 초기화 블럭 시작
					{
						combo.setPrefWidth(100);
						combo.getItems().addAll("A","B","C");
						
						
						// combo이벤트 처리
						combo.setOnAction(event->{
							
							String value = combo.getValue();
							int index = getTableRow().getIndex();
							
							// 테이블에 해당되는 객체 맵핑해서 멤버변수 값을 조회
							ProductVo productVo = tableView.getItems().get(index);
							
							if (productVo!=null) {
								productVo.setProductCode(value);
							}
							
							tableView.refresh();
							tableView.getSelectionModel().select(index);
							
							System.out.println("combo 클릭...: "+ productVo.getProductCode());
						});
					}// 초기화 블록 끝
					
					@Override
					protected void updateItem(String item, boolean empty) {
						
						if (item!=null && !empty) {
							combo.setValue(item);
							this.setGraphic(combo);
						} 
					}
				};
				return tableCell;
			}
			
		});
		
		// 컬럼 Style - 정렬 설정
		tc1.setStyle("-fx-alignment:CENTER");
		tc2.setStyle("-fx-alignment:CENTER-LEFT");
		tc3.setStyle("-fx-alignment:CENTER-RIGHT");
		tc4.setStyle("-fx-alignment:CENTER; -fx-padding:5px");
		tc5.setStyle("-fx-alignment:CENTER");
		tc6.setStyle("-fx-alignment:CENTER; -fx-padding:2px");
		
		tc1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
		tc2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20));
		tc3.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20));
		tc4.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20));
		tc5.prefWidthProperty().bind(tableView.widthProperty().multiply(0.10));
		tc6.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
		
		tableView.setItems(list);
		
		// 테이블 레코드 단위 선택
		tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ProductVo>() {

			@Override
			public void changed(ObservableValue<? extends ProductVo> observable, ProductVo oldValue,
					ProductVo newValue) {
				String productNo = newValue.getProductNo();
				String productName = newValue.getProductName();
				
				int price = newValue.getPrice();
				
				txtArea.setText("품목 번호 : " + productNo + "\n" + "품목 명 : " + productName + "\n" + "단가 : " + price);
			}
		});
	}
}

