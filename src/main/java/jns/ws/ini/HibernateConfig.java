package jns.ws.ini;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	private static SessionFactory sf;

	public static void configure(){
		Configuration cfg = new Configuration();

		sf = cfg.configure("\\..\\..\\hibernate.cfg.xml").buildSessionFactory();
	}

	public static SessionFactory getSf() {
		return sf;
	}
	
	public static Session getSession(){		
		return sf.openSession();
	}
}
