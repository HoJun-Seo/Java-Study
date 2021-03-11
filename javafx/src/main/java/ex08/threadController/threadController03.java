package ex08.threadController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class threadController03 implements Initializable{
	@FXML private Label lblResult;
	@FXML private Label lblResult02;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	@FXML private ProgressBar bar01;
	
	// 작업 스레드 결과값이 없을 경우
	private Task<Integer> task;
	// 결과값이 있는 경우
	//private Task<Integer> task2; 

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(e -> btnStartAction());
		btnStop.setOnAction(e -> btnStopAction());
	}

	public void btnStopAction() {
		System.out.println("stop");
		task.cancel();
	}

	public void btnStartAction() {
		System.out.println("start");
		task = new Task<Integer>() {

			// call() : 작업 스레드(처리하고자 하는 내용을 작성)
			@Override
			protected Integer call() throws Exception {
				
				int sum = 0;
				
				// 수행해야 할 작업을 작성
				for(int i = 0; i < 100; i++) {
					System.out.println("task 객체 수행중 : " + i);
					if(isCancelled()) {
						updateMessage("진행 중단");
						break;
					}
					sum += i;
					
					updateProgress(i, 100);
					updateMessage(String.valueOf(i));
					
					try {
						Thread.sleep(100);
					}catch (Exception e) {
						updateMessage("진행 중단");
						break;
					}
				}
				return sum;
			}
			// javaFX Application 스레드에서 호출하는 메소드
			// UI 관련 컨트롤을 갱신할 수 있음
			@Override
			protected void succeeded() {
				lblResult02.setText(String.valueOf(getValue()));
			}
			
			@Override
			protected void cancelled() {
				lblResult02.setText("취소");
			}
			
			@Override
			protected void failed() {
				lblResult02.setText("실패");
			}
		}; // task() 객체 생성
		
		bar01.progressProperty().bind(task.progressProperty());
		lblResult.textProperty().bind(task.messageProperty());
		lblResult02.setText("");
		
		// 스레드 동작 (실행)
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}

}
