/**
 * 
 */
package clasesDAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.Is;
import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sessionmanager.SesionManager;

import clasesDTOAutogeneradas.Employees;

/**
 * Clase de test para la clase EmployeeDAO
 * @author Diego Santamaría
 *
 */
public class TestEmployeeDAO {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for {@link clasesDAO.EmployeeDAO#read(java.lang.Object)}.
	 */
	@Test
	public void testRead() {
		Session ses = null;
		Employees empDTO = new Employees(); // para almacenar resultado
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		
		empDTO = empleadoDAO.read(100);
		
		assertNotNull("Error. No se ha leido de la base de datos", empDTO.getFirstName().equals(null));
		//System.out.println(empDTO.getFirstName());
		
		
		
		ses.close();
		//SesionManager.cerrarSessionFactory();
	}

	/**
	 * Ejecuto el método readAll() y luego compruebo que 
	 * cada elemento de la lista no está vacío.
	 * Test method for {@link clasesDAO.EmployeeDAO#readAll()}.
	 */
	@Test
	public void testReadAll() {
		Session ses = null;
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		List<Employees> listDTO = new ArrayList<Employees>();
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		
		listDTO = empleadoDAO.readAll();
		for (Employees empDTO : listDTO)
		{
			assertNotNull("Error. No hay ningún dato leido", empDTO);
		}
		
		
		ses.close();
		//SesionManager.cerrarSessionFactory();

	}

	/**
	 * Recojo en una lista los empleados del departamento 80 y
	 * recorro la lista comprobando que todos los empleados pertenecen
	 * a ése departamento
	 * Test method for {@link clasesDAO.EmployeeDAO#listadoPorDepartamento(java.lang.Object)}.
	 */
	@Test
	public void testListadoPorDepartamento() {
		Session ses = null;
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		List<Employees> listEmpDTO = new ArrayList<Employees>();
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		
		listEmpDTO = empleadoDAO.listadoPorDepartamento(80);
		for (Employees empDTO : listEmpDTO)
		{
			assertTrue("Error. Empleado no pertenece al dpto 80", empDTO.getDepartments().getDepartmentId()==80);
		}
		
		ses.close();
		
		
		
	}

	/**
	 * Test method for {@link clasesDAO.ContenedorDAO#getSes()}.
	 */
	@Test
	public void testGetSes() {
		Session ses = null;
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		
		assertNotNull("Error. Conexión no obtenida", empleadoDAO.getSes());
		
		ses.close();
	}

	/**
	 * Test method for {@link clasesDAO.ContenedorDAO#setSes(org.hibernate.Session)}.
	 */
	@Test
	public void testSetSes() {
		Session ses = null;
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		
		assertNotNull("Error. Conexión no obtenida", empleadoDAO.getSes());
		
		ses.close();
		
	}

	
	@AfterClass
	public static void cerrarServicios()
	{
		
		SesionManager.cerrarSessionFactory();
	}
}
