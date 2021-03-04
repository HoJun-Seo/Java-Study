package ex06;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class basicController implements Initializable{
	@FXML private TextField txtTitle;
	@FXML private PasswordField txtPassword;
	@FXML private ComboBox<String> comboPublic;
	@FXML private DatePicker dateExit;
	@FXML private TextArea txtContent;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void btnSendAction(ActionEvent e) {
		String title = txtTitle.getText();
		String pass = txtPassword.getText();
		String content = txtContent.getText();
		LocalDate localDate = dateExit.getValue();
		
		System.out.println("title : " + title);
		System.out.println("password : " + pass);
		System.out.println("content : " + content);
		if(localDate != null) {
			System.out.println("dateExit : " + localDate.toString());
		}
	}
	
	public void btnCancelAction(ActionEvent e) {
		txtTitle.setText("");
		txtPassword.getText();
		txtContent.setText("");
		comboPublic.setValue("");
	}
}
