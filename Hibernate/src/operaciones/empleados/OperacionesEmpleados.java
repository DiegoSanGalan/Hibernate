package operaciones.empleados;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;

//import val.examples.hibernate.Region;
//import val.examples.hibernate.Transaction;

import clasesDTOAutogeneradas.Employees;


public class OperacionesEmpleados {

	private static Session ses;
	private Configuration configuration = new Configuration().configure();
	private StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	private SessionFactory MyFactory = configuration.buildSessionFactory(builder.build());
	//private List<Employees> list = new ArrayList<Employees>();
	
	public OperacionesEmpleados ()
	{
		

	}
	
	/**
	 * Método al que le pasas un porcentaje de incremento por ejemplo 1.2 y suma el 20%
	 * al salario de los empleados del departamento recibido por parámetro
	 * @param porcentaje Tipo BigDecimal 
	 * @param departamento Tipo short
	 * @return booleano indicando si ha sido todo correcto
	 */
	public boolean subirSueldo (BigDecimal porcentaje, short departamento)
	{
		boolean sueldoAumentado = false;
		ses = obtenerSesion(); // inicio y obtengo Sesión
		if (iniciarTransaccion(porcentaje, departamento))// inicio transacción
			{
			//System.out.println("Transacción Correcta");
			sueldoAumentado = true; 
			}
		//finalizarTransaccion(); // finalizo transacción
		//desconectarSesion(); // desconecto sesión
		
		MyFactory.close(); // cierro factory
	
		return sueldoAumentado;
	}

	/**
	 * Método privado para desconectar la sesión
	 */
	private void desconectarSesion() {

		ses.disconnect();
	}

	/**
	 * Método privado para finalizar la transacción
	 */
	private void finalizarTransaccion() {

		
	}

/**
 * Método privado que recibe el valor Incrementado y el numero de departamento. 
 * Aumenta el salario de los empleados del departamento dado en %
 * @param valorIncrementado Tipo BigDecimal
 * @param depto Tipo short
 * @return booleano a true si es correcta la transacción
 */
	private boolean iniciarTransaccion(BigDecimal valorIncrementado, short depto) {
		
		boolean transaccionCorrecta = false;
		Transaction transaction = null;
		BigDecimal subirsueldo = new BigDecimal (0);
		
    	try 
    	{
    		transaction = ses.beginTransaction();
    		@SuppressWarnings("unchecked")
    		
    		// al hacer el método .createSQLQuery de la sesion el objeto se pone en
    		// PERSISTENT  por lo que las modificaciones que hagamos al objeto
    		// se harán directamente también en la base de datos.
			List<Employees> list = ses.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = " + depto).addEntity(Employees.class).list();
    		
    		Iterator<Employees> it = list.iterator(); 
    		Employees emp;
    		while (it.hasNext())
    		{
    			emp = it.next();
    			
    			subirsueldo = valorIncrementado.multiply(emp.getSalary());
    			// como está en PERSISTENT se modifica en la BD
    			emp.setSalary(subirsueldo);
    			//ses.merge(emp); // NO HACE FALTA PORQUE ESTAMOS EN PERSISTENT
    						// Y SE MODIFICA DIRECTAMENTA EN LA BASE DE DATOS.
    			
    		}
    		transaction.commit();//si todo ha ido bien, persisto los cambio, los hago de verdad, no en la copia de la BD
    		transaccionCorrecta = true;
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		transaction.rollback();//si algo ha ido mal, deshago la transacción
    	}
    	finally 
    	{
    		desconectarSesion();//haya ido bien o mal, libero recursos!
    		//MyFactory.close();
    	}
		return transaccionCorrecta;
	}

/**
 * Método privado para obtener la sesión
 * @return
 */
	private Session obtenerSesion() {

		Session ses = MyFactory.openSession(); 

		return ses;
		
	}
		
	
	public Employees obtenerEmpleado (short id)
	{
		Employees emp = new Employees ();
		
		
		return emp;
	}
	
	
}
