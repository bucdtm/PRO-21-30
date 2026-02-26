¿Cómo funciona el código?
He estructurado la clase Main para cumplir estrictamente con los requisitos de tu documento:


Estructuras de Datos: * Utilizamos Set<PacienteBase> (HashSet) para garantizar que no haya pacientes duplicados basándose en el identificador único (ID).

Usamos Map<String, List<PacienteVisita>> (HashMap) para almacenar el historial de visitas, donde la clave es el ID del paciente y el valor es la lista de sus visitas.

Implementamos tres colas (Queue) de tipo LinkedList para organizar a los pacientes por su gravedad: leves, moderados y graves.

Registrar Paciente (Opción 1): * Pide los datos, crea un objeto PacienteBase y lo añade al Set. Si el método .add() retorna true, se crea el registro inicial en el mapa de historial.

Si retorna false (el paciente ya existía), muestra un mensaje de error y el historial existente, evitando duplicados.


Crear Visita (Opción 2): * Comprueba primero si el ID existe en el Set. Si no existe, muestra un error y detiene el flujo.
+1

Si existe, crea el objeto PacienteVisita y lo añade a la lista correspondiente en el historial.

Dependiendo del rango de prioridad (1-9), el paciente se encola en su cola correspondiente. Si la prioridad es 10, la atención es inmediata y se llama al método sobrecargado para atenderlo directamente sin pasar por colas.
+4

Atender Paciente (Opción 3):

Sigue un orden de jerarquía estricto: primero comprueba la cola de graves, luego moderados y por último leves.

Utiliza el método .poll() para extraer al primer paciente de la cola pertinente y aplica la sobrecarga del método atenderSiguiente() para asignarle diagnóstico, tratamiento, médico y marcarlo como atendido.
+1

Reevaluación Automática (Extra): * Se lleva un contador global. Cada vez que 5 pacientes son atendidos, se dispara la lógica de reevaluación.

Se extraen todas las visitas de las colas de leves y moderados, se incrementa su prioridad en una unidad y se reencolan (las visitas graves no se modifican). Si alguna alcanza el nivel 10 en este proceso, se atiende de forma automática.
+1

¿Te gustaría que te ayude a crear casos de prueba (testing) para verificar que las colas de prioridad funcionan exactamente como esperas?