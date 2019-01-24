package automated;

public class Main {
	
		public static void main(String[] args) 
		{
			System.out.println(blackJack(20, 20));
		}

		public static int blackJack(int a, int b)
		{
			
			if (a > b)
			{
				if (a >= 22)
				{
					return b;
				}
				return a;
			}
			
			else if (a < b)
			{
				if (b >= 22)
				{
					return a;
				}
				return b;
			}
			
			else if  (a >= 21 && b >= 21)
			{
				return 0;
			}
			
			else
			{
				return -1;
			}
					
	}
}