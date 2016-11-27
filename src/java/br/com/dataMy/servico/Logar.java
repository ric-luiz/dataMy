package br.com.dataMy.servico;

import br.com.dataMy.beans.Usuario;
import br.com.dataMy.controller.UsuarioController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ric_l
 */
@WebServlet(name = "UsuarioController", urlPatterns = {"/logar"})
public class Logar extends HttpServlet {       
    UsuarioController uController = new UsuarioController();
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/index.jsp");        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Tenta recuperar o usuario passado pelos parametros
        Usuario user = new Usuario();
        user.setUsername(username);
        user.setPassword(password);
        user = uController.logar(user);                
        
        System.out.println("entrou logar");
        
        if(user != null){            
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/home.jsp");
        } else { //Caso não encontrou o usuario                        
            request.setAttribute("ErrorMenssage", "Usuario ou Senha Inválidos");
            request.getRequestDispatcher("/login.jsp").forward(request, response);            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
