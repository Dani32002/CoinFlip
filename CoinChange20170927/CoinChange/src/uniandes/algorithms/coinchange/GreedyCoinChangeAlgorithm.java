package uniandes.algorithms.coinchange;


import java.util.Arrays;



public class GreedyCoinChangeAlgorithm implements CoinChangeAlgorithm{
	int[] data;
	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		data = new int[denominations.length];
		Arrays.fill(data, 0);
		int i = denominations.length-1;
		int j = totalValue;
		while (i>=0) {
			if (denominations[i] <= j) {
				data[i] +=1;
				j -= denominations[i];	
			}
			else {
				i--;
			}
			
		}
		
		
		return data;
	}
}