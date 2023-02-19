package uniandes.algorithms.coinchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RecursiveCoinChangeAlgorithm implements CoinChangeAlgorithm {
	int[] data;
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		data = new int[denominations.length];
		Arrays.fill(data, 0);
		ArrayList<Integer> list = new ArrayList<>();
		for (int z = 0; z<denominations.length; z ++) list.add(denominations[z]);
		Collections.sort(list);
		int result = calcular(denominations, denominations.length, totalValue);
		int j = denominations.length - 1; 
		int total = totalValue;
		for (int i = 0; i < result; i++) {
			if (total < list.get(j)) {
				i--;
				j--;
			}else if (totalValue >= list.get(j)) {
				data[j] = data[j] + 1;
				total = total - list.get(j);
			}
		}
		return data;
	}
	
	public Integer calcular(int[] d, Integer i, Integer j) {
		if (i == 0) {
			return (int)Double.POSITIVE_INFINITY;
		} else if (j == 0) {
			 return 0;
		} else if (j == d[i-1]) {
			return 1;
		} else if (d[i-1] > j) {
			return calcular(d, i-1,j);
		}
		int a = 1 + calcular(d,i, j-d[i-1]);
		int b = calcular(d,i-1,j);
		if (a <= b) {
			return a;
		}
		return b;
	}
}
