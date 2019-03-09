/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import model.entities.Contract;

/**
 *
 * @author chris
 */
public class ProcessContract {
    private Integer months;
    
    private PaymentService paymentService;

    public ProcessContract(Integer months, PaymentService paymentService) {
        this.months = months;
        this.paymentService = paymentService;
    }
    
    public double[] processContracts(double total, Contract contract){
        double[] installments = new double[months];
        
        for(int i = 1; i <= months; i++){
            installments[i-1] = paymentService.payment(i, contract.getTotalValue()/months);
        }
        
        return installments;
    }
}
