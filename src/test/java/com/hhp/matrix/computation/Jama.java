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
		for (double[] ds : array) {
			for (double d : ds) {
				sb.append(d).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
