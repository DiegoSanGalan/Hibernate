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
import clasesDAO.DepartmentsDAO;
import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Departments;
import clasesDTOAutogeneradas.Employees;

/**
 * Segunda versión mejorada operaciones.
 * @author Diego Santamaria
 *@version Version 2.0
 */
public class Operaciones {
	private EmployeeDAO empleadoDAO = null; // atributo de la clase EmployeeDAO
	private DepartmentsDAO departamentDAO = null; // atributo de la clase DepartmentsDAO
	
	/**
	 * Constructor de la clase Operaciones para empleados
	 */
	public Operaciones ()
	{
		empleadoDAO = new EmployeeDAO();// Instancio el objeto empleadoDAO
		departamentDAO = new DepartmentsDAO();
		
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
	Transaction transaction = null;	
	Session ses = null;
	ses = SesionManager.obtenerSesionNueva();
	List<Employees> listEmpDTO = new ArrayList<Employees>(); // variable para almacenar la lista de Empleados
	empleadoDAO.setSes(ses); // recupero la sesion de SessionFactory y lo seteo en el contenedor de clasesDAO
		
	
		
	
		
	
		//*****************************************************************
		// ***************transaccion incrementar salario******************
		//*****************************************************************
		
	try {
		transaction = empleadoDAO.getSes().beginTransaction();
		listEmpDTO = empleadoDAO.readAll(); //cargo la lista recogida de la base de datos
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
		SesionManager.cerrarSession(ses); // cierro la sesion
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
			/*System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("salario inicial" + emp.getSalary());
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			*/
			emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.2)));
			
			
			/*System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("salario aumentado" + emp.getSalary());
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			System.out.println("*****************************************************");
			*/
		}
	}
	
	
	/**
	 * Método para recuperar una lista con los empleados que más ganan de cada departamento
	 * @return List<Employees>
	 */
	public List<Employees> listarEmpleadosQueMasGanan ()
	{
		Transaction transaction = null;	
		Session ses = null;
		List<Employees> list = new ArrayList<Employees>(); // para almacenar la lista de empleados que mas ganan
							// de cada departamento.
		List<Departments> listDptos = new ArrayList<Departments>(); // para almacenar lista de departamentos
		
		try
		{
			ses = SesionManager.obtenerSesionNueva();
			empleadoDAO.setSes(ses);
			transaction = empleadoDAO.getSes().beginTransaction();
			listDptos = readAllDepartamentos(); //recuperar lista de departamentos
			for (Departments dpto : listDptos)//recorrer lista de departamentos recogida
			{
			// por cada departamento buscar el empleado que más gana y devolverlo
			// y meterlo en list
			list.add(obtenerElQueMasGana(dpto)); // por cada departamento
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
		finally
		{
			SesionManager.cerrarSession(ses); // cierro la sesion
		}
		
		
		return list;
	}

	/**
	 * Método para obtener el empleado que mas gana de cada departamento
	 * @param dpto tipo Departments
	 * @return EmpleadoDTO
	 */
	private Employees obtenerElQueMasGana(Departments dpto) {
		Employees empleadoDTOMasGana = null;
		BigDecimal mayor = new BigDecimal (0);
		List<Employees> l = new ArrayList<Employees>();
		l = empleadoDAO.listadoPorDepartamento(dpto); // obtener lista empleados por departamento
		for (Employees emp : l) // recorro la lista
		{
			// si el salario del empleado es mayor que el anterior lo guardo
			if (emp.getSalary().intValue() >  mayor.intValue())
			{
				mayor = emp.getSalary();
				empleadoDTOMasGana = emp;
			}
		}
		return empleadoDTOMasGana;
	}

	/**
	 * Método privado para obtener una lista de todos los departamentos
	 * @param listDptos
	 */
	private List<Departments> readAllDepartamentos() 
	{
		List<Departments> listD = departamentDAO.readAll();
		return listD;
	}
	
	
	/**
	 * Método para obtener una lista de los empleados de un departamento recibido por parámetro
	 * @param dpto
	 * @return Lista de empleados
	 */
	public List<Employees> obtenerEmpleadosPorDepartamento(Object dpto)
	{
		List <Employees> listEmp2DTO = new ArrayList<Employees>();
		Transaction transaction = null;	
		Session ses = null;
		try
		{
			ses = SesionManager.obtenerSesionNueva();
			empleadoDAO.setSes(ses);
			transaction = empleadoDAO.getSes().beginTransaction();
			listEmp2DTO = empleadoDAO.listadoPorDepartamento(dpto);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
		finally
		{
			ses.close();
		}
		return listEmp2DTO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
