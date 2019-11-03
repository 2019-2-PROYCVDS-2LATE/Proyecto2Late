package edu.eci.cvds.samples.services;

import static com.google.inject.Guice.createInjector;

import com.google.inject.Injector;
import edu.eci.cvds.persistencia.RecursoDAO;
import edu.eci.cvds.persistencia.UsuarioDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.persistencia.mybatisimpl.MyBatisUsuarioDAO;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

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
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
            }
        }
        );

        testingInjector = createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setClassPathResource("mybatis-config-h2.xml");
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
            }
        }
        );
		
    }

    public ServiciosBiblioteca getServiciosBiblioteca(){
        return injector.getInstance(ServiciosBiblioteca.class);
    }

    public ServiciosBiblioteca getServiciosBibliotecaTesting(){
        return testingInjector.getInstance(ServiciosBiblioteca.class);
    }


    public static ServiciosBibliotecaFactory getInstance(){
        return instance;
    }

}