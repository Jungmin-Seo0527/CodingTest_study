import java.io.*;
import java.util.*;

//1759_암호만들기
public class BOJ1759_암호만들기
{
	private static int num;
	private static int [ ] alpha = new int [ 26 ];
	private static char [ ] ret;

	public static void main(String [ ] args) throws IOException
	{
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer (br.readLine ( ));
		num = Integer.parseInt (st.nextToken ( ));
		ret = new char [ num ];
		int lp = Integer.parseInt (st.nextToken ( ));

		st = new StringTokenizer (br.readLine ( )); // atcisw
		for (int i = 0; i < lp; i++)
		{
			String str = st.nextToken ( ); //a
			char al = str.charAt (0);
			alpha [ (int) al - 'a' ]++;
		}
		doDFS (0, 0, 0, -1);
		//// end main
	}

	private static void doDFS(int _idx, int _mo, int _ja, int _over)
	{
		if (_idx < 0 || _idx > num) return;
		if (_idx == num)
		{
			if (_mo >= 1 && _ja >= 2)
			{
				String retSt = new String (ret);
				System.out.println (retSt);
			}
			return;
		}
		for (int i = _over + 1; i < 26; i++)
		{
			if (alpha [ i ] == 1)
			{
				ret [ _idx ] = (char) (i + 'a');
				alpha [ i ]++;
				switch ((char) i + 'a')
				{
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					doDFS (_idx + 1, _mo + 1, _ja, i);
					break;

				default:
					doDFS (_idx + 1, _mo, _ja + 1, i);
					break;
				}
				alpha [ i ]--;

			}
		}
	}
	//// end class
}