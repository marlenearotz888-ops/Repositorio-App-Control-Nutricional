package nutricionalappfx.dominio.pojo;

/**
 *
 * @author mar
 */
public class Autenticacion {
 
    private boolean credendialesCorrectas;
    private String mensaje;
    private boolean activo;
    private Colaborador colaborador;

    public Autenticacion() {
    }

    public Autenticacion(boolean credendialesCorrectas, String mensaje, boolean activo, Colaborador colaborador) {
        this.credendialesCorrectas = credendialesCorrectas;
        this.mensaje = mensaje;
        this.activo = activo;
        this.colaborador = colaborador;
    }

    public boolean isCredendialesCorrectas() {
        return credendialesCorrectas;
    }

    public String getMensaje() {
        return mensaje;
    }

    public boolean isActivo() {
        return activo;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setCredendialesCorrectas(boolean credendialesCorrectas) {
        this.credendialesCorrectas = credendialesCorrectas;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

}