package uniandes.algorithms.coinchange;

public class DynamicProgrammingCoinChangeAlgorithm implements CoinChangeAlgorithm{

	@Override
	public int[] calculateOptimalChange(int totalValue, int[] denominations) {
		int[][] m = matriz(totalValue, denominations);
		return recuperar(m, totalValue, denominations);
	}
	public int[][] matriz(int totalValue, int[] denominations){
		int n = denominations.length;
		int[][] m = new int[n+1][totalValue + 1];
		int i = 0;
		while (i < n+1) {
			int j = 0;
			while(j <= totalValue) {
				if (i == 0) {
					m[i][j] = (int)Double.POSITIVE_INFINITY;
				} else if (j == denominations[i-1]) {
					m[i][j] = 1;
				} else if (j < denominations[i-1]) {
					m[i][j] = m[i-1][j];
				} else if (j > denominations[i-1]) {
					m[i][j] = Math.min(1 + m[i][j-denominations[i-1]], m[i-1][j]);
				}
				j++;
			}
			i++;
		}
		return m;
	}
	
	public int[] recuperar(int[][] m, int totalValue, int[] denominations) {
		int[] retorno = new int[denominations.length];
		int i = denominations.length;
		int j = totalValue;
		while (i>0) {
			if (j > denominations[i-1] && m[i][j] == 1 + m[i][j-denominations[i-1]]) {
				retorno[i-1] = retorno[i-1] + 1;
				j = j - denominations[i-1];
			} else if ((j > denominations[i-1] && m[i][j] == m[i-1][j])|| j < denominations[i-1]) {
				i--;
			} else if (j == denominations[i-1]) {
				retorno[i-1] = retorno[i-1] + 1;
				i = 0;
			}
		}
		return retorno;
	}
}
