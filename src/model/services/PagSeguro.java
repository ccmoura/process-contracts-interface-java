
package model.services;

public class PagSeguro implements PaymentService {

    public double payment(int month, double value) {
        return value + value * 0.0319 * month/1.7;
    }
}