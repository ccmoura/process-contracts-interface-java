/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

/**
 *
 * @author chris
 */
public class Paypal implements PaymentService {

    @Override
    public double payment(int month, double value) {
        double total = value + value * 0.01 * month;
        return total + total * 0.02;
    }
    
}
