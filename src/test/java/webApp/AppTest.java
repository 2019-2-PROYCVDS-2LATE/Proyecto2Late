package webApp;

import edu.eci.cvds.samples.entities.Recurso;
import edu.eci.cvds.samples.entities.RecursoTipo;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaException;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()  {
        try {
            ServiciosBiblioteca biblioteca = ServiciosBibliotecaFactory.getInstance().getServiciosBibliotecaTesting();
            Usuario usuario = new Usuario("yeison7f@gmail.com", "backend", "yeisson","12345");
            biblioteca.registrarUsuario(usuario);

            /*
            List<Usuario> usuarios = biblioteca.consultarUsuarios();
            System.out.println(usuarios.size());
            assertTrue(usuarios.size()>0);
            */

            Usuario usuario2 = biblioteca.consultarUsuario("yeison7f@gmail.com");
            System.out.println(usuario2.getArea()+usuario2.getCorreo()+"");
        }


        catch (ServiciosBibliotecaException e){
            System.out.println("Imposible usuario");
        }
    }
}
