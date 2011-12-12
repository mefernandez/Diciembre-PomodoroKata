package org.katas.pomodoro.ui;

import static org.junit.Assert.*;

import org.junit.Test;

public class PomodoroUIAssemblerTest {

	@Test
	public void laVentanaCorreEnOtroHilo() throws InterruptedException {
		PomodoroUIAssembler assembler = new PomodoroUIAssembler();
		assembler.startup();
		assembler.threadPrincipal.join();
		assertTrue(assembler.ventana != null);
	}

}
