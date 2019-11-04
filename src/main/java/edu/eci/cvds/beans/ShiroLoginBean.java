/**
 * Very simple bean that authenticates the user via Apache Shiro, using JSF
 * @author Daniel Mascarenhas
 */
package edu.eci.cvds.beans;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "loginBean")
@ViewScoped
public class ShiroLoginBean implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(ShiroLoginBean.class);

    private String email;
    private String password;
    private Boolean rememberMe;

    public Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * Try and authenticate the user
     */
    public void doLogin() {
        Subject currentUser  = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(getEmail(), new Sha256Hash(getPassword()).toHex(), getRememberMe());
        try {
            currentUser.login(token);
            currentUser.getSession().setAttribute("correo",email);
            FacesContext.getCurrentInstance().getExternalContext().redirect("admin/Home.xhtml");
        }
        catch (UnknownAccountException ex) {
            facesError("Unknown account");
            log.error(ex.getMessage(), ex);
        }
        catch (IncorrectCredentialsException ex) {
            facesError("Wrong password");
            log.error(ex.getMessage(), ex);
        }
        catch (LockedAccountException ex) {
            facesError("Locked account");
            log.error(ex.getMessage(), ex);
        }
        catch (AuthenticationException ex) {
            facesError("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);
        }
        catch (IOException ex){
            facesError("Unknown error: " + ex.getMessage());
            log.error(ex.getMessage(), ex);

        }
    }

    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage("Shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "error"));
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String senha) {
        this.password = senha;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean lembrar) {
        this.rememberMe = lembrar;
    }

}