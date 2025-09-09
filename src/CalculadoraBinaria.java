

/**
 * Implementación para operaciones en base binaria
 */
public class CalculadoraBinaria extends CalculadoraBase {
    
    public CalculadoraBinaria() {
        super(2);
    }
    
    @Override
    public void suma() {
        int num1 = Integer.parseInt(numero1, 2);
        int num2 = Integer.parseInt(numero2, 2);
        resultado = Integer.toBinaryString(num1 + num2);
    }
    
    @Override
    public void resta() {
        int num1 = Integer.parseInt(numero1, 2);
        int num2 = Integer.parseInt(numero2, 2);
        resultado = Integer.toBinaryString(num1 - num2);
    }
    
    @Override
    public void multiplicacion() {
        int num1 = Integer.parseInt(numero1, 2);
        int num2 = Integer.parseInt(numero2, 2);
        resultado = Integer.toBinaryString(num1 * num2);
    }
    
    @Override
    public void division() {
        int num1 = Integer.parseInt(numero1, 2);
        int num2 = Integer.parseInt(numero2, 2);
        if (num2 == 0) throw new ArithmeticException("División por cero");
        resultado = Integer.toBinaryString(num1 / num2);
    }
}