package sessionmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Clase para la FactorySession
 * @author Diego Santamaría
 *
 */
public class SessionManager {
	
	//private static Session ses;
	private static Configuration configuration = new Configuration().configure();
	private static StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	private static SessionFactory MyFactory = configuration.buildSessionFactory(builder.build());
	private static Session ses = MyFactory.openSession();


/**
 * Constructor privado Singleton
 */
private SessionManager ()
{
	
}


/**
 * Metodo para obtener el sessionFactory
 * @return the ses
 */
public static Session getSes() {
	return ses;
}


/*
 * @param ses the ses to set
 *
public static void setSes(Session ses) {
	SessionManager.ses = ses;
}
*/



public static void cerrarSes()
{
	ses.close();
}

public static void cerrarSesionFactory()
{
	MyFactory.close();
}


}