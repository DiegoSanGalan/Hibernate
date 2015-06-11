package mainpruebas;

import services.employees.OperacionesEmpleados;
import sessionmanager.SessionManager;

public class MainPruebas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		OperacionesEmpleados oper = new OperacionesEmpleados();
		oper.incrementarSalario();
		SessionManager.cerrarSesionFactory();
		
	}

}
