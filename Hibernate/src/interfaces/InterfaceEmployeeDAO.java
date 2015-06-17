/**
 * 
 */
package interfaces;

import java.util.List;

import clasesDTOAutogeneradas.Employees;

/**
 * Interface específica de Empleados DAO que hereda de InterfaceDAO
 * @author Diego Santamaría
 * @see InterfaceDAO
 * 
 *
 */
public interface InterfaceEmployeeDAO extends InterfaceDAO<Employees> {

	
	/**
	 * Método para devolver un listado del departamento recibido por parámetro
	 * @param dpto tipo short (Object)
	 * @return Lista de Empleados
	 */
	public List<Employees>listadoPorDepartamento (Object dpto);
	
	
}
