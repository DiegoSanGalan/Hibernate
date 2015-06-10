package operaciones.regiones;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import clasesDTOAutogeneradas.Countries;
import clasesDTOAutogeneradas.Locations;
//import clasesDTOAutogeneradas.Employees;
import clasesDTOAutogeneradas.Regions;

public class ObtenerPaises {
	
	private static Session ses;
	private Configuration configuration = new Configuration().configure();
	private StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	private SessionFactory MyFactory = configuration.buildSessionFactory(builder.build());
	
	public ObtenerPaises()
	{
		
	}
	
	
	/**
	 * Prueba de como funciona el lazy = true (por defecto)
	 *  Imprime una lista de Continentes y por cada Continente muestra todos
	 *  los paises
	 * 
	 * @return Set<Countries> Un Set con los paises 
	 * pero no lo podemos usar porque almacenaría solo el último
	 */
	@SuppressWarnings("unchecked")
	public Set<Countries>paisesPorContinente()
	{
		Transaction transaction = null;
		Session ses = MyFactory.openSession();
		Set<Countries> paises = null;
		Set<Locations> localidades = null;
		
		try 
    	{
    		transaction = ses.beginTransaction();
    	
    		
    		// al hacer el método .createSQLQuery de la sesion el objeto se pone en
    		// PERSISTENT  por lo que las modificaciones que hagamos al objeto
    		// se harán directamente también en la base de datos.
			@SuppressWarnings("unchecked")
			List<Regions> list = ses.createSQLQuery("SELECT * FROM REGIONS").addEntity(Regions.class).list();
    		
    		Iterator<Regions> it = list.iterator(); 
    		Regions reg;
    		while (it.hasNext())
    		{
    			reg = it.next();
    			System.out.println(reg.getRegionName());
    			paises = reg.getCountrieses(); // obtengo la lista de paises tipo SET
    			for (Countries p: paises) // recorro la lista tipo SET 
    			{
    				System.out.println(p.toString()); //Muestro cada pais del Continente
    				
    				localidades = p.getLocationses(); // obtenemos el SET de Localidades
    				for (Locations l : localidades)// recoremos el SET de localidades
    				{
    					System.out.println(l.toString()); // muestro cada localidad de cada pais
    				}
    				
    			}
    			//Iterator<Countries> it2 = list.iterator();
    			//System.out.println(reg.getCountrieses().toString());
    		}
    		//transaction.commit();//si todo ha ido bien, persisto los cambio, los hago de verdad, no en la copia de la BD
    		
    	}
    	catch (Exception e)
    	{
    		e.printStackTrace();
    		transaction.rollback();//si algo ha ido mal, deshago la transacción
    	}
    	finally 
    	{
    		ses.close();//haya ido bien o mal, libero recursos!
    		MyFactory.close();
    	}
		return paises;
	}

}
