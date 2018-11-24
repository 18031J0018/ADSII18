
import java.text.DecimalFormat;
import java.util.Scanner;

class Graph
{
	int v;
	double [][]matrix;
	public Graph(int v)
	{
		this.v=v;
		matrix = new double[v][v];
		for(int i=0;i<v;i++)
		{
			for(int j=0;j<v;j++)
			{
				if(i==j)
				{
					matrix[i][j]=0;
				}
				else
				{
					matrix[i][j]=Double.MAX_VALUE;
				}
			}
		}
	}
	public void addEdge(int u,int v,double weight)
	{
		matrix[u][v]=matrix[v][u]=weight;
	}
	public int min(int i,int j)
	{
		if(i<j) return i;
		else return j;
	}
	public int max(int i,int j)
	{
		if(i>j) return i;
		else return j;
	}
}
class AllPairs
{
	Graph g;
	int []path =new int[g.v];
	public double min(double a,double b)
	{
		if(a<b) return a;
		else return b;
	}
	public void ShortestPath(Graph g,int v)
	{
		for(int k=0;k<v;k++)
		{
			for(int i=0;i<v;i++)
			{
				for(int j=0;j<v;j++)
				{
					g.matrix[i][j]=min(g.matrix[i][j],g.matrix[i][k]+g.matrix[k][j]);
					if(g.matrix[i][k]+g.matrix[k][j]==g.matrix[i][j])
						path[j]=k;
				}
			}
		}
	}
}
public class Solution {
	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int vertices = Integer.parseInt(sc.nextLine());
		int edges=Integer.parseInt(sc.nextLine());
		Graph gp = new Graph(vertices);
		for(int i=0;i<edges;i++)
		{
			String line1 = sc.nextLine();
			String []uvw = line1.split(" ");
			int u=Integer.parseInt(uvw[0]),v=Integer.parseInt(uvw[1]);
			float w = Float.parseFloat(uvw[2]);
			gp.addEdge(u, v, w);
		}
		String caseToGo=sc.nextLine();
		//String  = null;
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			//10 vertices 11 edges
			DecimalFormat df = new DecimalFormat("0.00000");
			System.out.println(vertices+" vertices "+edges+" edges");
			for(int i=0;i<gp.v;i++)
			{
				//0: 0-7 221.00000  0-4 78.00000
				System.out.print(i+": ");
				for(int j=gp.v-1;j>=0;j--)
				{
					if(gp.matrix[i][j]<Float.MAX_VALUE && gp.matrix[i][j]!=0)
					{
						System.out.print(i+"-"+j+" "+df.format(gp.matrix[i][j])+" ");
					}
				}
				System.out.println();
			}
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			AllPairs ap =new AllPairs();
			ap.ShortestPath(gp, gp.v);
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}

}