# Índice Curricular: Desarrollo de Software en Java

## Nivel Intermedio - Avanzado

### I. Introducción a la Ingeniería de Software y Entorno Java

_Dominio de la infraestructura de desarrollo y manejo de flujo de entrada/salida._

#### 1.1. Arquitectura y Entorno

- **Conceptos fundamentales:** Diferencias y roles de la JVM, JRE y JDK.
    
- **Ecosistema de trabajo:** Configuración profesional del IDE y anatomía de un proyecto Java.
    

#### 1.2. Gestión Avanzada de Flujos de Entrada (I/O)

- **Clase `java.util.Scanner`:** Uso eficiente para la captura de datos.
    
- **Resolución de conflictos de buffer:**
    
    - Tratamiento del carácter de salto de línea (`\n`) tras la lectura de primitivos numéricos.
        
    - **Técnica de limpieza:** Implementación de `sc.nextLine()`.
        
    - **Técnica de omisión:** Uso de `sc.skip("\n")`.
        

#### 1.3. Tipado y Formateo

- **Wrappers:** Tipos primitivos vs. Clases Wrapper (Autoboxing/Unboxing).
    
- **Salida de consola:** Uso de `printf` y especificadores de formato para reportes limpios.
    
- **Aritmética de precisión:** Tratamiento de decimales y estrategias de redondeo.
    

### II. Programación Estructurada y Lógica Algorítmica

_Fundamentos lógicos para el control del flujo de ejecución y validación de datos._

#### 2.1. Estructuras de Control

- **Selección condicional:** Lógica compleja con `if-else` y optimización con `switch` (moderno).
    
- **Estructuras iterativas:** Aplicación de `for`, `while` y `do-while` según el caso de uso.
    

#### 2.2. Validación y Manipulación de Cadenas

- **Inmutabilidad:** Gestión de la clase `String` y el Pool de constantes.
    
- **Expresiones Regulares (Regex):** Validación de patrones mediante `.matches()` para integridad de datos.
    
- **Comparación:** Diferencia semántica entre `equals()` (valor) y `==` (referencia).
    

#### 2.3. Herramientas de Calidad de Código

- **Depuración (Debugging):** * Uso de _breakpoints_ (puntos de interrupción).
    
    - Inspección de variables en tiempo real y ejecución paso a paso (_step over/into_).
        
- **Aleatoriedad:** Generación de valores pseudoaleatorios con `Math.random` y la clase `Random`.
    

### III. Modularidad y Procedimientos

_Descomposición de problemas complejos y reutilización de código._

#### 3.1. Definición de Métodos

- **Firma de métodos:** Procedimientos (`void`) frente a funciones con retorno.
    
- **Comunicación:** Paso de parámetros por valor y manejo de argumentos.
    
- **Casting:** Conversión de tipos y promoción de primitivos.
    

#### 3.2. Lógica Aplicada (Casos de Estudio)

- **Algoritmos de verificación:** Implementación de lógicas reales (ej. validación de DNI).
    
- **Estructuras multidimensionales:** Manipulación de matrices bidimensionales y algoritmos de recorrido.
    

### IV. Estructuras de Datos Dinámicas

_Transición de estructuras estáticas a colecciones dinámicas del Framework de Java._

#### 4.1. Manejo de `ArrayList`

- **Genéricos:** Instanciación y tipado fuerte con `<E>`.
    
- **API de Colecciones:** Operaciones fundamentales (`add`, `get`, `set`, `remove`, `size`, `contains`).
    
- **Gestión de memoria:** Clonado, copia profunda y capacidad dinámica.
    

#### 4.2. Patrones de Iteración y Seguridad

- **Tipos de recorrido:** Comparativa entre `for` indexado y `for-each`.
    
- **Patrón Iterator:** Uso de la interfaz `Iterator` para navegación profesional.
    
- **Integridad referencial:** Prevención de `ConcurrentModificationException` mediante el uso correcto de `iterator.remove()`.
    

### V. Programación Orientada a Objetos (POO): Arquitectura Base

_Modelado de software basado en entidades reales._

#### 5.1. Diseño de Clases y Objetos

- **Estado y Comportamiento:** Definición de atributos y métodos.
    
- **Ciclo de vida:** Constructores, sobrecarga de constructores y el operador `new`.
    
- **Contexto:** Uso de la palabra clave `this` para desambiguación.
    

#### 5.2. Encapsulamiento y Modularización

- **Modificadores de Acceso:**
    
    - `private`: Seguridad y ocultamiento.
        
    - `default`: Ámbito de paquete.
        
    - `public`: Interfaz externa.
        
- **Acceso controlado:** Implementación estándar de _Getters_ y _Setters_.
    
- **Organización:** Gestión de nombres de dominio y estructura de `packages`.
    

### VI. POO Avanzada: Polimorfismo y Abstracción

_Diseño de sistemas escalables, desacoplados y jerárquicos._

#### 6.1. Herencia y Jerarquía

- **Especialización:** Uso de `extends` y la relación "es-un".
    
- **Superclases:** Uso de `super` para invocar constructores y miembros de la clase padre.
    

#### 6.2. Polimorfismo y Enlace Dinámico

- **Principio de Sustitución (Liskov):** Referencias de superclase para objetos de subclase.
    
- **Sobrescritura:** Uso de la anotación `@Override` para redefinir comportamientos.
    
- **Gestión de tipos:** * _Upcasting_ (seguro/implícito).
    
    - _Downcasting_ (explícito) con protección mediante `instanceof`.
        

#### 6.3. Abstracción Profesional

- **Clases Abstractas:** Creación de plantillas y métodos sin implementar.
    
- **Interfaces:** Definición de contratos de comportamiento y herencia múltiple funcional.
    
- **Decisión arquitectónica:** Criterios para elegir entre abstracción por clase o por interfaz.
    

#### 6.4. Ordenación y Contratos de Comparación

- **Interfaz `Comparable`:** Definición del orden natural de los objetos (`compareTo`).
    
- **Interfaz `Comparator`:** Creación de criterios de ordenación externos, múltiples y dinámicos.
    
- **Algoritmos:** Integración con `Collections.sort()` y expresiones lambda básicas.