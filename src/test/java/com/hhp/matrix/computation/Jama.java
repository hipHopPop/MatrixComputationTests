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
		
		//------printing matrix subset
		double[][] d = new double[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				d[i][j] = Math.random();
			}
		}
		Matrix m = new Matrix(d);
		System.out.println("m\n" + print(m));
		System.out.println("m\n" + print(m, 4, 2));
	}
	//------------
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
		//------------
		private static String print(Matrix m, int rowPrintLength, int columnPrintLength) {
			StringBuilder sb = new StringBuilder();
			int rows = (m.getArray().length < rowPrintLength) ? m.getArray().length : rowPrintLength;
			int cols = (m.getArray()[0].length < columnPrintLength) ? m.getArray()[0].length : columnPrintLength;
			sb.append("<<<<<<<rows:" + m.getArray().length + ", cols:" + m.getArray()[0].length + " printing " + rows + " X " + cols + "\n");
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					double d = m.get(i, j);
					sb.append(fixedWidthDoubletoString(d, 12, 5)).append(" ");
				}
				sb.append("\n");
			}
			sb.append(">>>>>>>rows:" + m.getArray().length + ", cols:" + m.getArray()[0].length + " printing " + rows + " X " + cols + "\n");
			return sb.toString();
		}
		//------------	
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
