
import java.util.Scanner;


class Matrix
{
	int n;
	int [][]mat;
	public Matrix(int n)
	{
		this.mat=new int[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				mat[i][j]=0;
	}
	public void connect(int i, int j)
	{
		mat[i][j]=1;
		mat[j][i]=1;
	}
	public void display(int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}
public class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String line0 = sc.nextLine();
		String line1 = sc.nextLine();
		String line2 = sc.nextLine();
		int ver = Integer.parseInt(line1);
		Matrix m =new Matrix(ver);
		String place= sc.nextLine();
		String []ary= place.split(",");
		while(sc.hasNext())
		{
			String verx = sc.nextLine();
			String[] nod = verx.split(" ");
			int i1 =Integer.parseInt(nod[0]);
			int i2 =Integer.parseInt(nod[1]);
			//System.out.println("i1 : "+i1+" i2 : "+i2);
			m.connect(i1,i2);
		}
		m.display(ver);
	}

}
