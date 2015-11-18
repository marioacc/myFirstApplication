package com.itesm.test.servlets;

import com.itesm.test.manager.PersonaManager;
import com.itesm.test.vo.PersonaVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by mario on 11/9/2015.
 */
@WebServlet(name = "ActualizarFechaServlet", urlPatterns = {"/fecha/actualizar"})
public class ActualizarFechaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Date date = new Date();
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/persona/date.jsp");
        request.setAttribute("date", date);
        rd.forward(request, response);
    }
}