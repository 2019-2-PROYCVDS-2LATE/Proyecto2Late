package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.security.Sesion;
import edu.eci.cvds.security.Shiro;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import static com.google.inject.Guice.createInjector;

public class ServiciosBibliotecaFactory {

    private static ServiciosBibliotecaFactory instance = new ServiciosBibliotecaFactory();

    private static Injector injector;
	
    private static Injector testingInjector;

    private ServiciosBibliotecaFactory() {

        injector = createInjector(new XMLMyBatisModule() {

            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config.xml");
                //bind(SesionLogger.class).to(ShiroLogger.class);

            }
        }
        );

        testingInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                //bind(SesionLogger.class).to(ShiroLogger.class);
            }
        }
        );
		
    }

    public ServiciosBiblioEci getServiciosBiblioteca(){
        return injector.getInstance(ServiciosBiblioteca.class);
    }

    public ServiciosBiblioEci getServiciosBibliotecaTesting(){
        return testingInjector.getInstance(ServiciosBiblioteca.class);
    }


    public static ServiciosBibliotecaFactory getInstance(){
        return instance;
    }

}