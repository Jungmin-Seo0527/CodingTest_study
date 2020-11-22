package DynamicProgramming;

//import java.util.*;
import java.io.*;
//BOJ9251_LCS
public class BOJ9251_LCS
{
	private static char [ ] arr1;
	private static char [ ] arr2;
	private static int [ ] [ ] dp;
	private static int row, col;
	
	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		arr1=br.readLine ( ).toCharArray ( );
		arr2=br.readLine ( ).toCharArray ( );
		row=arr1.length;
		col=arr2.length;
		
		dp = new int [ row + 1 ] [ col + 1 ];
		solve ( );
		//show();
		System.out.println (dp [ row ] [ col ]);
		
	} //// end main
	
	private static void solve( )
	{
		for (int i = 1; i <= row; i++)
		{
			for (int j = 1; j <= col; j++)
			{
				if (arr1 [ i - 1 ] == arr2 [ j - 1 ])
				{
					dp [ i ] [ j ] = dp [ i - 1 ] [ j - 1 ] + 1;
				}
				else
				{
					dp [ i ] [ j ] = Math.max (dp [ i - 1 ] [ j ], dp [ i ] [ j - 1 ]);
				}
			}
		}
	}
	
} //// end class
