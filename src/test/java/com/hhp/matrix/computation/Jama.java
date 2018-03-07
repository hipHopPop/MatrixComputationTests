package com.hhp.matrix.computation;

import Jama.Matrix;

public class Jama {

	public static void main(String[] args) throws Exception {
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
		int size = 100;
		double[][] d = new double[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				d[i][j] = Math.random();
			}
		}
		Matrix m = new Matrix(d);
		System.out.println("m\n" + printSubSet_For0BasedIndex(m, 50, 8, 40, 8));
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
		private static String printSubSet_For0BasedIndex(
				Matrix m, int rowStartIndex, int noOfRows, int columnStartIndex, int noOfColumns) throws Exception {
			//
			int rows = m.getArray().length;
			int cols = m.getArray()[0].length;
			if (rowStartIndex < 0 || noOfRows < 0 || columnStartIndex < 0 || noOfColumns < 0
					|| rowStartIndex + 1 > rows || rowStartIndex + 1 + noOfRows > rows 
					|| columnStartIndex + 1 > cols || rowStartIndex + 1 + noOfColumns > cols) {
				throw new Exception("Invalid matrix parameters..matrix["+rows+" X " + cols + "], rowStartIndex["+rowStartIndex+"], "
						+ "noOfRows["+noOfRows+"], columnStartIndex["+columnStartIndex+"], noOfColumns["+noOfColumns+"]");
			}
			//
			StringBuilder sb = new StringBuilder();
			int rowEndIndex = rowStartIndex + noOfRows - 1;
			int columnEndIndex = columnStartIndex + noOfColumns - 1;
			sb.append("<<<<<<<rows:" + rows + ", cols:" + cols + " printing [" + rowStartIndex + "-" + rowEndIndex
				+ " X " + columnStartIndex + "-" + columnEndIndex + "]\n");
			for (int i = rowStartIndex; i <= rowEndIndex; i++) {
				for (int j = columnStartIndex; j <= columnEndIndex; j++) {
					double d = m.get(i, j);
					sb.append(fixedWidthDoubletoString(d, 12, 5)).append(" ");
				}
				sb.append("\n");
			}
			sb.append(">>>>>>>rows:" + rows + ", cols:" + cols + " printing [" + rowStartIndex + "-" + rowEndIndex
					+ " X " + columnStartIndex + "-" + columnEndIndex + "]\n");
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
