package services.employees;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sessionmanager.SesionManager;

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
	private static Logger log = Logger.getLogger("mylog");
	
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
	
	
	/**
	 * Incrementar el salario a todos los empleados
	 * @return booleano a true si se ha incrementado el salario, false si da error
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
		log.info("Se ha incrementado el salario correctamente en la base de datos");
		ok = true;
		}
	catch (Exception e)
		{
		e.printStackTrace();
		log.warning("Error en la transacción de incrementar salario");
		transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
	finally 
		{
		SesionManager.cerrarSession(ses); // cierro la sesion
		}
	return ok;
	}
	//*****************************************************************
	//********************** Fin de la transaccion ********************
	//*****************************************************************
	
	
	
	
	
	/**
	 * Recorro la lista y actualizo el salario en 1.2
	 * @param listaEDTO Lista de los Empleados
	 */
	private void actualizarSalario (List<Employees> listaEDTO)
	{
		for (Employees emp : listaEDTO)
		{
			emp.setSalary(emp.getSalary().multiply(new BigDecimal(1.2)));
		}
	}
	
	
	/**
	 * Método para recuperar una lista con los empleados que más ganan de cada departamento
	 * @return List<Employees> Lista de los empleados que más ganan
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
			log.warning("Error en la transacción al leer todos los departamentos");
			transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
		finally
		{
			SesionManager.cerrarSession(ses); // cierro la sesion
		}
		return list;
	}

	
	/**
	 * Método privado para obtener el empleado que mas gana de cada departamento
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
	 * @return Lista con todos los departamentos
	 */
	private List<Departments> readAllDepartamentos() 
	{
		List<Departments> listD = departamentDAO.readAll();
		return listD;
	}
	
	
	/**
	 * Método para obtener una lista de los empleados de un departamento recibido por parámetro
	 * @param dpto Tipo Object
	 * @return Lista de empleados Tipo List
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
			log.info("Transacción correcta al obtener el listado de todos los empleados de un departamento");
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			log.warning("Error en la transacción al obtener el listado por departamentos");
			transaction.rollback();//si algo ha ido mal, deshago la transacción
		}
		finally
		{
			ses.close();
		}
		return listEmp2DTO;
	}
}
