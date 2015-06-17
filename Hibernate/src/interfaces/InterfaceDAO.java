package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utilizaremos ésta interface para hacer cualquier clase que hagamos DAO
 * @author Diego Santamaría
 *
 */
public interface InterfaceDAO <Generico>{

	// Voy a utilizar generic para poder hacerlo funcionar con cualquier base de datos
	/**
	 * Método para crear un registro nuevo en la Base de Datos
	 * @param c Tipo ObjetoDTO
	 * @return booleano indicando true si se creó correctamente
	 */
	public Object create(Generico c);
	
	
	
	// utilizo tipo Object para que nos sirva con cualquiera
	/**
	 * Método para eliminar un registro de la Base de Datos
	 * @param claveId Tipo Object
	 * @return booleano indicando true si borró correctamente
	 * @throws SQLException 
	 */
	public boolean delete(Object claveId);
	
	
	
	
	/**
	 * Método para actualizar en la base de datos
	 * @param c Tipo ObjetoDTO
	 * @return booleano indicando true si se actualizó correctamente
	 */
	public boolean update(Generico c);
	
	
	
	
	/**
	 * Método para leer por ID
	 * @param claveId tipo Object
	 * @return tipo ObjetoDTO
	 */
	public Generico read(Object claveId);
	
	
	
	
	/**
	 * Método para recuperar todos los registros de la Base de Datos
	 * @return List del tipo Solicitado
	 */
	public List<Generico> readAll();
	
	
	
}
