

/**
 * Implementación para operaciones en base octal
 */
public class CalculadoraOctal extends CalculadoraBase {
    
    public CalculadoraOctal() {
        super(8);
    }
    
    @Override
    public void suma() {
        int num1 = Integer.parseInt(numero1, 8);
        int num2 = Integer.parseInt(numero2, 8);
        resultado = Integer.toOctalString(num1 + num2);
    }
    
    @Override
    public void resta() {
        int num1 = Integer.parseInt(numero1, 8);
        int num2 = Integer.parseInt(numero2, 8);
        resultado = Integer.toOctalString(num1 - num2);
    }
    
    @Override
    public void multiplicacion() {
        int num1 = Integer.parseInt(numero1, 8);
        int num2 = Integer.parseInt(numero2, 8);
        resultado = Integer.toOctalString(num1 * num2);
    }
    
    @Override
    public void division() {
        int num1 = Integer.parseInt(numero1, 8);
        int num2 = Integer.parseInt(numero2, 8);
        if (num2 == 0) throw new ArithmeticException("División por cero");
        resultado = Integer.toOctalString(num1 / num2);
    }
}