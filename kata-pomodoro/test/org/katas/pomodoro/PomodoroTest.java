package org.katas.pomodoro;

import static org.junit.Assert.*;

import org.junit.Test;

public class PomodoroTest {

	@Test
	public void crearUnPomodoroConDuracionPorDefecto() {
		Pomodoro pomodoro = new Pomodoro();
		Tiempo restante = pomodoro.start();
		assertEquals(25, restante.getMinutos());
	}

	@Test
	public void crearUnPomodoroConDuracionEspecifica() {
		Pomodoro pomodoro = new Pomodoro();
		pomodoro.setDuracion(new Tiempo(00,25,00));
		Tiempo restante = pomodoro.start();
		assertEquals(25, restante.getMinutos());
	}

	@Test
	public void unPomodoroRecienCreadoEstaParado() {
		Pomodoro pomodoro = new Pomodoro();
		pomodoro.setDuracion(new Tiempo(00,25,00));
		Tiempo restante = pomodoro.getTiempoRestante();
		assertEquals(25, restante.getMinutos());
	}
	
	@Test
	public void alArrancarUnPomodoroComienzaLaCuentaAtras() throws InterruptedException {
		Pomodoro pomodoro = new Pomodoro();
		pomodoro.setDuracion(new Tiempo(00,00,05));
		pomodoro.start();
		Thread.currentThread().sleep(1*1000);
		Tiempo restante = pomodoro.getTiempoRestante();
		assertEquals(4, restante.getSegundos());
	}
	
	@Test
	public void unPomodoroTerminaCuandoSeAgotaSuTiempo() throws InterruptedException {
		Pomodoro pomodoro = new Pomodoro();
		pomodoro.setDuracion(new Tiempo(00,00,01));
		pomodoro.start();
		Thread.currentThread().sleep(1*1000);
		Tiempo restante = pomodoro.getTiempoRestante();
		assertEquals(0, restante.getSegundos());
	}
	
	@Test
	public void elTiempoNoPasaSiElPomodoroEstaDetenido() throws InterruptedException {
		Pomodoro pomodoro = new Pomodoro();
		pomodoro.setDuracion(new Tiempo(00,00,05));
		pomodoro.start();
		Thread.currentThread().sleep(1*1000);
		Tiempo restante = pomodoro.stop();
		assertEquals(4, restante.getSegundos());
		Thread.currentThread().sleep(1*1000);
		assertEquals(4, restante.getSegundos());
	}
	
	@Test
	public void unPomodoroSePuedeReanudar() throws InterruptedException {
		Pomodoro pomodoro = new Pomodoro();
		pomodoro.setDuracion(new Tiempo(00,00,05));
		Thread.currentThread().sleep(1*1000);
		pomodoro.start();
		Thread.currentThread().sleep(1*1000);
		Tiempo restante = pomodoro.stop();
		assertEquals(4, restante.getSegundos());
		Thread.currentThread().sleep(1*1000);
		pomodoro.start();
		Thread.currentThread().sleep(1*1000);
		restante = pomodoro.stop();
		assertEquals(3, restante.getSegundos());
	}
	
	@Test
	public void unPomodoroSePuedeReiniciar() throws InterruptedException {
		Pomodoro pomodoro = new Pomodoro();
		pomodoro.setDuracion(new Tiempo(00,00,05));
		Thread.currentThread().sleep(1*1000);
		pomodoro.start();
		Thread.currentThread().sleep(1*1000);
		Tiempo restante = pomodoro.stop();
		assertEquals(4, restante.getSegundos());
		restante = pomodoro.reset();
		assertEquals(5, restante.getSegundos());
		
		
	}	
}
