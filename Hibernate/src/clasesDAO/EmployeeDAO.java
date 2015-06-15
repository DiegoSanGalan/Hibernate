package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import clasesDTOAutogeneradas.Employees;
import interfaces.InterfaceDAO;
import interfaces.InterfaceEmployeeDAO;

public class EmployeeDAO  extends ContenedorDAO implements InterfaceEmployeeDAO {

	
	public EmployeeDAO()
	{
		
	//System.out.println("Constructor EmployeeDAO");	
	
	}

	@Override
	/**
	 * Recibo un Empleado
	 */
	public Object create(Employees c) {
		boolean ok = false;
		
				
		return ok;
	}

	@Override
	public boolean delete(Object claveId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Employees c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Employees read(Object claveId) {
		
		Employees emp = new Employees();
		emp = (Employees) this.getSes().createSQLQuery("SELECT * FROM EMPLOYEES WHERE EMPLOYEES_ID = " + claveId).addEntity(Employees.class).uniqueResult();
		return emp;
	}

	@Override
	public List <Employees> readAll() {
		// podemos poner this.getSes() para obtener la conexión necesaria para ejecutar el 
		//.createSQLQuery. Es lo mismo que poner getSes() simplemente porque accedemos al método
		// del padre (ContenedorDAO)
		@SuppressWarnings("unchecked")
		List<Employees> list = getSes().createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();
		return list;
	}

	@Override
	public List<Employees> listadoPorDepartamento(Object dpto) {
		List<Employees> list = getSes().createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = " + dpto).addEntity(Employees.class).list();
		
		
		
		
		return list;
	}
	
	
}
