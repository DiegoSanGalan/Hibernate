package sessionmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SesionManager {
	
	static {
		
		Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	sesion_factory = configuration.buildSessionFactory(builder.build());
		
	}
	
	private static SessionFactory sesion_factory;
	
	/**
	 * Constructor privado Clase SesionManager
	 */
	private SesionManager (){}
	
	
	/**
	 * Obtener el SessionFactory. static DE MOMENTO NO USADO
	 * @return Objeto sesion_factory
	 */
	public static SessionFactory getSessionFactory ()
	{
		return sesion_factory;
	}
	
	/**
	 * Obtener nueva sesión. static
	 * @return Objeto Session
	 */
	public static Session obtenerSesionNueva ()
	{
		return sesion_factory.openSession();
	}
	
	
	/**
	 * Método para cerar la sesion
	 * @param sesion Recibe la sesión que queremos cerrar
	 */
	public static void cerrarSession (Session sesion)
	{
		sesion.close();
	}
	
	
	/**
	 * Para finalizar todo. Cierra la sesion_factory
	 */
	public static void cerrarSessionFactory()
	{
		sesion_factory.close();
	}

}
