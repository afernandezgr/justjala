# Práctica Fundamentos de Android Mobile Bootcamp VI



## Notas sobre la implementación

**Requisitos**


● Cuenta con el modelo de la lisa de posibles platos precargada

● Nada más arrancar se accede a un listado de las mesas de los clientes.

● Cuando se accede a una mesa puede verse lo que han pedido hasta el momento. No guarda lo qué ha pedido cada cliente individual.

● Desde esa vista de mesa se deben poder añadir platos. Para esto aparece otra pantalla donde se pueda elegir el plato de una lista. En esa lista aparece el nombre del plato, una pequeña imagen, unos iconos que indiquen los alérgenos que posee (si los tiene) y su precio

● Al pulsar sobre un plato aparece una pantalla con la información del plato (imagen, algún detalle más…), y una caja de texto donde poner las pequeñas variantes que pueda pedir un cliente

● Si guardamos dicho plato se añadirá a la lista de los platos que han pedido en una mesa

● Debe existir un pequeño menú para calcular la cuenta

**Interface**

En la pantalla que muestra los platos de cada mesa ha solicitado existe en la parte superior un fragmente que incluye los siguientes funcionalides:

● Nombre de la mesa

● Botón 'Check' para solicitar la cuenta , al pulsarlo se mostrar un menú modal donde se muestra la información de la cuenta de la que se va a generar la cuenta, y el coste de la misma. Al pulsar el botón de OK se genera la cuenta y se iniciliza la cuenta de la misma

● Visualizado de la cuenta acumulada de la mesa en cuestión.

● Botón '+' para añadir un plato nuevo a la cuenta de la mesa

En la pantalla que visualiza los platos disponibles si se pulsa sobre cualquiera de ellos se abrirá un dialogo especifico que muestra información ampiada del plato seleccionado. Desde este mismo dialogo se podrá incluir algún comentario que el comensal quiera hacer sobre el plato en cuestión. Si éste es introducido se añade junto con la comanda.

*****


Adolfo Fernández 
2018

