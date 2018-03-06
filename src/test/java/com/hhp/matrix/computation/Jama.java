package com.hhp.matrix.computation;

import Jama.Matrix;

public class Jama {

	public static void main(String[] args) {
		Matrix A = new Matrix(new double[][] { { 1, 2 }, { 3, 4 } });
		System.out.println("A\n" + print(A));
		Matrix B = new Matrix(new double[][] { { 2, 2 }, { 2, 2 } });
		System.out.println("B\n" + print(B));
		System.out.println("A+B\n" + print(A.plus(B)));
		System.out.println("A-B\n" + print(A.minus(B)));
		System.out.println("A*B\n" + print(A.times(B)));
		System.out.println("A inverse\n" + print(A.inverse()));
		System.out.println("B/A\n" + print(A.arrayLeftDivide(B)));
		System.out.println("A/B\n" + print(A.arrayRightDivide(B)));
	}

	private static String print(Matrix m) {
		StringBuilder sb = new StringBuilder();
		double[][] array = m.getArray();
		sb.append("<<<<<<<rows:" + array.length + ", cols:" + array[0].length + "\n");
		for (double[] ds : array) {
			for (double d : ds) {
				sb.append(fixedWidthDoubletoString(d, 12, 5)).append(" ");
			}
			sb.append("\n");
		}
		sb.append(">>>>>>>rows:" + array.length + ", cols:" + array[0].length + "\n");
		return sb.toString();
	}

	private static String fixedWidthDoubletoString(double x, int w, int d) {
		java.text.DecimalFormat fmt = new java.text.DecimalFormat();
		fmt.setMaximumFractionDigits(d);
		fmt.setMinimumFractionDigits(d);
		fmt.setGroupingUsed(false);
		String s = fmt.format(x);
		while (s.length() < w) {
			s = " " + s;
		}
		return s;
	}
}
