package ex08.threadController;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class threadController04 implements Initializable {
	@FXML private Label lblResult;
	@FXML private Label lblResult02;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	@FXML private ProgressBar bar01;
	
	private TimeService timeService;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		btnStart.setOnAction(e->btnStartAction(e));
		btnStop.setOnAction(e->btnStopACtion(e));
		
		timeService = new TimeService();
		timeService.start();
	}

	public void btnStopACtion(ActionEvent e) {
		System.out.println("stop");
		
		timeService.cancel();
		
	}

	public void btnStartAction(ActionEvent e) {
		System.out.println("start");
		
		timeService.restart();
		lblResult.setText("");
			
		
	}// btnstartAction()
	

	// 내부클래스로 TimeService 작성
	class TimeService extends Service<Integer>{

		@Override
		protected Task<Integer> createTask() {
			
			Task<Integer> task = new Task<Integer>() {

				@Override
				protected Integer call() throws Exception {

					int sum = 0;
					// 수행해야 할 작업을 작성
					for(int i=0; i<=100; i++) {
						// 중단 플러그 체크
						if(isCancelled()) {
							updateMessage("진행중단");
							break;
						}
						
						// 누적처리
						sum +=  i;
						// 작업 수행중인 값을 task객체에 설정하여 UI에 
						// 연결하기 위한 메서드
						updateProgress(i, 100);
						updateMessage(String.valueOf(i));
						
						try {
							Thread.sleep(100);
						} catch (Exception e2) {
							if(isCancelled()) {
								updateMessage("진행중단");
								break;
							}
						}// try-catch
						
					}// for
					
					return sum;
				}// call()
			
			};//task()
			
			bar01.progressProperty().bind(task.progressProperty());
			lblResult.textProperty().bind(task.messageProperty());
			
			return task;
			
		}// creatTask(()

		// FX Application Thread에서 수행
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
	}// TimeService extend Service
}
