package operaciones.empleados;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import clasesDTOAutogeneradas.Employees;

public class MainPruebaOperaciones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short dep = 80;
		BigDecimal x = new BigDecimal(1.20);
		OperacionesEmpleados operE = new OperacionesEmpleados();
		
		if (operE.subirSueldo(x,dep))
		{
			System.out.println("Operacion realizada correctamente");
		}
		//empleados.toString();
		
	}

}
