package ex08.threadController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class threadController02 implements Initializable{
	@FXML private Label lblResult;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	@FXML private ProgressBar bar01;
	
	// 작업 스레드 결과값이 없을 경우
	private Task<Void> task; 
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
		task = new Task<Void>() {

			@Override
			protected Void call() throws Exception {
				
				// 수행해야 할 작업을 작성
				for(int i = 0; i < 100; i++) {
					System.out.println("task 객체 수행중 : " + i);
					if(isCancelled()) {
						break;
					}
					updateProgress(i, 100);
					updateMessage(String.valueOf(i));
					
					try {
						Thread.sleep(100);
					}catch (Exception e) {
					}
				}
				return null;
			}
		}; // task() 객체 생성
		
		bar01.progressProperty().bind(task.progressProperty());
		lblResult.textProperty().bind(task.messageProperty());
		
		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}

}
