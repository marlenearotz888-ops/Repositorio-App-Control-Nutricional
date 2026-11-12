package nutricionalappfx.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import nutricionalappfx.dominio.contrato.IAutenticacionRepocitorio;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorStatus;
import nutricionalappfx.modelo.ConexionBD;
import nutricionalappfx.utilidad.Utilidades;

/**
 *
 * @author mar
 */
public class AutenticacionDAO implements IAutenticacionRepocitorio{

    @Override
    public int verificarCredenciales(String noPersonal, String password) throws RuntimeException {
        String consulta = "select idColaborador from Colaboradores where noPersonal = ? and password = ?;";
        int idColaborador = 0;
        try (Connection conexion = ConexionBD.obtenerConecion(); 
             PreparedStatement ps = conexion.prepareStatement(consulta);) {
            ps.setString(1, noPersonal);
            Utilidades.generarCifradoSHA256(password);
            ps.setString(2, password);
            try (ResultSet resultado = ps.executeQuery()) {
                if (resultado.next()) {
                    idColaborador = resultado.getInt("idColaborador");
                }else {
                    idColaborador = -1;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
        return idColaborador;
        
    }

    @Override
    public ColaboradorStatus verificarEstatusColaborador(int idColaborador) throws RuntimeException {
        ColaboradorStatus estatus = new ColaboradorStatus();
        String consulta = "select idColaborador, c.idEstatus, e.estado from colaboradores c inner join colaboradores_estado e "
                        + "on e.id_Estado = c.idEstatus where idColaborador = ?;";
        try (Connection conexion = ConexionBD.obtenerConecion(); 
             PreparedStatement ps = conexion.prepareStatement(consulta);) {
            ps.setInt(1, idColaborador);
            try (ResultSet resultado = ps.executeQuery()) {
                if (resultado.next()) {
                    estatus.setIdEstatus(resultado.getInt("idEstatus")); 
                    estatus.setEstatus(resultado.getString("estado"));
                }else {
                    
                    throw new RuntimeException("Error en la integridad de los datos, inténtelo más tarde.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
        return estatus;
    }

    @Override
    public Colaborador obtenerInformacionColaborador(int idColaborador) throws RuntimeException {
        Colaborador colaborador = new Colaborador();
        String consulta = "select idColaborador, noPersonal, nombre, apellidoPaterno, apellidoMaterno, fechaContratacion, c.idRol, "
                + "Rol, idEstatus, estado from colaboradores c inner join roles r on r.idRol = c.idRol inner join "
                + "colaboradores_estado e on e.id_estado = c.idEstatus where idColaborador = ?;";
        try (Connection conexion = ConexionBD.obtenerConecion(); 
             PreparedStatement ps = conexion.prepareStatement(consulta);) {
            ps.setInt(1, idColaborador);
            try (ResultSet resultado = ps.executeQuery()) {
                if (resultado.next()) {
                    colaborador.setIdColaborador(resultado.getInt("idColaborador"));
                    colaborador.setNoPersonal(resultado.getString("noPersonal"));
                    colaborador.setNombre(resultado.getString("nombre"));
                    colaborador.setApellidoPaterno(resultado.getString("apellidoPaterno"));
                    colaborador.setApellidoMaterno(
                            (resultado.getString("apellidoPaterno") != null) ? resultado.getString("apellidoMaterno") : "");
                    colaborador.setFechaContratacion(resultado.getString("fechaContratacion"));
                    colaborador.setIdRol(resultado.getInt("idRol"));
                    colaborador.setRol(resultado.getString("rol"));
                    colaborador.setIdEstatus(resultado.getInt("idEstatus"));
                    colaborador.setEstatus(resultado.getString("estado"));
                }else {
                    throw new RuntimeException("Error en la integridad de los datos, inténtelo más tarde.");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error de conexión con el almacenamiento");
        }
        return colaborador;
    }
    
}
