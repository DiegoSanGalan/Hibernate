/**
 * 
 */
package interfaces;

import java.util.List;

import clasesDTOAutogeneradas.Employees;

/**
 * @author Diego Santamaría
 *
 */
public interface InterfaceEmployeeDAO extends InterfaceDAO<Employees> {

	
	/**
	 * Método para devolver un listado del departamento recibido por parámetro
	 * @param dpto tipo short (Object)
	 * @return
	 */
	public List<Employees>listadoPorDepartamento (Object dpto);
	
	
}
