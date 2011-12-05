package org.katas.pomodoro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PomodoroTest {
	
	private Pomodoro pomodoro;
	private ProveedorTiempoMock proveedorTiempo;
	
	@Before
	public void setUp() {
		pomodoro = new Pomodoro();
		//proveedorTiempo = new ProveedorTiempoSistema();
		proveedorTiempo = new ProveedorTiempoMock();
		pomodoro.setProveedorTiempo(proveedorTiempo);
	}

	@Test
	public void crearUnPomodoroConDuracionPorDefecto() {
		Tiempo restante = pomodoro.start();
		assertEquals(25, restante.getMinutos());
	}

	@Test
	public void crearUnPomodoroConDuracionEspecifica() {
		pomodoro.setDuracion(new Tiempo(00,25,00));
		Tiempo restante = pomodoro.start();
		assertEquals(25, restante.getMinutos());
	}

	@Test
	public void unPomodoroRecienCreadoEstaParado() {
		Tiempo restante = pomodoro.getTiempoRestante();
		assertEquals(25, restante.getMinutos());
	}
	
	@Test
	public void alArrancarUnPomodoroComienzaLaCuentaAtras() throws InterruptedException {
		pomodoro.setDuracion(new Tiempo(00,00,05));
		pomodoro.start();
		// He virtualizado el pase del tiempo, as’ en vez de hacer un Thread.sleep(1000) 
		// llamo al "provider" de tiempo del Pomodoro para que simule que ha pasado 1 segundo 
		// Thread.currentThread().sleep(1*1000);
		proveedorTiempo.setInstanteActual(1000);
		Tiempo restante = pomodoro.getTiempoRestante();
		assertEquals(4, restante.getSegundos());
	}
	
	@Test
	public void unPomodoroTerminaCuandoSeAgotaSuTiempo() throws InterruptedException {
		pomodoro.setDuracion(new Tiempo(00,00,01));
		pomodoro.start();
		proveedorTiempo.setInstanteActual(1000);
		Tiempo restante = pomodoro.getTiempoRestante();
		assertEquals(0, restante.getSegundos());
	}
	
	@Test
	public void elTiempoNoPasaSiElPomodoroEstaDetenido() throws InterruptedException {
		pomodoro.setDuracion(new Tiempo(00,00,05));
		pomodoro.start();
		proveedorTiempo.setInstanteActual(1000);
		Tiempo restante = pomodoro.stop();
		assertEquals(4, restante.getSegundos());
		proveedorTiempo.setInstanteActual(2000);
		assertEquals(4, restante.getSegundos());
	}
	
	@Test
	public void unPomodoroSePuedeReanudar() throws InterruptedException {
		pomodoro.setDuracion(new Tiempo(00,00,05));
		proveedorTiempo.setInstanteActual(1000);
		pomodoro.start();
		proveedorTiempo.setInstanteActual(2000);
		Tiempo restante = pomodoro.stop();
		assertEquals(4, restante.getSegundos());
		proveedorTiempo.setInstanteActual(3000);
		pomodoro.start();
		proveedorTiempo.setInstanteActual(4000);
		restante = pomodoro.stop();
		assertEquals(3, restante.getSegundos());
	}
	
	@Test
	public void unPomodoroSePuedeReiniciar() throws InterruptedException {
		pomodoro.setDuracion(new Tiempo(00,00,05));
		proveedorTiempo.setInstanteActual(1000);
		pomodoro.start();
		proveedorTiempo.setInstanteActual(2000);
		Tiempo restante = pomodoro.stop();
		assertEquals(4, restante.getSegundos());
		restante = pomodoro.reset();
		assertEquals(5, restante.getSegundos());
		
		
	}	
}
