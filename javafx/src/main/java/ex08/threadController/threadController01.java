package ex08.threadController;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class threadController01 implements Initializable{
	@FXML private Label lblText;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	
	private boolean stop;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(e -> btnStartAction(e));
		btnStop.setOnAction(e -> btnStopAction(e));
	}
	
	public void btnStartAction(ActionEvent e) {
		System.out.println("start");
		stop = false;
		
		Thread th = new Thread() {
			@Override
			public void run() {
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
				while(!stop) {
					String strTime = sdf.format(new Date());
					System.out.println("현재 시간 : " + strTime);
					
					Platform.runLater(() ->{
						lblText.setText(strTime);
					});
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}; // Thread() 생성자
		th.setDaemon(true);
		th.start();
	}

	public void btnStopAction(ActionEvent e) {
		System.out.println("stop");
		stop = true;
	}
}
