/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.profemariostomas.classicmodels;

import cl.profemariostomas.classicmodels.controllers.ProductLinesController;
import cl.profemariostomas.classicmodels.models.ProductLinesModel;

/**
 *
 * @author luk0s
 */
public class ClassicModels {

    public static void main(String[] args) {
        System.out.println("Creando nuevo producLines");
        ProductLinesModel plm = new ProductLinesModel(
            "StarShips", 
            "Great when you don't want to walk to the moon", 
            "<p>Great when you <strong>don't want</strong> to walk to the moon</p>", 
            ""
        );
        
        System.out.println("Guardando a BD");
        ControllerResponse response = ProductLinesController.insert(plm);
        
        System.out.println(response.getMessage());
        if (response.getStatus()) {
            System.out.println("=D");
        } else {
            System.out.println("=(");
        }
    }
}
