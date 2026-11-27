🧪 Casos de Prueba – AulaLogic

1. Introducción

Este documento presenta los casos de prueba realizados para verificar el correcto funcionamiento del sistema AulaLogic, desarrollado en Java para el seguimiento del rendimiento académico de los estudiantes.

2. Casos de prueba

N.º	Caso de prueba	Datos de entrada	Resultado esperado
1	Registro correcto	Código: EST001, nombre: Juan Pérez, nota: 18	Estudiante registrado correctamente.
2	Código duplicado	Código: EST001 ya registrado	El sistema informa que el código ya existe.
3	Calificación fuera del rango	Nota: 22	El sistema rechaza la calificación.
4	Promedio igual a 15	Promedio: 15	Estado: APROBADO.
5	Búsqueda existente	Código: EST001	Se muestran los datos del estudiante.
6	Búsqueda inexistente	Código: EST999	El sistema informa que no existe el estudiante.
7	Reporte sin estudiantes	Lista vacía	El sistema informa que no hay registros disponibles.
8	Guardado y recuperación	Registro de un estudiante	Los datos se guardan y recuperan correctamente.

3. Criterios de aprobación

* Calificaciones permitidas: de 0 a 20.
* Nota mínima de aprobación: 15.
* Promedio de 15 a 20: APROBADO.
* Promedio menor a 15: REPROBADO.

4. Conclusión

Los casos de prueba permiten comprobar que AulaLogic cumple con las funcionalidades establecidas, valida correctamente los datos ingresados y procesa la información académica de los estudiantes.
# 🧪 Casos de prueba — AulaLogic

## Criterios generales

- Las calificaciones deben estar entre **0 y 20**, inclusive.
- El promedio se obtiene sumando las tres calificaciones y dividiendo para tres.
- Promedio igual o superior a **15**: **APROBADO**.
- Promedio menor a **15**: **REPROBADO**.

## CP01 – Registro correcto

| Elemento | Detalle |
|---|---|
| **Objetivo** | Comprobar que el sistema registre un estudiante con datos válidos. |
| **Datos de entrada** | Código: `001`; nombre: `Ana Torres`; notas: `18`, `16`, `17`. |
| **Procedimiento** | Seleccionar la opción de registro e ingresar los datos solicitados. |
| **Resultado esperado** | El estudiante se registra correctamente. El promedio es `17,00` y el estado es `APROBADO`. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

## CP02 – Código duplicado

| Elemento | Detalle |
|---|---|
| **Objetivo** | Verificar que no se permita registrar dos estudiantes con el mismo código. |
| **Datos de entrada** | Registrar el código `001` para Ana Torres y luego intentar registrar nuevamente el código `001` para otro estudiante. |
| **Procedimiento** | Realizar el primer registro y repetir el registro usando el mismo código. |
| **Resultado esperado** | El sistema rechaza el segundo registro e informa que el código ya existe. El registro original se conserva. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

## CP03 – Calificación fuera del rango

| Elemento | Detalle |
|---|---|
| **Objetivo** | Comprobar la validación del rango permitido para las calificaciones. |
| **Datos de entrada** | Código: `006`; nombre: `Estudiante de prueba`; notas de ejemplo: `21`, `14`, `16`. |
| **Procedimiento** | Intentar registrar al estudiante con una calificación superior a 20. |
| **Resultado esperado** | El sistema informa que la calificación debe estar entre 0 y 20 y no acepta el dato inválido. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

## CP04 – Promedio igual a 15

| Elemento | Detalle |
|---|---|
| **Objetivo** | Verificar el límite mínimo de aprobación de la Variante E. |
| **Datos de entrada** | Código: `002`; nombre: `Luis Mena`; notas: `15`, `15`, `15`. |
| **Procedimiento** | Registrar o consultar al estudiante y revisar el promedio calculado. |
| **Resultado esperado** | El promedio es `15,00` y el estado es `APROBADO`, porque 15 es el mínimo requerido. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

## CP05 – Búsqueda de estudiante existente

| Elemento | Detalle |
|---|---|
| **Objetivo** | Comprobar que la búsqueda encuentre a un estudiante registrado. |
| **Datos de entrada** | Código: `003`. |
| **Procedimiento** | Seleccionar la opción de búsqueda e ingresar el código `003`. |
| **Resultado esperado** | El sistema encuentra a Rosa Paredes y muestra sus notas `12`, `14`, `13`, promedio `13,00` y estado `REPROBADO`. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

## CP06 – Búsqueda de estudiante inexistente

| Elemento | Detalle |
|---|---|
| **Objetivo** | Verificar el comportamiento cuando el código no está registrado. |
| **Datos de entrada** | Código: `999`. |
| **Procedimiento** | Seleccionar la opción de búsqueda e ingresar el código `999`. |
| **Resultado esperado** | El sistema informa que no se encontró ningún estudiante con ese código y continúa funcionando. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

## CP07 – Reporte sin estudiantes

| Elemento | Detalle |
|---|---|
| **Objetivo** | Comprobar que el sistema gestione correctamente la generación de reportes cuando no existen registros. |
| **Datos de entrada** | Lista de estudiantes vacía. |
| **Procedimiento** | Iniciar el sistema sin estudiantes registrados y seleccionar la opción de generar reporte. |
| **Resultado esperado** | El sistema muestra un mensaje indicando que no existen estudiantes registrados. No presenta promedios ni estadísticas incorrectas y no se produce un error. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

## CP08 – Guardado y recuperación de datos

| Elemento | Detalle |
|---|---|
| **Objetivo** | Verificar que los registros se almacenen en un archivo de texto y puedan recuperarse. |
| **Datos de entrada** | Registrar, por ejemplo, a Mario Silva con código `004` y notas `20`, `18`, `19`. |
| **Procedimiento** | Guardar los registros, cerrar el programa y volver a ejecutarlo usando la opción de cargar o recuperar información. |
| **Resultado esperado** | El sistema recupera el registro de Mario Silva con sus tres calificaciones. Su promedio es `19,00` y su estado es `APROBADO`. |
| **Resultado obtenido** | Por completar durante la ejecución. |
| **Estado de la prueba** | Pendiente de ejecución. |

---

## Resumen de ejecución

| Código | Caso de prueba | Resultado esperado | Estado |
|---|---|---|---|
| CP01 | Registro correcto | Registro aceptado y promedio correcto | Pendiente |
| CP02 | Código duplicado | Segundo registro rechazado | Pendiente |
| CP03 | Calificación fuera del rango | Dato inválido rechazado | Pendiente |
| CP04 | Promedio igual a 15 | Estado APROBADO | Pendiente |
| CP05 | Búsqueda existente | Datos del estudiante encontrados | Pendiente |
| CP06 | Búsqueda inexistente | Mensaje de no encontrado | Pendiente |
| CP07 | Reporte sin estudiantes | Mensaje de lista vacía | Pendiente |
| CP08 | Guardado y recuperación | Datos recuperados correctamente | Pendiente |

**Nota:** Los resultados obtenidos y el estado final deben completarse después de ejecutar cada prueba en el programa. Esta documentación describe los resultados esperados; no afirma que las pruebas ya hayan sido ejecutadas.
