

/**
 * Implementación para operaciones en base hexadecimal
 */
public class CalculadoraHexadecimal extends CalculadoraBase {
    
    public CalculadoraHexadecimal() {
        super(16);
    }
    
    @Override
    public void suma() {
        int num1 = Integer.parseInt(numero1, 16);
        int num2 = Integer.parseInt(numero2, 16);
        resultado = Integer.toHexString(num1 + num2).toUpperCase();
    }
    
    @Override
    public void resta() {
        int num1 = Integer.parseInt(numero1, 16);
        int num2 = Integer.parseInt(numero2, 16);
        resultado = Integer.toHexString(num1 - num2).toUpperCase();
    }
    
    @Override
    public void multiplicacion() {
        int num1 = Integer.parseInt(numero1, 16);
        int num2 = Integer.parseInt(numero2, 16);
        resultado = Integer.toHexString(num1 * num2).toUpperCase();
    }
    
    @Override
    public void division() {
        int num1 = Integer.parseInt(numero1, 16);
        int num2 = Integer.parseInt(numero2, 16);
        if (num2 == 0) throw new ArithmeticException("División por cero");
        resultado = Integer.toHexString(num1 / num2).toUpperCase();
    }
}