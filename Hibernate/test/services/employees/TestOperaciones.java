package services.employees;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

import sessionmanager.SesionManager;
import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Employees;

public class TestOperaciones {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testOperaciones() {
		
	}

	@Test
	public void testIncrementarSalario() {
		OperacionesEmpleados oper = new OperacionesEmpleados(); // creo objeto OperacionesEmpleados
		EmployeeDAO empleadoDAO = new EmployeeDAO(); // creo objeto EmpleadoDAO
		
		Session ses = SesionManager.obtenerSesionNueva();
		
		
	
		empleadoDAO.setSes(ses); // obtengo la sesion
		//List<Employees> listAntesSubida = empleadoDAO.readAll(); // recupero todos los empleados y los guardo en DTO
		assertTrue(oper.incrementarSalario()); //incremento el salario
		
		
		
		
		
		
		
		
		//empleadoDAO.setSes(SesionManager.obtenerSesionNueva());
		
		/*
		List<Employees> listDespuesSubida = empleadoDAO.readAll(); // recupero los empleados después de subir sueldo
		for (int i = 0; i<listDespuesSubida.size()-1; i++)
		{
			assertFalse("Salario actual mayor que el salario anterior", listAntesSubida.get(i).getSalary().equals(listDespuesSubida.get(i).getSalary())) ;
		}
		
		*/
		//essionManager.cerrarSesionFactory();
	}

}
