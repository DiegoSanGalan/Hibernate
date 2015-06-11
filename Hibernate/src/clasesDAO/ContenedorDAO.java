package clasesDAO;

import org.hibernate.Session;

/**
 * Clase contenedor con los atributos comunes a todas las clases DAO
 * @author Diego Santamaría
 *
 */
public class ContenedorDAO {
	private static Session ses;
	
	public ContenedorDAO()
	{
		
	}
	
	
	/**
	 * Para obtener la sesion 
	 * @return the ses
	 */
	public static Session getSes() {
		return ses;
	}

	/**
	 * Para hacer set de la sesion del factory
	 * @param ses the ses to set
	 */
	public static void setSes(Session ses) {
		
		ContenedorDAO.ses = ses;
	}

	
	
	
}
