package clasesDAO;

import org.hibernate.Session;

/**
 * Clase contenedor con los atributos comunes a todas las clases DAO
 * @author Diego Santamaría
 *
 */
public class ContenedorDAO {
	private Session ses;
	
	/**
	 * Constructor Básico de la clase, sin argumentos.
	 */
	public ContenedorDAO()
	{
		
	}
	
	
	/**
	 * Para obtener la sesión 
	 * @return Tipo Session ses
	 */
	public  Session getSes() {
		return ses;
	}

	/**
	 * Para hacer set de la sesión del factory
	 * @param session Tipo Session
	 */
	public void setSes(Session session) {
		ses = session;
	}

	
	
	
}
