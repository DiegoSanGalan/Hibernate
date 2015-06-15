package clasesDAO;

import java.util.List;

import clasesDTOAutogeneradas.Departments;
import clasesDTOAutogeneradas.Employees;

import interfaces.InterfaceDAO;

public class DepartmentsDAO extends ContenedorDAO implements InterfaceDAO{

	@Override
	public Object create(Object c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object claveId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Object c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object read(Object claveId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Departments> readAll() {
		@SuppressWarnings("unchecked")
		List<Departments> list = getSes().createSQLQuery("SELECT DEPARTMENT_ID, DEPARTMENT_NAME FROM DEPARTMENTS").addEntity(Departments.class).list();
		return list;
	}

	
}
