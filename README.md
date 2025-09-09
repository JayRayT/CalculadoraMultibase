Juan David Rayo Tejada - 20231020023
 Jonnatan Camargo Camacho - 20231020204

# 📟 Calculadora Multibase en Java

Este proyecto implementa una **calculadora en consola** capaz de realizar operaciones aritméticas (suma, resta, multiplicación y división) en diferentes sistemas numéricos:

- **Binario (Base 2)**
- **Octal (Base 8)**
- **Decimal (Base 10)**
- **Hexadecimal (Base 16)**

Además, permite convertir resultados entre distintas bases numéricas.

---

## 🚀 Características

- Implementación con **programación orientada a objetos** usando herencia y clases abstractas.  
- Manejo de **diferentes sistemas de numeración**.  
- Validación de entrada de números según la base seleccionada.  
- Conversión automática del resultado a **decimal** para facilitar la interpretación.  
- Flujo interactivo en consola con opción de realizar múltiples operaciones y cambiar de base.  

---

## 🛠️ Estructura del proyecto

El paquete `calculadora` contiene las siguientes clases:

- **`CalculadoraBase`** → Clase abstracta que define la estructura común de todas las calculadoras.  
- **`CalculadoraDecimal`** → Implementación para operaciones en base 10.  
- **`CalculadoraBinaria`** → Implementación para operaciones en base 2.  
- **`CalculadoraOctal`** → Implementación para operaciones en base 8.  
- **`CalculadoraHexadecimal`** → Implementación para operaciones en base 16.  
- **`Main`** → Clase principal que ejecuta el programa en consola.  

---

## 📂 Ejecución

1. Compilar los archivos dentro del paquete `calculadora`:

``bash
=== CALCULADORA MULTIBASE ===

=== SELECCIONE LA BASE NUMÉRICA ===
1. Binario (Base 2)
2. Octal (Base 8)
3. Decimal (Base 10)
4. Hexadecimal (Base 16)
5. Salir
Seleccione una opción (1-5): 3

=== SELECCIONE LA OPERACIÓN ===
1. Suma (+)
2. Resta (-)
3. Multiplicación (*)
4. División (/)
Seleccione una opción (1-4): 1

=== INGRESO DE NÚMEROS EN BASE 10 ===
Ingrese el primer número: 25
Ingrese el segundo número: 17

=== RESULTADO ===
25 + 17 = 42
En decimal: 42

javac calculadora/*.java
