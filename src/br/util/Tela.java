package br.util;

import java.awt.Dimension;
import java.awt.Toolkit;

public class Tela {
	/******************************************
	 ****** Utilidades relacionadas ******** � tela/display gr�fico ********
	 *******************************************/

	public static int getWidth() {
		Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) tamanhoDaTela.getWidth();
	}

	public static int getHeight() {
		Dimension tamanhoDaTela = Toolkit.getDefaultToolkit().getScreenSize();
		return (int) tamanhoDaTela.getHeight();
	}
}
