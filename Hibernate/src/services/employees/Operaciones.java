package services.employees;
import interfaces.InterfaceDAO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import sessionmanager.SesionManager;
//import sessionmanager.SessionManager;

//import val.examples.hibernate.Region;
//import val.examples.hibernate.Transaction;

import clasesDAO.ContenedorDAO;
import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Employees;

/**
 * Segunda versión mejorada operaciones.
 * @author Diego Santamaria
 *@version Version 2.0
 */
public class Operaciones {
	private EmployeeDAO empleadoDAO = null; // atributo de la clase
	
	/**
	 * Constructor de la clase Operaciones para empleados
	 */
	public Operaciones ()
	{
		empleadoDAO = new EmployeeDAO();// Instancio el objeto empleadoDAO
		
		//InterfaceDAO<?> empleadoDAO = new EmployeeDAO();
		// podemos utilizar el InterfaceDAO para crear el empleadoDAO y hacerlo más 
		// genérico. De ésta manera no haría falta modificar nada mas que el tipo
		// de la clase EmployeeDAO. HACIENDOLO MAS FLEXIBLE. 
		// PARA QUE FUNCIONE TENDRIA QUE CREAR OTRO INTERFACE HIJO QUE CONTENGA TODOS LOS MÉTODOS
		// DEL EMPLEADODAO
		
		
	}
	
	/*public Employees recuperarPorId(Object id)
	{
		Employees empDTO = null;
		
		return empDTO;
	}*/
	
	/**
	 * Incrementar el salario a todos los empleados
	 * @return
	 */
	public boolean incrementarSalario()
	{
	boolean ok = false;
		
	List<Employees> listEmpDTO = null; // variable para almacenar la lista de Empleados
	empleadoDAO.setSes(SesionManager.obtenerSesionNueva()); // recupero la sesion de SessionFactory y lo seteo en el contenedor de clasesDAO
		
	listEmpDTO = empleadoDAO.readAll(); //cargo la lista recogida de la base de datos
		
	Transaction transaction = null;
		
	
		//*****************************************************************
		// ***************transaccion incrementar salario******************
		//*****************************************************************
		
	try {
		transaction = empleadoDAO.getSes().beginTransaction();
		actualizarSalario(listEmpDTO);
		transaction.commit();//si todo ha ido bien, persisto los cambio, los hago de verdad, no en la copia de la BD
		
		ok = true;
		}
	catch (Exception e)
		{
		e.printStackTrace();
		transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
	finally 
		{
		SesionManager.cerrarSession(empleadoDAO.getSes()); // cierro la sesion
		}
		
		return ok;
	}
	
	//*****************************************************************
	// ***********************transaccion *****************************
	//*****************************************************************
	
	/**
	 * Recorro la lista y actualizo el salario en 1.2
	 * @param listaEDTO
	 */
	private void actualizarSalario (List<Employees> listaEDTO)
	{
	
		for (Employees emp : listaEDTO)
		{
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("salario inicial" + emp.getSalary());
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");

			emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.2)));
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("salario aumentado" + emp.getSalary());
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			empleadoDAO.getSes().merge(emp);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
