package ex04;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class listenerBindingController implements Initializable{
	@FXML private TextArea txtArea01;
	@FXML private TextArea txtArea02;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(txtArea01.textProperty(), txtArea02.textProperty());
		
	}
}
