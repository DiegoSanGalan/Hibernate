/**
 * 
 */
package services.employees;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sessionmanager.SesionManager;
import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Employees;

/**
 * @author alumno
 *
 */
public class TestOperaciones2 {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Test method for {@link services.employees.Operaciones#Operaciones()}.
	 */
	@Test
	public void testOperaciones() {
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link services.employees.Operaciones#incrementarSalario()}.
	 */
	@Test
	public void testIncrementarSalario() {
		int sizeLista = 0;
		Session ses = null;
		Session ses2 = null;
		Operaciones oper = new Operaciones(); // creo objeto OperacionesEmpleados
		EmployeeDAO empleadoDAO = new EmployeeDAO(); // creo objeto EmpleadoDAO
		EmployeeDAO emp = new EmployeeDAO();
		ses = SesionManager.obtenerSesionNueva(); // obtengo una nueva sesion
		empleadoDAO.setSes(ses); // seteo la sesion en empleadoDAO
		
			
		List<Employees> listAntesSubida = empleadoDAO.readAll(); // recupero todos los empleados y los guardo en DTO
		sizeLista = listAntesSubida.size(); // para recorrer la lista
		
		System.out.println("**************antes de subida++++++++++++++");
		System.out.println(listAntesSubida.get(0).getSalary());
		System.out.println("**************antes de subida++++++++++++++");
		
		oper.incrementarSalario();
		ses.close();
		
		ses2 = SesionManager.obtenerSesionNueva();
		emp.setSes(ses2);
		
		List<Employees> listDespuesSubida = emp.readAll(); // recupero los empleados después de subir sueldo
		
		for (int i = 0; i< sizeLista-1; i++)
		{
			System.out.println(listAntesSubida.get(i).getSalary());
			assertTrue("Salario no incrementado" , (listAntesSubida.get(i).getSalary().intValue()) < (listDespuesSubida.get(i).getSalary().intValue()));
		}
		ses2.close();
	}

	/**
	 * Test method for {@link services.employees.Operaciones#listarEmpleadosQueMasGanan()}.
	 */
	@Test
	public void testListarEmpleadosQueMasGanan() {
		
	}

	/**
	 * Test method for {@link services.employees.Operaciones#obtenerEmpleadosPorDepartamento(java.lang.Object)}.
	 */
	@Test
	public void testObtenerEmpleadosPorDepartamento() {
		
	}

	@AfterClass
	public static void CerrarSessionFactory()
	{
		SesionManager.cerrarSessionFactory();
	}
}
