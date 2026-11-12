
package nutricionalappfx.dominio.pojo;

/**
 *
 * @author mar
 */
public class ColaboradorStatus {
    
    private int idEstatus;
    private String estatus;

    public ColaboradorStatus() {
    }

    public ColaboradorStatus(int idEstatus, String estatus) {
        this.idEstatus = idEstatus;
        this.estatus = estatus;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    
}
