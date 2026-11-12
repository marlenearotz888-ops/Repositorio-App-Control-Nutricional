
package nutricionalappfx.dominio.pojo;

/**
 *
 * @author mar
 */
public class Colaborador {
    
    private int idColaborador;
    private String noPersonal;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaContratacion;;
    private String password;
    private int idRol;
    private String rol;
    private int idEstatus;
    private String estatus;

    public Colaborador() {
    }

    public Colaborador(int idColaborador, String noPersonal, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaContratacion, String password, int idRol, String rol, int idEstatus, String estatus) {
        this.idColaborador = idColaborador;
        this.noPersonal = noPersonal;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaContratacion = fechaContratacion;
        this.password = password;
        this.idRol = idRol;
        this.rol = rol;
        this.idEstatus = idEstatus;
        this.estatus = estatus;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public String getNoPersonal() {
        return noPersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public String getPassword() {
        return password;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getRol() {
        return rol;
    }

    public int getIdEstatus() {
        return idEstatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public void setNoPersonal(String noPersonal) {
        this.noPersonal = noPersonal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setIdEstatus(int idEstatus) {
        this.idEstatus = idEstatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno;
    }
    
}
