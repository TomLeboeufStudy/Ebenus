/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.ebenus.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cours.ebenus.dao.entities.Utilisateur;
import com.cours.ebenus.factory.AbstractDaoFactory;
import com.cours.ebenus.service.IServiceFacade;
import com.cours.ebenus.service.ServiceFacade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author elhad
 */
// @WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final Log log = LogFactory.getLog(LoginServlet.class);

    private IServiceFacade serviceFacade = null;

    @Override
    public void init() throws ServletException {

        // étape 2 charger la facade !
        try {
            serviceFacade = new ServiceFacade(AbstractDaoFactory.FactoryDaoType.JDBC_DAO_FACTORY);
            List<Utilisateur> users = serviceFacade.getUtilisateurDao().findAllUtilisateurs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (null != request.getSession().getAttribute("user")) {
            response.sendRedirect(this.getServletContext().getContextPath() + "/CrudUserServlet");
        } else {
            this.getServletContext().getRequestDispatcher("/pages/login/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String[] listEmail = request.getParameterValues("email");
        String email = listEmail[0];
        String[] listPassw = request.getParameterValues("password");
        String password = listPassw[0];

        try {
            Utilisateur user = serviceFacade.getUtilisateurDao().authenticate(email, password);
            log.debug(user.toString());

            request.getSession().setAttribute("user", user);

            if (user.getIdUtilisateur() != null) {
                response.sendRedirect(this.getServletContext().getContextPath() + "/CrudUserServlet");
            }

        } catch (Exception e) {
            log.debug("prout");
            e.printStackTrace();
        }
        //response.sendRedirect(this.getServletContext().getContextPath() + "/CrudUserServlet");
    }

    /**
     * Méthode appelée lors de la fin de la Servlet
     */
    @Override
    public void destroy() {
    }

}
