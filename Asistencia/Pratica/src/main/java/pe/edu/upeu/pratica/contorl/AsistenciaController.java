package pe.edu.upeu.pratica.contorl;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import org.springframework.stereotype.Controller;

@Controller
public class AsistenciaController {

    @FXML
    TextField txtNum1, txtNum2;
    @FXML
    Label txtResult;

    @FXML
    public void sumar() {
        double num1 = Double.parseDouble(txtNum1.getText());
        double num2 = Double.parseDouble(txtNum2.getText());
        double media = num1 + num2;
        txtResult.setText(String.valueOf(txtResult));


    }
}
