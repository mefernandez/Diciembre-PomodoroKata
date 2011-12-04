Kata Pomodoro en Java
=====================

Realizar esta kata en un solo pomodoro es todo un reto. Afortunadamente el nivel de la
kata es adecuado para intentarlo con cierto nivel de confianza.

El problema que propone permite trabajar el API del pomodoro haciando TDD muy c�modamente.
El punto m�s interesante del problema es la *virtualizaci�n* del tiempo, es decir, que
a pesar de arrancar un pomodoro en realidad no hay ning�n proceso contabilizando el tiempo
que transcurre. Llevando este tema un poco m�s lejos, los test hacen uso de un "sleep" de 1
segundo para realizar las pruebas. Esto tiene un efecto muy negativo, y es que los test
unitarios tardan mucho m�s de lo que las pr�cticas en TDD recomiendan, con lo cual este
tiempo de test tambi�n deber�a virtualizarse. Me lo apunto como otro TODO m�s.

Lo cierto es que me llev� m�s de un pomodoro realizarlo. La pr�xima vez lo intento hacer
por debajo de los 25 minutos, aunque ya he perdido la oportunidad de vencer el problema
sin conocerlo. Curiosamente buena parte de la kata se la llev� una indecisi�n personal
acerca de c�mo tratar el tipo Tiempo. Como el valor por defecto incialmente es de 25 minutos,
me bastaba con un entero representando minutos, pero inmediatamente el valor de 25 minutos
se volvi� inc�modo para hacer los tests por ser de un grano demasiado grueso, as� que 
lo refin� a segundos pero manteniendo el tipo entero (int). Cuando me cans� de las multiplicaciones
y divisiones para pasar de segundos a minutos a milis, cre� un tipo Tiempo y todo fu� m�s
f�cil.

Esta semana he estado mirando un poco de OSGi. El libro de Jeff McAffer http://equinoxosgi.org/
desarrolla a lo largo de todo el libro una aplicaci�n completa en OSGi, empezando por 3
sencillas clases sin ninguna relaci�n con OSGi, hasta llegar a un sistema con interfaces
web y de escritorio. Ahora que tengo el Pomodoro listo, ser�a interesante portarlo a 
OSGi y "enchufarle" una UI al estilo plug-in.



