package others;

public class _0_Main
{
	public static void main(String [ ] args)
	{
		int flag = 0;
		for (int i = 0; i < 3; i++)
		{
			System.out.println ("i: " + i);
			for (int j = 0; j < 4; j++)
			{
				System.out.println ("j: " + j);
				if (i == 1 && j == 1)
				{
					flag = 1;
					break;
				}
			}
			if (flag == 1) break;
		}
	}
}