/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.persistencia.RecursoDAO;
import edu.eci.cvds.persistencia.UsuarioDAO;

import edu.eci.cvds.persistencia.mybatis.MyBATISUsuarioDAO;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.impl.ServiciosBiblioEciImpl;



/**
 *
 * @author 2152972
 */

public class GuiceContextListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                
                //Usuario
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                //recurso
                bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);

            }
        });
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}