/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.profemariostomas.classicmodels.controllers;

import cl.profemariostomas.classicmodels.ControllerResponse;
import cl.profemariostomas.classicmodels.MySQLConnection;
import cl.profemariostomas.classicmodels.models.ProductLinesModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author luk0s
 */
public class ProductLinesController {

    public static ControllerResponse insert(ProductLinesModel plm) {
        String SQL_INSERT = "INSERT INTO `productlines` (`productLine`, `textDescription`, `htmlDescription`, `image`) values (?, ?, ?, null);";
        
        try (Connection conn = MySQLConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT)) {
            
            pstmt.setString(1, plm.getProductLine());
            pstmt.setString(2, plm.getTextDescription());
            pstmt.setString(3, plm.getHtmlDescription());
            
            int rowCount = pstmt.executeUpdate();
            
            if (rowCount > 0) {
                return new ControllerResponse(true, "ProductLine: " + plm.getProductLine() + " saved!");
            }
            return new ControllerResponse(false, "wat ¿?");
        } catch (SQLException e) {
            return new ControllerResponse(false, "Error when saving: " + e.getMessage());
        }
    }
}
