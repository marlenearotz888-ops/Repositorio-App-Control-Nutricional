
package nutricionalappfx.dominio;

import nutricionalappfx.dominio.contrato.IAutenticacionRepocitorio;
import nutricionalappfx.dominio.pojo.Autenticacion;
import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorStatus;
import nutricionalappfx.utilidad.Utilidades;

/**
 *
 * @author mar
 */
public class AutenticacionDM {
    
    private final IAutenticacionRepocitorio contrato;
    private final int CREDENCIALES_INCORRECTAS = -1;
    private final int ESTATUS_COLABORADOR_ACTIVO = 1;
    private final int ESTATUS_COLABORADOR_SUSPENDIDO = 3;
    
    public AutenticacionDM(IAutenticacionRepocitorio contrato) {
        this.contrato = contrato;
    }
    
    public Autenticacion verificarCredencialesColaborador(String noPersonal, String password) throws RuntimeException {
        
        Autenticacion respuesta = new Autenticacion();
        if (noPersonal.isEmpty() || password.isEmpty()) {
            respuesta.setCredendialesCorrectas(false);
            respuesta.setMensaje("Los campos no cumplen el formato solicitado");
            return respuesta;
        }
        
        String passwordCifrada = Utilidades.generarCifradoSHA256(password);
        int idColaborador = contrato.verificarCredenciales(noPersonal, passwordCifrada);
        if (idColaborador == CREDENCIALES_INCORRECTAS) {
            respuesta.setCredendialesCorrectas(false);
            respuesta.setMensaje("No. de personal y/o contraseña incorrecto. Favor de verificar la información.");
            return respuesta;
        }
        
        ColaboradorStatus estatus = contrato.verificarEstatusColaborador(idColaborador);
        if (estatus.getIdEstatus() == ESTATUS_COLABORADOR_ACTIVO) {
            respuesta.setCredendialesCorrectas(true);
            respuesta.setActivo(true);
            Colaborador info = contrato.obtenerInformacionColaborador(idColaborador);
            respuesta.setColaborador(info);
            respuesta.setMensaje("Bienvenido(a) " + info.getNombre() + " a tu sistema de gestión de pacientes.");
            return respuesta;
        }
        
        respuesta.setCredendialesCorrectas(true);
        respuesta.setActivo(false);
        if (estatus.getIdEstatus() == ESTATUS_COLABORADOR_SUSPENDIDO) {
            respuesta.setMensaje("Lo sentimos, tu cuenta ha sido suspendida indefinidamente. Contacta a un administrador al correo "
                               + "suporte@nutriapp.com");
        } else {
            respuesta.setMensaje("No. de personal y/o contraseña incorrecto. Favor de verificar la información.");
        }
        
        return respuesta;
    }
    
}
