package org.katas.pomodoro.ui;

import static org.junit.Assert.*;

import org.junit.Test;

public class VentanaPrincipalTest {

	@Test
	public void crearAbrirYCerrarLaVentanaPrincipal() {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		assertTrue(ventana.getLocation() != null);
		ventana.dispose();
	}

}
