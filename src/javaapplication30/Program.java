/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication30;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.entities.Contract;
import model.entities.Installment;
import model.services.PagSeguro;
import model.services.Paypal;
import model.services.ProcessContract;

/**
 *
 * @author chris
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        sc.nextLine();
        Date date = sdf.parse(sc.nextLine());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        System.out.print("Contract value: ");
        double value = sc.nextDouble();
        System.out.print("Enter number of installments: ");
        int months = sc.nextInt();
        ProcessContract processContract = new ProcessContract(months, new PagSeguro());
        Contract contract = new Contract(number, date, value);
        double[] installments = processContract.processContracts(value, contract);
        
        for(int i=0; i<installments.length; i++){
            cal.add(Calendar.MONTH, 1);
            contract.addList(new Installment(cal.getTime(), installments[i]));
        }
        System.out.println("Installments: ");
        for(Installment i : contract.getList()){
            System.out.println(i);
        }
        sc.close();
    }
    
}
