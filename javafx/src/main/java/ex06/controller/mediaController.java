package ex06.controller;

import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class mediaController implements Initializable {
	@FXML private ImageView imageView;
	@FXML private MediaView mediaView;
	@FXML private Button btnPlay;
	@FXML private Button btnPause;
	@FXML private Button btnStop;
	@FXML private ProgressBar progressBar;
	@FXML private ProgressIndicator progressBarIndicator;
	@FXML private Label labelTime;
	@FXML private Slider sliderVolumn;

	// 동영상, 오디오 재생이 끝인지 판별 하는 flag
	private boolean endOfMedia;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		try {
			
			// 미디어 재생
			Media media = new Media(getClass().getResource("/ex06/media/video.mp4").toString());
			
			// 미디어 플레이 생성 및 미디어 뷰에 설정
			MediaPlayer mediaPlayer = new MediaPlayer(media);
			mediaView.setMediaPlayer(mediaPlayer);
			
			// 준비상태 이면 실행
			mediaPlayer.setOnReady(new Runnable() {
				
				@Override
				public void run() {
					btnPlay.setDisable(false); // setDisable() : 비활성 상태
					btnPause.setDisable(true);
					btnStop.setDisable(true);
					
					mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {

						@Override
						public void changed(ObservableValue<? extends Duration> observable, Duration oldValue,
								Duration newValue) {
							
							double progress = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds();
							progressBar.setProgress(progress);
							progressBarIndicator.setProgress(progress);
							
							labelTime.setText(
									(int)mediaPlayer.getCurrentTime().toSeconds()+"/"+
									(int)mediaPlayer.getTotalDuration().toSeconds()+"sec"
									);
						}
					});
				}
			});
			
			// 실행 상태
			mediaPlayer.setOnPlaying(() ->{
				btnPlay.setDisable(true); // setDisable() : 비활성화 상태
				btnPause.setDisable(false);
				btnStop.setDisable(false);
			});
			
			// 일시정지 상태
			mediaPlayer.setOnPaused(() -> {
				btnPlay.setDisable(false); // setDisable() : 비활성화 상태
				btnPause.setDisable(true);
				btnStop.setDisable(false);
			});
			
			 // 종료 상태
			mediaPlayer.setOnEndOfMedia(() -> {
				endOfMedia = true;
				progressBar.setProgress(1.0);
				progressBarIndicator.setProgress(1.0);
				
				btnPlay.setDisable(false);
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			});
			
			mediaPlayer.setOnStopped(() -> {
				mediaPlayer.seek(mediaPlayer.getStartTime());
				btnPlay.setDisable(false); // setDisable() : 비활성 상태
				btnPause.setDisable(true);
				btnStop.setDisable(true);
			});
			
			sliderVolumn.setValue(50);
			sliderVolumn.valueProperty().addListener(new ChangeListener<Number>() {

				@Override
				public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
					mediaPlayer.setVolume(sliderVolumn.getValue());
				}
			});
			
			btnPlay.setOnAction(event -> {
				if(endOfMedia) {
					mediaPlayer.stop();
					mediaPlayer.seek(mediaPlayer.getStartTime());
				}
				System.out.println("play");
				mediaPlayer.play();
				endOfMedia = false;
			});
			
			btnPause.setOnAction(event -> {
				System.out.println("pause");
				mediaPlayer.pause();
			});
			btnStop.setOnAction(event -> {
				System.out.println("stop");
				mediaPlayer.stop();
			});
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

/*
 * Unknown -> ready -> playing -> paused, stopped, endofmedia
 * READY : setOnReady(Runnable r) - currentTime 속성삼, 재생 시간을 표시하는 리스너 등록, 재생 버튼 활성화
 * PLAYING : setOnPlaying(Runnable r) - 재생 및 정지 버튼 활성화
 * PAUSEED : setOnPaused(Runnable r) - 재생 및 정지 버튼 활성화
 * STOPPED : setOnStopped(Runnable r) - 재생 버튼 활성화
 * EndOfMedia : setOnEndOfMedia(Runnable r) - 재생 버튼 활성화
 */
