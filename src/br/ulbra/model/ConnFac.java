/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author s.lucas
 */
public class ConnFac 
{
    private static final String DRIVER = "com.mysql.jdbc.Driver"; //driver de connexao
    private static final String URL = "jdbc:mysql://localhost:3308/bdpoo"; //onde conectar - mudar porta para 3306 dependendo da maquina
    private static final String USER = "root"; //usuario
    private static final String PASS = ""; //senha
    
    
    public static Connection getConnection() throws SQLException
    {
        try
        {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        }
        catch (ClassNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            return null;
        }
    }
    
    
    public static void closeConnection(Connection con)
    {
        try
        {
            if(con != null)
            {
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmp)
    {
        try
        {
            if(stmp != null)
            {
                stmp.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
    
    
    public static void closeConnection(Connection con, PreparedStatement stmp, ResultSet rs)
    {
        try
        {
            if(rs != null)
            {
                rs.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
