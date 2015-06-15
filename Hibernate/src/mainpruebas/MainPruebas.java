package mainpruebas;

import java.util.ArrayList;
import java.util.List;

import clasesDTOAutogeneradas.Employees;

import services.employees.Operaciones;
//import services.employees.OperacionesEmpleados;
import sessionmanager.SesionManager;

public class MainPruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <Employees> l = new ArrayList<Employees>();
		
		Operaciones oper = new Operaciones();
		//System.out.println(oper.incrementarSalario());
		//SesionManager.cerrarSessionFactory();
		
		
		
		
		//PARA PROBAR LISTAR EMPLEADOS QUE MAS GANAN
		
		l=oper.listarEmpleadosQueMasGanan();
		for (Employees empDTO : l)
		{
			System.out.println(empDTO.toString());
		}
		SesionManager.cerrarSessionFactory();
		//PARA PROBAR LISTAR EMPLEADOS QUE MAS GANAN
		
	}

}
