package ex06;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MainView3 extends Application {
	@Override
	public void start(Stage primaryStage) {
		/** 루트노드 객체생성 */
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(10));

		/** TableView 객체생성 및 TableView에 컬럼 등록 */
		TableView<ProductVo> tableView = new TableView<ProductVo>();
		root.setCenter(tableView);

		/** TableColumn 컬럼정보 객체생성 및 TableView에 컬럼 등록 */
		TableColumn<ProductVo, String> tc1
			= new TableColumn<ProductVo, String>("품목번호");
		TableColumn<ProductVo, String> tc2
			= new TableColumn<ProductVo, String>("품목명");
		TableColumn<ProductVo, Integer> tc3
			= new TableColumn<ProductVo, Integer>("단가");
		TableColumn<ProductVo, Boolean> tc4
			= new TableColumn<ProductVo, Boolean>("버튼");
		TableColumn<ProductVo, Boolean> tc5
			= new TableColumn<ProductVo, Boolean>("선택");
		TableColumn<ProductVo, String> tc6
			= new TableColumn<ProductVo, String>("콤보");
		tableView.getColumns().setAll(tc1, tc2, tc3 ,tc4, tc5, tc6);

		/** TableColumn ↔ 데이터(ProductVo) 속성 매핑 */
		tc1.setCellValueFactory(
			new PropertyValueFactory<ProductVo, String>("productNo"));
		tc2.setCellValueFactory(
			new PropertyValueFactory<ProductVo, String>("productName"));
		tc3.setCellValueFactory(
			new PropertyValueFactory<ProductVo, Integer>("price"));
		tc4.setCellValueFactory(
			new PropertyValueFactory<ProductVo, Boolean>("checkYn"));
		tc5.setCellValueFactory(
			new PropertyValueFactory<ProductVo, Boolean>("checkYn"));
		tc6.setCellValueFactory(
			new PropertyValueFactory<ProductVo, String>("productCode"));


		/** tc4 테이블 내부 TableCell에 Button 컨트롤을 넣기 위한 작업 */
		tc4.setCellFactory( new Callback<TableColumn<ProductVo,Boolean> , TableCell<ProductVo,Boolean>>() {
			@Override
			public TableCell<ProductVo, Boolean> call(
								  TableColumn<ProductVo, Boolean> param) {
				/** TableCell 타입 객체생성
			   		TableCell<S,T> tableCell = new TableCell<S,T>(){ };
               		- S: 데이터(ProductVo) 타입
						- T: 데이터 checkYn 항목 타입
                                                                             ‣ checkYn의 값이 true일 때만 버튼 보이도록 지정
				*/
				TableCell<ProductVo, Boolean> tableCell
									  = new TableCell<ProductVo, Boolean>(){
					/** 【1】 Button 컨트롤 객체생성 */
					private Button btn = new Button("버튼1");
					{
						/** 【2】 Button 기본설정 */
						btn.setStyle("-fx-font-size:12px; -fx-padding:0");
						btn.setMaxHeight(20);
						btn.setMinHeight(20);
						btn.setPrefSize(100, 20);

						/** 【3】 Button 클릭 이벤트 함수 정의 */
						btn.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {

								/** 해당 테이블의 행인덱스와 데이터 조회 */
								int index = getTableRow().getIndex();
								ProductVo productVo2
									= tableView.getItems().get(index);

								/** 【4】 컨트롤 값 → 데이터 항목 설정 */
								productVo2.setProductCode("B");

								/** tableView 변경반영 및 행 선택 */
								tableView.refresh();
								tableView.getSelectionModel().select(index);
							}
						});
					}
					/** 【5】 데이터 → 컨트롤 설정을 위해 updateItme() 재정의 */
					@Override
					protected void updateItem(Boolean item, boolean empty) {
						/** 【6】 데이터 값 → 컨트롤 값 반영 및 Button 객체 TableCell 추가 */
						if(item!=null && item==true && !empty){
							/** TableCell에 Button 추가 */
							this.setGraphic(btn);
						}else{
							this.setGraphic(null);
						}
					}
				};
				return tableCell;
			}
		});

		/** tc5 테이블 내부 TableCell에 CheckBox 컨트롤을 넣기 위한 작업 */
		tc5.setCellFactory(new Callback<TableColumn<ProductVo,Boolean>
									, TableCell<ProductVo,Boolean>>() {
			@Override
			public TableCell<ProductVo, Boolean> call(
								  TableColumn<ProductVo, Boolean> param) {
				/** TableCell 타입 객체생성
			   		TableCell<S,T> tableCell = new TableCell<S,T>(){ };
               		- S: 데이터(ProductVo) 타입
						- T: 데이터 checkYn 항목 타입
                      ‣ checkYn의 값이 true일 때만 체크표시 되도록 지정
				*/
				TableCell<ProductVo, Boolean> tableCell
									  = new TableCell<ProductVo, Boolean>(){
					/** 【1】 CheckBox 컨트롤 객체생성 */
					private CheckBox check = new CheckBox();
					{
						/** 【2】 CheckBox 기본설정 */
						check.setAlignment(Pos.CENTER);

						/** 【3】 CheckBox 클릭 이벤트 함수 정의 */
						check.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {

								/** 해당 테이블의 행 인덱스와 데이터 조회 */
								int index = getTableRow().getIndex();
								ProductVo productVo
									= tableView.getItems().get(index);

								/** 【4】 컨트롤 값 → 데이터 항목 설정 */
								if(productVo!=null){
									productVo.setCheckYn(check.isSelected());
								}

								/** tableView 변경반영 및 행 선택 */
								tableView.refresh();
								tableView.getSelectionModel().select(index);

							}
						});
						check.setCenterShape(true);
					}

					/** 【5】 데이터 → 컨트롤 설정을 위해 updateItme() 재정의 */
					@Override
					protected void updateItem(Boolean item, boolean empty) {

						/** 【6】 데이터 값 → 컨트롤 값 반영 및 CheckBox 객체 TableCell 추가 */
						if(item!=null && !empty){
							check.setSelected(item);
							this.setGraphic(check);
						}else{
							this.setGraphic(null);
						}
					}
				};
				return tableCell;
			}
		});

		/** tc6 테이블 내부 TableCell에 CombokBox 컨트롤을 넣기 위한 작업 */
		tc6.setCellFactory(new Callback<TableColumn<ProductVo,String>
									, TableCell<ProductVo,String>>() {
			@Override
			public TableCell<ProductVo, String> call(
									 TableColumn<ProductVo, String> param) {
				/** TableCell 타입 객체생성
			   		TableCell<S,T> tableCell = new TableCell<S,T>(){ };
               		- S: 데이터(ProductVo) 타입
						- T: 데이터 checkYn 항목 타입
                      ‣ productCode의 값에 의해 콤보박스의 값을 설정
				*/
				TableCell<ProductVo, String> tableCell
										 = new TableCell<ProductVo, String>(){
					/** 【1】 ComboBox 컨트롤 객체생성 */
					private ComboBox<String> combo = new ComboBox<String>();
					{
						/** 【2】 ComboBox 기본설정 */
						combo.setPrefWidth(100);
						combo.getItems().addAll("A","B","C");

						/** 【3】 ComboBox 클릭 이벤트 함수 정의 */
						combo.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {

								/** 해당 테이블의 행인덱스와 데이터 조회 */
								String value = combo.getValue();
								int index = getTableRow().getIndex();
								ProductVo productVo
									= tableView.getItems().get(index);

								/** 【4】 컨트롤 값 → 데이터 항목 설정 */
								if(productVo!=null){
									productVo.setProductCode(value);
								}

								/** tableView 변경반영 및 행 선택 */
								tableView.refresh();
								tableView.getSelectionModel().select(index);
							}
						});
					}

					/** 【5】 데이터 → 컨트롤 설정을 위해 updateItme() 재정의 */
					@Override
					protected void updateItem(String item, boolean empty) {
						/** 【6】 데이터 값 → 컨트롤 값 반영 및 CheckBox 객체 TableCell 추가 */
						if(item!=null && !empty){
							combo.setValue(item);
							this.setGraphic(combo);
						}
					}
				};
				return tableCell;
			}
		});

		/** 컬럼 Style – 정렬 설정 */
		tc1.setStyle("-fx-alignment:CENTER");
		tc2.setStyle("-fx-alignment:CENTER-LEFT");
		tc3.setStyle("-fx-alignment:CENTER-RIGHT");
		tc4.setStyle("-fx-alignment:CENTER;-fx-padding:5px;");
		tc5.setStyle("-fx-alignment:CENTER;");
		tc6.setStyle("-fx-padding:2px; -fx-alignment:CENTER");

		/** 컬럼 너비 조정 15%, 20%, 20%, 20%, 10%, 15% */
		tc1.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));
		tc2.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20));
		tc3.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20));
		tc4.prefWidthProperty().bind(tableView.widthProperty().multiply(0.20));
		tc5.prefWidthProperty().bind(tableView.widthProperty().multiply(0.10));
		tc6.prefWidthProperty().bind(tableView.widthProperty().multiply(0.15));

		/** TableView 메인자료 등록 */
		ProductVo v1 = new ProductVo("a001","아메리카노",4000, true, "A");
		ProductVo v2 = new ProductVo("a002","까페라떼",4300, false, "B");
		ProductVo v3 = new ProductVo("a003","까페모카",4500, true, "C");
		ObservableList<ProductVo> list = FXCollections.observableArrayList(v1,v2,v3);
		tableView.setItems(list);

		/** 테이블 자료선택 변경이벤트 */
		tableView.getSelectionModel().selectedItemProperty().addListener(
										   new ChangeListener<ProductVo>() {
			@Override
			public void changed(
							ObservableValue<? extends ProductVo> observable
							, ProductVo oldValue, ProductVo newValue) {
				/** 신규 선택된 자료의 정보 콘솔화면 출력 */
				String productNo = newValue.getProductNo();
				String productName = newValue.getProductName();
				int price = newValue.getPrice();
			  System.out.println(productNo + "\t" + productName + "\t" + price);
			}
		});

		/** Scene, Stage 기본처리 */
		Scene scene = new Scene(root, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}