package mainpruebas;

import services.employees.Operaciones;
//import services.employees.OperacionesEmpleados;
import sessionmanager.SesionManager;

public class MainPruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Operaciones oper = new Operaciones();
		System.out.println(oper.incrementarSalario());
		SesionManager.cerrarSessionFactory();
		
	}

}
