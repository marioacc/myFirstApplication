/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itesm.test.dao;

import com.itesm.test.vo.PersonaVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dave
 */
public class PersonaDAO {
    public List<PersonaVO> findAll(){
        List<PersonaVO> personas = new ArrayList<PersonaVO>(); 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, nombre, "
            + "apellido_paterno, apellido_materno, alias FROM persona " 
            + "ORDER BY id");    
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                PersonaVO persona = new PersonaVO();
                persona.setId(rs.getString(1));
                persona.setNombre(rs.getString(2));
                persona.setApellido_paterno(rs.getString(3));
                persona.setApellido_materno(rs.getString(4));
                persona.setAlias(rs.getString(5));
               
                personas.add(persona);
            }
            
            rs.close();
            pstmt.close();
            conn.close();
           
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
          catch(SQLException sqle){
              Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, sqle);
          }
        return personas;
    }
    
   public PersonaVO findById(String givenId){
        PersonaVO personasPorId = null; 
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("SELECT id, nombre, "
            + "apellido_paterno, apellido_materno, alias FROM persona "  
            + "WHERE id="+givenId);    
            ResultSet rs = pstmt.executeQuery();
            
            //if when we only wait for one
            if(rs.next()){
                personasPorId = new PersonaVO();
                personasPorId.setId(rs.getString(1));
                personasPorId.setNombre(rs.getString(2));
                personasPorId.setApellido_paterno(rs.getString(3));
                personasPorId.setApellido_materno(rs.getString(4));
                personasPorId.setAlias(rs.getString(5));
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
          catch(SQLException sqle){
              Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, sqle);
          }
        return personasPorId;
    }
   
   public void delete(final String givenId){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM persona WHERE id="+givenId);    
            pstmt.executeUpdate();
            
            pstmt.close();
            conn.close();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
          catch(SQLException sqle){
              Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, sqle);
          }
    }
   
   
   public void update(final PersonaVO persona){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            if(null != persona){
            
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("UPDATE persona " +
                     "SET nombre=?, apellido_paterno=?, apellido_materno=?, alias=? " + "WHERE id=?");  
            pstmt.setString(1, persona.getNombre());
            pstmt.setString(2, persona.getApellido_paterno());
            pstmt.setString(3, persona.getApellido_materno());
            pstmt.setString(4, persona.getAlias());
            pstmt.setString(5, persona.getId());
            
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
          }
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
          catch(SQLException sqle){
              Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, sqle);
          }
    }
   
   
   public PersonaVO insert(final String nombre, final String apellidoPaterno, final String apellidoMaterno, final String alias){
    PersonaVO persona = null;
       try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
  
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ejemplo?user=root&password=admin");
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO persona (nombre, apellido_paterno, apellido_materno,"
                    + "alias)" + "VALUES (?, ?, ?, ?)");  
            pstmt.setString(1, nombre);
            pstmt.setString(2, apellidoPaterno);
            pstmt.setString(3, apellidoMaterno);
            pstmt.setString(4, alias);
            
            pstmt.executeUpdate();
            pstmt.close();
            
            pstmt = conn.prepareStatement("SELECT_LAST_INSERT_ID()");
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                persona = new PersonaVO();
                persona.setId(rs.getString(1));
                persona.setNombre(nombre);
                persona.setApellido_paterno(apellidoPaterno);
                persona.setApellido_materno(apellidoMaterno);
                persona.setAlias(alias);
            }
            
           rs.close();
           pstmt.close();
           conn.close();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException cnfe) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, cnfe);
        }
          catch(SQLException sqle){
              Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, sqle);
          }
       return persona;
    }
}
