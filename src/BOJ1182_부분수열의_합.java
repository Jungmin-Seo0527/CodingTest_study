import java.io.*;
import java.util.*;

public class BOJ1182_부분수열의_합
{
	private static int num, sum, cnt;
	private static int[] arr;
	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("start");
		BufferedReader br=new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st=new StringTokenizer (br.readLine ( ));
		num=Integer.parseInt (st.nextToken ( ));
		sum=Integer.parseInt (st.nextToken ( ));
		arr=new int[num];
		
		st=new StringTokenizer (br.readLine ( ));
		for(int i=0;i<num;i++)
		{
			arr[i]=Integer.parseInt (st.nextToken ( ));
		}
		
		for(int i=0;i<num;i++)
		{
			doDFS(0, i, arr[i]);
		}
		System.out.println (cnt);
		//// end main
	}
	
	public static void doDFS(int _idx, int _start, int _sum)
	{
		//System.out.println (_sum);
		if(sum==_sum)cnt++;
		if(_idx==num) return;
		for(int i= _start+1;i<num;i++)
		{
			doDFS(_idx+1, i, _sum+arr[i]);
		}
	}
	//// end class
}