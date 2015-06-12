package services.employees;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

import sessionmanager.SessionManager;

//import val.examples.hibernate.Region;
//import val.examples.hibernate.Transaction;

import clasesDAO.ContenedorDAO;
import clasesDAO.EmployeeDAO;
import clasesDTOAutogeneradas.Employees;


public class OperacionesEmpleados {
	private EmployeeDAO empleadoDAO = null;
	
	
	public OperacionesEmpleados ()
	{
		empleadoDAO = new EmployeeDAO();

	}
	
	/**
	 * Incrementar el salario a todos los empleados
	 * @return
	 */
	public boolean incrementarSalario()
	{
		boolean ok = false;
		
		List<Employees> listEmpDTO = null; // variable para almacenar la lista de Empleados
		ContenedorDAO.setSes(SessionManager.getSes()); // recupero la sesion de SessionFactory y lo seteo en el contenedor de clasesDAO
		
		listEmpDTO = empleadoDAO.readAll(); //cargo la lista recogida de la base de datos
		Iterator<Employees> it = listEmpDTO.iterator(); // creo iterador para recorrer la lista
		
		Transaction transaction = null;
		BigDecimal incremento = new BigDecimal (1.2);
		BigDecimal nuevoSalario = new BigDecimal (0);

		
		Employees empDTO;
		//*****************************************************************
		// ***************transaccion incrementar salario******************
		//*****************************************************************
		
		try {
			transaction = ContenedorDAO.getSes().beginTransaction();
		while (it.hasNext())
		{
			empDTO = it.next();
			nuevoSalario = incremento.multiply(empDTO.getSalary());
			// como está en PERSISTENT se modifica en la BD
			empDTO.setSalary(nuevoSalario);
			
		}
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
		SessionManager.cerrarSes(); // cierro la sesión
	}
		
		return ok;
	}
	
	//*****************************************************************
	// ***********************transaccion *****************************
	//*****************************************************************
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
