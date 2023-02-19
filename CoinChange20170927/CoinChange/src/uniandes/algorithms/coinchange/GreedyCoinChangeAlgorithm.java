package uniandes.algorithms.coinchange;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm{
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
		int mx;
		if (d != null && d.length >0) {
			mx = Arrays.stream(d).max().getAsInt();
		}
		else {
			return 0;
		}
		if (j == 0){
			return 0;
		}
		if (mx <= j) {
			return 1+calcular(d, i, j-mx);
		}
		else {
			for (int k = 0; k < d.length; k++) {
                if (d[k] == mx) {
                	int index = k;
        	  int[] newArray = new int[d.length - 1];

        	    
        	    for (int m = 0, u = 0; m < d.length; m++) {
        	        if (index == m) {
        	            continue;
        	        }
        	        newArray[u++] = d[m];
        	    }

        	    d = newArray;
			
		    }     
	      }
		return calcular(d, i, j);
	}
   }
}