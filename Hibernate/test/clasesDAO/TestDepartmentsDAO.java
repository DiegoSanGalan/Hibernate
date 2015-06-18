/**
 * 
 */
package clasesDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sessionmanager.SesionManager;

import clasesDTOAutogeneradas.Departments;

/**
 * @author Diego Santamaría Galán
 * Clase de test para la clase DepartmentsDAO
 */
public class TestDepartmentsDAO {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test ejecuto el método obtener todos los departamentos y verifico
	 * que la lista que devuelve contiene los departamentos
	 * Test method for {@link clasesDAO.DepartmentsDAO#readAll()}.
	 */
	@Test
	public void testReadAll() {
		Session ses = null;
		DepartmentsDAO depDAO = new DepartmentsDAO();
		List<Departments> list = new ArrayList<Departments>();
		ses = SesionManager.obtenerSesionNueva();
		depDAO.setSes(ses);
		list = depDAO.readAll();
		for (Departments dep : list)
		{
			assertNotNull("Lista de departamentos vacia", dep);
		}
		ses.close();
		
		
	}

	/**
	 * Probado en el test de EmployeeDAO
	 * Test method for {@link clasesDAO.ContenedorDAO#getSes()}.
	 */
	@Test
	public void testGetSes() {
		
	}

	/**
	 * Probado en el test de EmployeeDAO
	 * Test method for {@link clasesDAO.ContenedorDAO#setSes(org.hibernate.Session)}.
	 */
	@Test
	public void testSetSes() {
	
	}

	@AfterClass
	public static void cerrarServicios()
	{
		SesionManager.cerrarSessionFactory();
	}
	
}
