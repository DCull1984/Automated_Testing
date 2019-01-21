package automated;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest 
{
	@Test
	public void testBlackJack() 
	{
		int result = Main.blackJack(21, 23);
		assertEquals(11, result);
		
	}
	
	@Test
	public void testBlackJack2() 
	{
		int result = Main.blackJack(10, 10);
		assertEquals(-1, result);
		
	}
	
	@Test
	public void testBlackJack3() 
	{
		int result = Main.blackJack(1, 21);
		assertEquals(21, result);
		
	}
	
	@Test
	public void testBlackJack4() 
	{
		//falls TIE loop
		int result = Main.blackJack(21, 21);
		assertEquals(0, result);
		
	}
}
