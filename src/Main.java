

import java.util.Scanner;

/**
 * Clase principal con el flujo secuencial solicitado
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== CALCULADORA MULTIBASE ===");
        
        boolean otraBase = true;
        
        while (otraBase) {
            // 1. Pedir al usuario la base que desea usar
            CalculadoraBase calculadora = seleccionarBase();
            
            if (calculadora != null) {
                boolean otraOperacion = true;
                
                while (otraOperacion) {
                    try {
                        // 2. Pedir tipo de operación
                        int operacion = seleccionarOperacion();
                        
                        // 3. Pedir los dos números
                        pedirNumeros(calculadora);
                        
                        // 4. Realizar la operación y mostrar resultado
                        realizarOperacion(calculadora, operacion);
                        
                        // 5. Preguntar si quiere otra operación en la misma base
                        otraOperacion = preguntar("¿Desea realizar otra operación en base " + calculadora.getBase() + "? (s/n): ");
                        
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
            
            // 6. Preguntar si quiere operar en otra base
            otraBase = preguntar("¿Desea operar en otra base? (s/n): ");
        }
        
        System.out.println("¡Gracias por usar la calculadora multibase!");
        scanner.close();
    }
    
    /**
     * Método para seleccionar la base numérica
     */
    private static CalculadoraBase seleccionarBase() {
        while (true) {
            try {
                System.out.println("\n=== SELECCIONE LA BASE NUMÉRICA ===");
                System.out.println("1. Binario (Base 2)");
                System.out.println("2. Octal (Base 8)");
                System.out.println("3. Decimal (Base 10)");
                System.out.println("4. Hexadecimal (Base 16)");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción (1-5): ");
                
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                
                switch (opcion) {
                    case 1: return new CalculadoraBinaria();
                    case 2: return new CalculadoraOctal();
                    case 3: return new CalculadoraDecimal();
                    case 4: return new CalculadoraHexadecimal();
                    case 5: return null;
                    default: 
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }
    
    /**
     * Método para seleccionar la operación
     */
    private static int seleccionarOperacion() {
        while (true) {
            try {
                System.out.println("\n=== SELECCIONE LA OPERACIÓN ===");
                System.out.println("1. Suma (+)");
                System.out.println("2. Resta (-)");
                System.out.println("3. Multiplicación (*)");
                System.out.println("4. División (/)");
                System.out.print("Seleccione una opción (1-4): ");
                
                int opcion = Integer.parseInt(scanner.nextLine().trim());
                
                if (opcion >= 1 && opcion <= 4) {
                    return opcion;
                } else {
                    System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
        }
    }
    
    /**
     * Método para pedir los dos números al usuario
     */
    private static void pedirNumeros(CalculadoraBase calculadora) {
        System.out.println("\n=== INGRESO DE NÚMEROS EN BASE " + calculadora.getBase() + " ===");
        
        // Patrón de validación según la base
        String patron = "";
        String ejemplo = "";
        
        switch (calculadora.getBase()) {
            case 2: 
                patron = "[01]+";
                ejemplo = "Ejemplo: 1010 (binario)";
                break;
            case 8:
                patron = "[0-7]+";
                ejemplo = "Ejemplo: 755 (octal)";
                break;
            case 10:
                patron = "-?[0-9]+";
                ejemplo = "Ejemplo: 123 (decimal)";
                break;
            case 16:
                patron = "[0-9A-Fa-f]+";
                ejemplo = "Ejemplo: 1A3F (hexadecimal)";
                break;
        }
        
        // Pedir primer número
        calculadora.setNumero1(obtenerNumeroValido("Ingrese el primer número: ", patron, ejemplo));
        
        // Pedir segundo número
        calculadora.setNumero2(obtenerNumeroValido("Ingrese el segundo número: ", patron, ejemplo));
    }
    
    /**
     * Método para obtener un número válido con validación
     */
    private static String obtenerNumeroValido(String mensaje, String patron, String ejemplo) {
        while (true) {
            try {
                System.out.print(mensaje);
                String input = scanner.nextLine().trim();
                
                if (input.isEmpty()) {
                    System.out.println("Error: No puede ingresar un valor vacío.");
                    continue;
                }
                
                if (input.matches(patron)) {
                    return input.toUpperCase();
                } else {
                    System.out.println("Error: Formato no válido. " + ejemplo);
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida.");
            }
        }
    }
    
    /**
     * Método para realizar la operación seleccionada
     */
    private static void realizarOperacion(CalculadoraBase calculadora, int operacion) {
        try {
            String simbolo = "";
            
            switch (operacion) {
                case 1:
                    calculadora.suma();
                    simbolo = " + ";
                    break;
                case 2:
                    calculadora.resta();
                    simbolo = " - ";
                    break;
                case 3:
                    calculadora.multiplicacion();
                    simbolo = " * ";
                    break;
                case 4:
                    calculadora.division();
                    simbolo = " / ";
                    break;
            }
            
            // Mostrar resultado
            System.out.println("\n=== RESULTADO ===");
            System.out.println(calculadora.getNumero1() + simbolo + calculadora.getNumero2() + " = " + calculadora.getResultado());
            System.out.println("En decimal: " + calculadora.convertir(calculadora.getResultado(), calculadora.getBase(), 10));
            
        } catch (ArithmeticException e) {
            System.out.println("Error matemático: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
    
    /**
     * Método para preguntar sí/no al usuario
     */
    private static boolean preguntar(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                String respuesta = scanner.nextLine().trim().toLowerCase();
                
                if (respuesta.equals("s") || respuesta.equals("si") || respuesta.equals("sí")) {
                    return true;
                } else if (respuesta.equals("n") || respuesta.equals("no")) {
                    return false;
                } else {
                    System.out.println("Por favor, responda 's' para sí o 'n' para no.");
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada no válida.");
            }
        }
    }
}