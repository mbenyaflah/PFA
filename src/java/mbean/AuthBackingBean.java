/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mbean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author marwen
 */
@ManagedBean
@RequestScoped
public class AuthBackingBean {
   
  private static Logger log = Logger.getLogger(AuthBackingBean.class.getName());
   
  public String logout() {
    String result="/index?faces-redirect=true";
     
    FacesContext context = FacesContext.getCurrentInstance();
    HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
     
    try {
      request.logout();
    } catch (ServletException e) {
      log.log(Level.SEVERE, "Failed to logout user!", e);
      result = "/loginError?faces-redirect=true";
    }
     
    return result;
  }
}