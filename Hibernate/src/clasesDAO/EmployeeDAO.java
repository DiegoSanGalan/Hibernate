package clasesDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import clasesDTOAutogeneradas.Employees;
import interfaces.InterfaceDAO;

public class EmployeeDAO  extends ContenedorDAO implements InterfaceDAO<Employees> {

	
	public EmployeeDAO()
	{
		
	System.out.println("Constructor EmployeeDAO");	
	
	}

	@Override
	/**
	 * Recibo un Empleado
	 */
	public boolean create(Employees c) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List <Employees> readAll() {
		//List <Employees> listEmp = new ArrayList<Employees>();
		//Session ses = ContenedorDAO.getSes();
		List<Employees> list = ContenedorDAO.getSes().createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 80").addEntity(Employees.class).list();
		return list;
	}
	
	
}
