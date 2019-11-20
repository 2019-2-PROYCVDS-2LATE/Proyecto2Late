package webApp;

import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosBiblioteca;
import edu.eci.cvds.samples.services.ServiciosBibliotecaException;
import edu.eci.cvds.samples.services.ServiciosBibliotecaFactory;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
            Usuario usuario1 = biblioteca.consultarUsuario("yeison7f@gmail.com");
            //assertEquals(usuario1,usuario);
            System.out.println(usuario1.getNombre());
            System.out.println(usuario1.getCorreo());
            System.out.println(usuario1.getArea());
            System.out.println(usuario1.getContraseña());

            System.out.println(usuario.getNombre());
            System.out.println(usuario.getCorreo());
            System.out.println(usuario.getArea());
            System.out.println(usuario.getContraseña());
        }
        catch (ServiciosBibliotecaException e){
            System.out.println("Imposible usuario");
        }
    }
}
