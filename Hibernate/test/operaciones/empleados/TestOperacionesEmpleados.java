package operaciones.empleados;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Test;

import clasesDTOAutogeneradas.Employees;

public class TestOperacionesEmpleados {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Test
	public void testOperacionesEmpleados() {
		// constructor
	}

	@Test
	/**
	 * Probar si al incrementar el sueldo se incrementa realmente
	 * para ello cogemos un empleado de la base de datos, ejecutamos subirSueldo, volvemos
	 * a coger el mismo empleado y comparamos los sueldos.
	 */
	public void testSubirSueldo() {
		Employees emp1 = new Employees();
		
		short dep = 80;
		boolean ok = false;
		BigDecimal x = new BigDecimal(1.20);
		OperacionesEmpleados operE = new OperacionesEmpleados();
		ok = operE.subirSueldo(x,dep);
		
		assertTrue("Actualizados los empleados ok", ok) ;
		
		
	}

}
