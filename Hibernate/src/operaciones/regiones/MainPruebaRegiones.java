package operaciones.regiones;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import clasesDTOAutogeneradas.Countries;

public class MainPruebaRegiones {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ObtenerPaises obp = new ObtenerPaises();
		Set<Countries> paises = new HashSet<Countries>();
		
		paises = obp.paisesPorContinente();
		
		
	}

}
