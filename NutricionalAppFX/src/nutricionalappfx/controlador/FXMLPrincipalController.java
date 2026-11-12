
package nutricionalappfx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nutricionalappfx.dominio.pojo.Colaborador;

/**
 * FXML Controller class
 *
 * @author mar
 */
public class FXMLPrincipalController implements Initializable {
    
    private Colaborador colaborador;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblRol;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    public void inicializarInformacion (Colaborador colaborador) {
        this.colaborador = colaborador;
        mostrarPantalla();
    }
    
    public void mostrarPantalla () {
        if (colaborador != null) {
            lblNombre.setText("Bienvenido(a) " + colaborador.toString());
            lblRol.setText("Rol: " + colaborador.getRol());
        }
    }
}
