/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.servlets;

import com.itesm.test.manager.PersonaManager;
import com.itesm.test.vo.PersonaVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dave
 */
@WebServlet(name = "MostrarPersonaServlet", urlPatterns = {"/persona/mostrar"})
public class MostrarPersonaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String personaId = request.getParameter("personaId");
        PersonaManager manager = new PersonaManager();
        PersonaVO persona = manager.consultar(personaId);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/persona/mostrar.jsp");
        request.setAttribute("persona", persona);
        
        rd.forward(request, response);
    }
}
