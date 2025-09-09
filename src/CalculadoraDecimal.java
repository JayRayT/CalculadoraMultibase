/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juanr
 */


/**
 * Implementación para operaciones en base decimal
 */
public class CalculadoraDecimal extends CalculadoraBase {
    
    public CalculadoraDecimal() {
        super(10);
    }
    
    @Override
    public void suma() {
        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        resultado = Integer.toString(num1 + num2);
    }
    
    @Override
    public void resta() {
        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        resultado = Integer.toString(num1 - num2);
    }
    
    @Override
    public void multiplicacion() {
        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        resultado = Integer.toString(num1 * num2);
    }
    
    @Override
    public void division() {
        int num1 = Integer.parseInt(numero1);
        int num2 = Integer.parseInt(numero2);
        if (num2 == 0) throw new ArithmeticException("División por cero");
        resultado = Integer.toString(num1 / num2);
    }
}