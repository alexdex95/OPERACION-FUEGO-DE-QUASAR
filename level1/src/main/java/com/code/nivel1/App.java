package com.code.nivel1;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

/**
 * Operación Fuego de Quasar ! Jefferson Alexander Moreno Barrera
 *
 */
public class App {

	private static final String[] MESSAGEKENOBI = { "", "este", "es", "un", "mensaje" };
	private static final String[] MESSAGESKYWALKER = { "este", "", "un", "mensaje" };
	private static final String[] MESSAGESATO = { "", "", "es", "", "mensaje" };

	public static void main(String[] args) {

		JOptionPane.showMessageDialog(null, "OPERACIÓN FUEGO DE QUASAR");

		String distanceOne = JOptionPane.showInputDialog("INTRODUZCA LA DISTANCIA DEL SATELITE KENOBI:");
		String distanceTwo = JOptionPane.showInputDialog("INTRODUZCA LA DISTANCIA DEL SATELITE SKYWALKER:");
		String distanceThree = JOptionPane.showInputDialog("INTRODUZCA LA DISTANCIA DEL SATELITE SATO:");

		double[] distances = new double[] { Double.parseDouble(distanceOne), Double.parseDouble(distanceTwo),
				Double.parseDouble(distanceThree) };

		JOptionPane.showMessageDialog(null, "LA NAVE ESTA UBICADA EN EL EJE X:" + getlocation(distances)[0]);
		JOptionPane.showMessageDialog(null, "LA NAVE ESTA UBICADA EN EL EJE Y:" + getlocation(distances)[1]);

		JOptionPane.showMessageDialog(null, getmessage(MESSAGEKENOBI));
		JOptionPane.showMessageDialog(null, getmessage(MESSAGESKYWALKER));
		JOptionPane.showMessageDialog(null, getmessage(MESSAGESATO));

	}

	public static double[] getlocation(double[] distances) {
		double[][] positions = new double[][] { { -500.0, -200.0 }, { 100.0, -100.0 }, { 500.0, 100.0 } };

		TrilaterationFunction trilaterationFunction = new TrilaterationFunction(positions, distances);
		NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(trilaterationFunction,
				new LevenbergMarquardtOptimizer());
		return nSolver.solve().getPoint().toArray();
	}

	public static String getmessage(String[] messages) {
		String[] fullMessage = { "este", "es", "un", "mensaje" };

		StringBuilder messageFinal = new StringBuilder();
		int number = 0;

		for (int j = 0; j < messages.length - 1; j++) {
			if (j == 0 && messages[j].equalsIgnoreCase("")) {
				messages = ArrayUtils.remove(messages, j);
			}
		}

		for (int i = 0; i < messages.length; i++) {
			for (int k = number; k < fullMessage.length;) {
				String wordAdd = messages[i].equalsIgnoreCase(fullMessage[k]) ? messages[i] : "";
				messageFinal.append(" " + wordAdd);
				number++;
				if (number > 0) {
					break;
				}
			}
		}
		return messageFinal.toString();
	}

}
