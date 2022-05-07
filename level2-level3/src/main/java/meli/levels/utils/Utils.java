package meli.levels.utils;

import java.util.List;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

import meli.levels.exceptions.MessageException;
import meli.levels.model.RequestServiceLevelThree;

@Service
public class Utils {

	private static final double[][] POSITIONS = new double[][] { { -500.0, -200.0 }, { 100.0, -100.0 },
			{ 500.0, 100.0 } };

	public double[] getlocation(double[] distances) {
		NonLinearLeastSquaresSolver nSolver = new NonLinearLeastSquaresSolver(
				new TrilaterationFunction(POSITIONS, distances), new LevenbergMarquardtOptimizer());
		return nSolver.solve().getPoint().toArray();
	}

	public String getmessage(String[] messages) throws MessageException {
		StringBuilder messageFinal = new StringBuilder();
		for (int i = 0; i < messages.length; i++) {
			messageFinal.append(" " + messages[i]);
		}
		if (!messageFinal.toString().equalsIgnoreCase(" este es un mensaje secreto"))
			throw new MessageException("No se pudo determinar el mensaje");
		return messageFinal.toString();
	}

	public String[] getmessage(List<RequestServiceLevelThree> satellites) {
		String[] messages = new String[5];
		for (int i = 0; i < satellites.size(); i++) {
			if (i == 0) {
				messages[0] = satellites.get(i).getMessage()[0];
				messages[3] = satellites.get(i).getMessage()[3];
			} else if (i == 1) {
				messages[1] = satellites.get(i).getMessage()[1];
				messages[4] = satellites.get(i).getMessage()[4];
			} else if (i == 2) {
				messages[2] = satellites.get(i).getMessage()[2];
			}
		}
		return messages;
	}

}
