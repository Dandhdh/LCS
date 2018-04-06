public class LCSdemo {

	//动态规划求两字符串最长公共字串
	public static int lcsLength(char [] x,char [] y, int[][]b){
		
		int m = x.length-1;
		int n = y.length-1;
		
		int[][] c = new int[m+1][n+1];
		
		if(x[0]==y[0]){
			c[0][0]=1;
		}
		
		for(int i=1; i<=n; i++){
			if(x[0]==y[i]){
				c[0][i]=1;
				b[0][i]=1;
			}
			else{
				c[0][i]= c[0][i-1]=1;
				b[0][i]=3;
			}
		}
		
		for(int i=1; i<=m; i++){
			if(x[i]==y[0]){
				c[i][0]=1;
				b[i][0]=1;
			}
			else{
				c[i][0]= c[i-1][0]=1;
				b[i][0]=2;
			}
		}
		
		for(int i=1; i<=m; i++){
			for(int j=1; j<=n; j++){
				if(x[i-1]==y[j-1]){
					c[i][j] = c[i-1][j-1]+1;
					b[i][j] = 1;
				}
				else if(c[i-1][j]>c[i][j-1]){
					c[i][j] = c[i-1][j];
					b[i][j] = 2;
				}
				else{
					c[i][j] = c[i][j-1];
					b[i][j] = 3;
				}
			}
		}
		return c[m][n];
	}

	//回溯的基本实现，采取递归的方式 
	public static void lcs(int i, int j, char[] x, int [][] b){
		if(i<0 || j<0) {
			return ;
		}
		if(b[i][j]==1){
			lcs(i-1,j-1,x,b);
			System.out.print(x[i]+" ");
		}else if(b[i][j]==2){
			lcs(i-1,j,x,b);
		}
		else{
			lcs(i,j-1,x,b);
		}
	}
	
	public static void main(String[] args) {
		String str1 = "sdabcddfr";
		String str2 = "sqsdabcddsdd";
		
		int m = str1.length()-1;
		int n = str2.length()-1;
		
		int[][] b = new int[m+1][n+1];
		System.out.println("最长公共子串长度为："+lcsLength(str1.toCharArray(), str2.toCharArray(), b));
		lcs(m, n, str1.toCharArray(), b);
	}
}
