package uniandes.algorithms.coinchange;

import java.util.Arrays;

public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm {
	int[] data;
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		return calcular(denominations, denominations.length, totalValue);
	}
	
	public int[] calcular(int[] d, Integer i, Integer j) {
		if (i == 0) {
			int[] datos = new int[d.length];
			Arrays.fill(datos, (int)Double.POSITIVE_INFINITY);
			return datos;
		} else if (j == 0) {
			int[] datos = new int[d.length];
			Arrays.fill(datos, 0);
			return datos;
		} else if (j == d[i-1]) {
			int[] datos = new int[d.length];
			Arrays.fill(datos, 0);
			datos[i-1] = 1;
			return datos;
		} else if (d[i-1] > j) {
			return calcular(d, i-1,j);
		}
		int[] a = calcular(d,i, j-d[i-1]);
		int valorA = valor(a) + 1;
		int[] b = calcular(d,i-1,j);
		int valorB = valor(b);
		if (valorA <= valorB) {
			a[i-1] = a[i-1] + 1;
			return a;
		}
		return b;
	}
	
	public int valor(int[]v) {
		int sum = 0;
		int i = 0;
		while (i < v.length) {
			sum = sum + v[i];
			i++;
		}
		return sum;
	}
}
