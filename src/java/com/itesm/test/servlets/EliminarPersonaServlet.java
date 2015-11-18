/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.servlets;

import com.itesm.test.dao.PersonaDAO;
import com.itesm.test.manager.PersonaManager;
import com.itesm.test.vo.PersonaVO;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EliminarPersonaServlet", urlPatterns = {"/persona/eliminar"})
public class EliminarPersonaServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String personaId = request.getParameter("personaId");
       PersonaManager persona = new PersonaManager();
       persona.eliminar(personaId);
       
       response.sendRedirect("/persona/listar");
        }
    }