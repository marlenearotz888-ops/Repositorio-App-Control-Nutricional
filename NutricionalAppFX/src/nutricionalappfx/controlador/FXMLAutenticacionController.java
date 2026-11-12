
package nutricionalappfx.controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nutricionalappfx.NutricionalAppFX;
import nutricionalappfx.dominio.AutenticacionDM;
import nutricionalappfx.dominio.pojo.Autenticacion;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.modelo.dao.AutenticacionDAO;
import nutricionalappfx.utilidad.Utilidades;

/**
 * FXML Controller class
 *
 * @author mar
 */
public class FXMLAutenticacionController implements Initializable {

    @FXML
    private TextField tfNoPersonal;
    @FXML
    private Label lblUsuarioInvalido;
    @FXML
    private Label lblPasswordIncorrecto;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private PasswordField pfPassword;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private void validarCredenciales (String noPersonal, String password) {
        AutenticacionDM autenticacionDM = new AutenticacionDM (new AutenticacionDAO());
        try {
            Autenticacion respuesta = autenticacionDM.verificarCredencialesColaborador(noPersonal, password);
            if (respuesta.isCredendialesCorrectas() && respuesta.isActivo()) {
                Utilidades.mostrarAlertaSimple("Credenciales Correctas", respuesta.getMensaje(), Alert.AlertType.INFORMATION);
                irPantallaPrincipal(respuesta.getColaborador());
            } else {
                Utilidades.mostrarAlertaSimple("Lo sentimos", respuesta.getMensaje(), Alert.AlertType.WARNING);
            }
        } catch (RuntimeException ex) {
            Utilidades.mostrarAlertaSimple("Error", ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
    
    private boolean sonCamposValidos () {
        boolean esValido = true;
        lblUsuarioInvalido.setText("");
        lblPasswordIncorrecto.setText("");
        if (tfNoPersonal.getText().isEmpty()) {
            lblUsuarioInvalido.setText("El número de personal es obligatorio");
            esValido = false;
        }
        if (pfPassword.getText().isEmpty()) {
            lblPasswordIncorrecto.setText("La contraseña es obligatoria");
            esValido = false;
        }
        return esValido;
    }
    
    private void irPantallaPrincipal (Colaborador colabordador) {
        try {
            Stage escenario = (Stage) tfNoPersonal.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(NutricionalAppFX.class.getResource("vista/FXMLPrincipal.fxml"));
            Parent vista = loader.load();
            FXMLPrincipalController controlador = loader.getController();
            controlador.inicializarInformacion(colabordador);
            Scene escena = new Scene(vista);
            escenario.setScene(escena);
            escenario.setTitle("Control Nutricional");
            escenario.show();
        } catch (IOException ex) {
            
        }
    }

    @FXML
    private void ingresar(ActionEvent event) {
        String noPersonal = tfNoPersonal.getText();
        String password = pfPassword.getText();
        if (sonCamposValidos()) {
            validarCredenciales(noPersonal, password);
        }
    }
    
}
