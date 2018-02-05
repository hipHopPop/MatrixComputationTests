package com.hhp.matrix.computation;

import no.uib.cipr.matrix.DenseMatrix;
import no.uib.cipr.matrix.Matrices;
import no.uib.cipr.matrix.Matrix;

public class MTJ {

	public static void main(String[] args) {
		DenseMatrix A = new DenseMatrix(new double[][] { { 1, 2 }, { 3, 4 } });
		System.out.println("A\n" + A);
		DenseMatrix B = new DenseMatrix(new double[][] { { 1, 2 }, { 2, 2 } });
		System.out.println("B\n" + B);
		System.out.println("A+B\n" + A.copy().add(B));
		DenseMatrix BMinus = (DenseMatrix) B.mult(new DenseMatrix(new double[][] { { -1, 0 }, { 0, -1 } }),
				new DenseMatrix(2, 2));
		System.out.println("BMinus\n" + BMinus);
		System.out.println("A-B\n" + A.copy().add(BMinus));
		System.out.println("A*B\n" + A.mult(B, new DenseMatrix(2, 2)));
		Matrix AInverse = A.solve(Matrices.identity(2), new DenseMatrix(2, 2));
		System.out.println("A inverse\n" + AInverse);
		System.out.println("BX=A (X = B inverse * A) (using B solve A)\n" + B.solve(A, new DenseMatrix(2, 2)));
		Matrix BInverse = B.solve(Matrices.identity(2), new DenseMatrix(2, 2));
		System.out.println("B inverse\n" + BInverse);
		System.out.println("B inverse * A\n" + BInverse.mult(A, new DenseMatrix(2, 2)));
	}
}
