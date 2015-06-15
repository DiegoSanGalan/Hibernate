/**
 * 
 */
package services.employees;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
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
		EmployeeDAO empleadoDAO = new EmployeeDAO(); // creo objeto EmpleadoDAO
		Operaciones oper = new Operaciones(); // creo objeto OperacionesEmpleados
		ses = SesionManager.obtenerSesionNueva(); // obtengo una nueva sesion
		empleadoDAO.setSes(ses); // seteo la sesion en empleadoDAO
		List<Employees> listAntesSubida = empleadoDAO.readAll(); // recupero todos los empleados y los guardo en DTO
		sizeLista = listAntesSubida.size(); // para recorrer la lista
		oper.incrementarSalario();
		
		ses.close();
		EmployeeDAO emp = new EmployeeDAO();
		ses = SesionManager.obtenerSesionNueva();
		emp.setSes(ses);
		
		List<Employees> listDespuesSubida = emp.readAll(); // recupero los empleados después de subir sueldo
		
		for (int i = 0; i< sizeLista-1; i++)
		{
			System.out.println("*******************************");
			System.out.println("SALARIO SIN MODIFICAR");
			System.out.println("*******************************");
			System.out.println(listAntesSubida.get(i).getSalary());
			
			System.out.println("*******************************");
			System.out.println("SALARIO MODIFICADO");
			System.out.println("*******************************");
			System.out.println(listDespuesSubida.get(i).getSalary());
			
			
			assertTrue("Salario no incrementado" , (listAntesSubida.get(i).getSalary().intValue()) < (listDespuesSubida.get(i).getSalary().intValue()));
			
			//assertFalse("Salario actual es igual que el salario anterior", listAntesSubida.get(i).getSalary().equals(listDespuesSubida.get(i).getSalary())) ;
			
			
			
			
		}
		
		ses.close();
		SesionManager.cerrarSessionFactory();
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

}
