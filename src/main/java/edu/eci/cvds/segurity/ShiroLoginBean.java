import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

import java.io.IOException;
import java.io.Serializable;


@SuppressWarnings("deprecation")
@ManagedBean(name="InicioBean")
@ViewScoped
public class ShiroLoginBean implements Serializable {

    private String userName;
    private String correo;
    private String contrasena;
    private boolean rememberMe;

    public String getCorreo() {
            return correo;
    }
   
    public void setCorreo(String correo) {
            this.correo = correo;
    }
    
    public String getConstrasena() {
            return contrasena;
    }
   
    public void setConstrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getUserName() {
            return userName;
    }
   
    public void setUserName(String userName) {
            this.userName = userName;
    }

    public boolean getRememberMe() {
            return rememberMe;
    }

    public void setRememberMe(boolean rme) {
            rememberMe = rme;
    }
    
    /**
     * Try and authenticate the user
     */
    public void loginUser() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, new Sha256Hash(contrasena).toHex(), rememberMe);


            currentUser.login(token);
            currentUser.getSession().setAttribute("Correo",userName);

            FacesContext.getCurrentInstance().getExternalContext().redirect("faces/home.xhtml");
        } catch (UnknownAccountException e) {
                FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "Este usuario no se encuentra en nuestra base de datos"));
        } catch (IncorrectCredentialsException e) {
                FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Contraseña incorrecta", "La contraseña ingresada no es correcta"));
        } catch (IOException e) {
                FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fallo en servidor", "Error"));
        }
    }
}
