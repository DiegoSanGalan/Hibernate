package services.employees;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.junit.BeforeClass;
import org.junit.Test;

//import clasesDAO.ContenedorDAO;
import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Employees;

import sessionmanager.SesionManager;
//import sessionmanager.SessionManager;

public class TestOperacionesEmpleados {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
		
	}

	@Test
	public void testOperacionesEmpleados() {
		
		OperacionesEmpleados opE = new OperacionesEmpleados();
		assertNotNull("Objeto OperacionesEmpleados creado", opE);
	}

	@Test
	public void testIncrementarSalario() {
		OperacionesEmpleados oper = new OperacionesEmpleados(); // creo objeto OperacionesEmpleados
		
		Session ses = SesionManager.obtenerSesionNueva();
		
		EmployeeDAO empleadoDAO = new EmployeeDAO(); // creo objeto EmpleadoDAO
		
	
		
	
		empleadoDAO.setSes(ses); // obtengo la sesion
		List<Employees> listAntesSubida = empleadoDAO.readAll(); // recupero todos los empleados y los guardo en DTO
		System.out.println(oper.incrementarSalario()); //incremento el salario
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
