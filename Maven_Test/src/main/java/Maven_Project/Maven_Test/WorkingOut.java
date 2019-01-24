package Maven_Project.Maven_Test;

import java.util.Scanner;

public class WorkingOut 
{
	int yourDog = 0;
	int numberOfPlaces = 0;
	
	
	public int getInput(/*int yourDog, int numberOfPlaces*/)
	{		
		Scanner s = new Scanner(System.in);

		System.out.print("Enter your dogs place: ");
		yourDog = s.nextInt();

		System.out.print("How many places would you like to see?: ");
		numberOfPlaces = s.nextInt();
		s.close();
		return yourDog;
	}

	public void getOnomatopoeia(int j/*int yourDog, int numberOfPlaces*/) 
	{
		
		String place;
	
		for (int i = 1; i <= numberOfPlaces; i++)
		{

			int onomatopoeia = i % 10;

			if (i == 11 || i == 12 || i == 13) 
			{
				onomatopoeia = 4;
			}
		
			switch (onomatopoeia) 
			{
				case 1:
					place = (i + "st");
					break;
				case 2:
					place = (i + "nd");
					break;
				case 3:
					place = (i + "rd");
					break;
				default:
					place = (i + "th");
			}

			if (i == yourDog) 
			{
				if (yourDog % 10 == 0)
				{
					System.out.println("");
				}
				continue;
			}
		
			if (numberOfPlaces == i) 
			{
				System.out.print(place);
			} 
		
			else if (i % 10 == 0) 
			{
				System.out.println(place + ", ");
			} 
		
			else 
			{
				System.out.print(place + ", ");
			}
		}
	}
	

}
