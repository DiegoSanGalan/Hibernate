package clasesDAO;

import java.util.List;

import clasesDTOAutogeneradas.Departments;

import interfaces.InterfaceDAO;
import interfaces.InterfaceDepartmentsDAO;


/**
 * 
 * @author Diego Santamaría
 * Clase DepartmentsDAO para gestionar los métodos de acceso a la tabla Departments de la base de datos.
 * @see ContenedorDAO
 * @see InterfaceDepartmentsDAO
 *
 */
public class DepartmentsDAO extends ContenedorDAO implements InterfaceDepartmentsDAO{

	

	/**
	 * Método para borrar registros de la tabla Departments de la base de datos  por ID.
	 * @param claveId Tipo Object
	 * @return booleano devuelve true si el borrado es correcto.
	 */
	@Override
	public boolean delete(Object claveId) {
		// TODO Auto-generated method stub
		return false;
	}

		

	/**
	 * Método para leer todos los registros de la tabla Departments de la base de datos.
	 * @return List<Departments> Lista de todos los registros de la tabla Departments de la base de datos.
	 */ 
	@Override
	public List<Departments> readAll() {
		@SuppressWarnings("unchecked")
		List<Departments> list = getSes().createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list();
		return list;
	}

	
	/**
	 * Método para insertar un registro en la tabla Departments de la base de datos.
	 * @param c Tipo Departments. 
	 * @return Tipo Object el Objeto Insertado y null si ha fallado la inserción.
	 */
	@Override
	public Object create(Departments c) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Método para actualizar un registro en la tabla Departments de la base de datos.
	 * 
	 * @param c Tipo Departments.
	 * @return booleano a true si es correcta la actualización
	 */
	@Override
	public boolean update(Departments c) {
		// TODO Auto-generated method stub
		return false;
	}



	/**
	 * Método para leer un registro de la tabla Departments de la base de datos.
	 * @param claveId Tipo Object
	 */
	@Override
	public Departments read(Object claveId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
