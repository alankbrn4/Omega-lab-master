package com.labclinico.omega.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.labclinico.omega.patients.*;
import com.labclinico.omega.patients.pacientesModel;
import com.labclinico.omega.patients.pacientesService;


import com.fasterxml.jackson.databind.ObjectMapper;

public class PatientServlet extends HttpServlet {
    private pacientesService service = new pacientesService(null);
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.getWriter().print(mapper.writeValueAsString(service.obtenerTodosLosPacientes()));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        pacientesModel model = mapper.readValue(req.getInputStream(), pacientesModel.class);
        service.agregarPaciente(model);
    }
    
}
