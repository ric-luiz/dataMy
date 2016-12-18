package br.com.dataMy.servico;

import br.com.dataMy.beans.CartaoCredito;
import br.com.dataMy.pojo.Usuario;
import br.com.dataMy.beans.CompraCredito;
import br.com.dataMy.controller.CartaoCreditoController;
import br.com.dataMy.controller.CompraCreditoController;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ric_l
 */
@WebServlet(name = "ComprarCredito", urlPatterns = {"/comprarcredito"})
public class ComprarCredito extends HttpServlet {
    private CartaoCreditoController cartaoController = new CartaoCreditoController();
    private CompraCreditoController compraController = new CompraCreditoController();
    
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
        response.sendRedirect("/home.jsp");
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
            
            Usuario user = (Usuario)request.getSession().getAttribute("user");
            CartaoCredito cartao;
            CompraCredito compra;            
            
            ArrayList<CartaoCredito> cartoes = cartaoController.recuperarCartoes(user);            
            if(cartoes != null && cartoes.size() > 0){ //caso o usuario ja tenha um cartao cadastrado
                cartao = cartoes.get(0);
            } else { //caso seja preciso criar um novo cartao
                cartao = new CartaoCredito();                
                cartao.setNumeroCartao(request.getParameter("numeroCartao"));
                cartao.setUserId(user.getId());
                cartaoController.inserirCartao(cartao);
            }                        
            
            //definimos a nova compra
            compra = new CompraCredito();            
            compra.setValorComprado(Integer.parseInt(request.getParameter("credito")));
            compra.setUsuarioId(user.getId());            
            compraController.inserirCompra(compra);
            
            //redireciona para a pagina principal
            request.setAttribute("compraRealizada", "Compra realizada, por favor cheque o seu email");
            request.getRequestDispatcher("/home.jsp").forward(request, response);
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
