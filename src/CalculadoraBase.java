/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author juanr
 */


/**
 * Clase base abstracta que define la estructura común para todas las calculadoras
 * Implementa encapsulamiento y provee métodos para operaciones y conversiones
 */
public abstract class CalculadoraBase {
    // Atributos protegidos para encapsulamiento
    protected String numero1;
    protected String numero2;
    protected String resultado;
    protected int base;
    
    /**
     * Constructor de la clase base
     * @param base Base numérica inicial
     */
    public CalculadoraBase(int base) {
        this.base = base;
        this.numero1 = "";
        this.numero2 = "";
        this.resultado = "";
    }
    
    // ========== MÉTODOS ABSTRACTOS ==========
    public abstract void suma();
    public abstract void resta();
    public abstract void multiplicacion();
    public abstract void division();
    
    // ========== MÉTODO DE CONVERSIÓN ==========
    /**
     * Convierte un número entre diferentes bases numéricas
     */
    public String convertir(String numero, int baseOrigen, int baseDestino) {
        try {
            if (numero == null || numero.trim().isEmpty()) {
                return "Error: Número vacío";
            }
            
            // Convertir a decimal primero
            int decimal = Integer.parseInt(numero, baseOrigen);
            
            // Convertir a la base destino
            switch (baseDestino) {
                case 2: return Integer.toBinaryString(decimal);
                case 8: return Integer.toOctalString(decimal);
                case 10: return Integer.toString(decimal);
                case 16: return Integer.toHexString(decimal).toUpperCase();
                default: return "Error: Base no válida";
            }
        } catch (NumberFormatException e) {
            return "Error en conversión: " + e.getMessage();
        }
    }
    
    // ========== GETTERS Y SETTERS ==========
    public String getNumero1() { return numero1; }
    public void setNumero1(String numero1) { this.numero1 = numero1; }
    
    public String getNumero2() { return numero2; }
    public void setNumero2(String numero2) { this.numero2 = numero2; }
    
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
    
    public int getBase() { return base; }
    public void setBase(int base) { this.base = base; }
    
    /**
     * Obtiene el nombre de la base actual
     */
    public String getNombreBase() {
        switch (base) {
            case 2: return "Binario";
            case 8: return "Octal";
            case 10: return "Decimal";
            case 16: return "Hexadecimal";
            default: return "Desconocida";
        }
    }
}