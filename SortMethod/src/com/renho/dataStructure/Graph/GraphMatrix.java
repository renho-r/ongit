/**   
* @Title: GraphMatrix.java 
* @Package com.renho.dataStructure.Graph 
* @Description: TODO
* @author renho   
* @date 2013年8月29日 下午12:25:50 
* @version V1.0   
*/
package com.renho.dataStructure.Graph;

public class GraphMatrix {
	public static final int MaxNum = 20;
	public static final int MaxValue = 65535;
	private char[] Vertex = new char[MaxNum];
	private int GType;
	private int VertexNum;
	private int EdgeNum;
	private int[][] EdgeWeight = new int[MaxNum][MaxNum];
	private int[] isTrav = new int[MaxNum];
	
	public void CreateGraph(GraphMatrix GM) {
		int i,j,k;
		int weight;
		char EstartV, EendV;
	}
}

