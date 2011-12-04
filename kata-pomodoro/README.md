Kata Pomodoro en Java
=====================

Realizar esta kata en un solo pomodoro es todo un reto. Afortunadamente el nivel de la
kata es adecuado para intentarlo con cierto nivel de confianza.

El problema que propone permite trabajar el API del pomodoro haciando TDD muy cómodamente.
El punto más interesante del problema es la *virtualización* del tiempo, es decir, que
a pesar de arrancar un pomodoro en realidad no hay ningún proceso contabilizando el tiempo
que transcurre. Llevando este tema un poco más lejos, los test hacen uso de un "sleep" de 1
segundo para realizar las pruebas. Esto tiene un efecto muy negativo, y es que los test
unitarios tardan mucho más de lo que las prácticas en TDD recomiendan, con lo cual este
tiempo de test también debería virtualizarse. Me lo apunto como otro TODO más.

Lo cierto es que me llevó más de un pomodoro realizarlo. La próxima vez lo intento hacer
por debajo de los 25 minutos, aunque ya he perdido la oportunidad de vencer el problema
sin conocerlo. Curiosamente buena parte de la kata se la llevó una indecisión personal
acerca de cómo tratar el tipo Tiempo. Como el valor por defecto incialmente es de 25 minutos,
me bastaba con un entero representando minutos, pero inmediatamente el valor de 25 minutos
se volvió incómodo para hacer los tests por ser de un grano demasiado grueso, así que 
lo refiné a segundos pero manteniendo el tipo entero (int). Cuando me cansé de las multiplicaciones
y divisiones para pasar de segundos a minutos a milis, creé un tipo Tiempo y todo fué más
fácil.

Esta semana he estado mirando un poco de OSGi. El libro de Jeff McAffer http://equinoxosgi.org/
desarrolla a lo largo de todo el libro una aplicación completa en OSGi, empezando por 3
sencillas clases sin ninguna relación con OSGi, hasta llegar a un sistema con interfaces
web y de escritorio. Ahora que tengo el Pomodoro listo, sería interesante portarlo a 
OSGi y "enchufarle" una UI al estilo plug-in.



