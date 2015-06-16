package services.employees;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import sessionmanager.SesionManager;

import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Employees;

public class TestOperacionesEmpleados {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testOperaciones() {
		
	}

	@Test
	public void testIncrementarSalario() {
		Session ses = null;
		Employees emp1DTO = new Employees();
		Employees emp2DTO = new Employees();
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		Operaciones oper = new Operaciones();
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		emp1DTO = empleadoDAO.read(100);
		System.out.println("*******************************************");
		System.out.println("*******************************************");
		System.out.println(emp1DTO.getSalary());
		System.out.println("*******************************************");
		System.out.println("*******************************************");

		oper.incrementarSalario(); //ejecuto la operacion incrementar salario
		
		ses.close(); // cierro la sesion
		
		ses = SesionManager.obtenerSesionNueva(); // creo nueva sesion
		empleadoDAO.setSes(ses);
		emp2DTO = empleadoDAO.read(100);
		System.out.println("*******************************************");
		System.out.println("*******************************************");

		System.out.println(emp2DTO.getSalary());
		System.out.println("*******************************************");
		System.out.println("*******************************************");

		assertTrue("Sueldo no incrementado", emp1DTO.getSalary().intValue()< emp2DTO.getSalary().intValue());
		
		ses.close();
		//SesionManager.cerrarSessionFactory();
	}

	@Test
	public void testListarEmpleadosQueMasGanan() {
		Session ses = null;
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		Operaciones oper = new Operaciones();
		List<Employees> listMasGanan = new ArrayList<Employees>();
		
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		
		listMasGanan = oper.listarEmpleadosQueMasGanan();
		
		// compruebo que la lista se llena de algo
		// haré otra prueba para listar y comprobar que sólo hay un empleado
		// en cada departamento
		assertNotNull("Error. La lista está vacía", listMasGanan );
		
		ses.close();
		
	}

	/**
	 * Prueba de test en la que Ejecuto el método obtenerEmpleadosPorDepartamento
	 * Enviando el Departamento 80.
	 * Luego recorro todos los empleados de la lista comprobando que pertenecen a ése dpto.
	 */
	@Test
	public void testObtenerEmpleadosPorDepartamento() {
		Session ses = null;
		EmployeeDAO empleadoDAO = new EmployeeDAO();
		Operaciones oper = new Operaciones();
		List<Employees> listPorDpto = new ArrayList<Employees>();
		
		
		ses = SesionManager.obtenerSesionNueva();
		empleadoDAO.setSes(ses);
		
		//ejecuto el método de Operaciones enviando el dpto 80
		listPorDpto = oper.obtenerEmpleadosPorDepartamento(80);
		
		for (Employees emp : listPorDpto)
		{
			assertTrue("Error. No ha obtenido el departamento solicitado. 80", emp.getDepartments().getDepartmentId()==80);	
		}
		ses.close();
		
	}
	
	@AfterClass
	public static void CerrarSesionFactory()
	{
		SesionManager.cerrarSessionFactory();
	}
	

}
