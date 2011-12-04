package org.katas.pomodoro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TiempoTest {

	@Test
	public void restarSegundos() {
		Tiempo t = new Tiempo(00,00,05);
		t.restar(1000);
		assertEquals(4, t.getSegundos());
	}

}
