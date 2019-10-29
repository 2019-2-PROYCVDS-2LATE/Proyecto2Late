
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webApp;

import java.io.IOException;
import java.io.Writer;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    urlPatterns = "/helloServlet"
)

/**
 *
 * @author yeison
 */
public class server extends HttpServlet{
    static final long serialVersionUID = 35L;
    
    @override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        Writer responseWriter = resp.getWriter();
        Optional<String> optName = Optional.ofNullable(req.getParameter("name"));
        String name = optName.isPresent() && !optName.get().isEmpty() ? optName.get() : "";

        resp.setStatus(HttpServletResponse.SC_OK);
        responseWriter.write("Hello" + name + "!");
        responseWriter.flush();
        
    }
    
}
