
package nutricionalappfx.dominio.contrato;

import nutricionalappfx.dominio.pojo.Colaborador;
import nutricionalappfx.dominio.pojo.ColaboradorStatus;

/**
 *
 * @author mar
 */
public interface IAutenticacionRepocitorio {
    
    public int verificarCredenciales(String noPersonal, String password) throws RuntimeException;
    
    public ColaboradorStatus verificarEstatusColaborador(int idColaborador) throws RuntimeException;
    
    public Colaborador obtenerInformacionColaborador(int idColaborador) throws RuntimeException;
            
}
