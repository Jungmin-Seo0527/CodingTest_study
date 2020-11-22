import java.io.*;
import java.util.*;

public class BOJ15656_N°úM_7
{
	private static int num, end;
	//private static ArrayList<Integer> arr = new ArrayList<Integer> ( );
	//private static ArrayList<Integer> ret = new ArrayList<Integer> ( );
	private static int [ ] ret;
	private static int [ ] arr;
	//private static BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (System.out));
	private static StringBuilder sb = new StringBuilder ( );

	public static void main(String [ ] args) throws IOException
	{
		//System.out.println ("st");
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		end = Integer.parseInt (st.nextToken ( ));

		st = new StringTokenizer (br.readLine ( ));
		ret = new int [ end ];
		arr = new int [ num ];
		int id = 0;
		while (st.hasMoreTokens ( ))
		{
			//arr.add (Integer.parseInt (st.nextToken ( )));
			arr [ id++ ] = Integer.parseInt (st.nextToken ( ));

		}

		Arrays.sort (arr);
		//Collections.sort(arr);

		for (int i = 0; i < num; i++)
		{
			//doDFS(0, arr.get(i));
			doDFS (0, arr [ i ]);
		}
		//bw.flush();
		//bw.close ( );
		//bw.close ( );
		System.out.println (sb.toString ( ));
		br.close ( );

		//// end main
	}

	public static void doDFS(int _idx, int _num) throws IOException
	{
		//ret.add(_idx, _num);
		ret [ _idx ] = _num;
		if (_idx == end - 1)
		{
			for (int i = 0; i < end; i++)
			{
				//bw.write(ret.get(i)+" ");
				//sb.append(ret.get(i)).append(" ");
				sb.append (ret [ i ]).append (" ");
				//bw.write(ret[i]+" ");
			}
			//bw.write("\n");
			sb.append ("\n");
			return;
		}

		for (int i = 0; i < num; i++)
		{
			//doDFS(_idx+1, arr.get(i));
			doDFS (_idx + 1, arr [ i ]);
		}
	}

	//// end class
}