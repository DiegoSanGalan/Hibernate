/**
 * 
 */
package interfaces;

import java.util.List;

import clasesDTOAutogeneradas.Employees;

/**
 * @author Diego Santamar�a
 *
 */
public interface InterfaceEmployeeDAO extends InterfaceDAO<Employees> {

	
	/**
	 * M�todo para devolver un listado del departamento recibido por par�metro
	 * @param dpto tipo short (Object)
	 * @return
	 */
	public List<Employees>listadoPorDepartamento (Object dpto);
	
	
}
