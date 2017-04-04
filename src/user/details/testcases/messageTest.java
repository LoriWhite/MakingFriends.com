package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import user.details.message;

public class messageTest {

	@Test
	public void checkMessageTest() 
	{
		message m = new message();
		
		assertTrue(m.checkMessage("Hi how are you?"));
		assertFalse(m.checkMessage(""));
		assertFalse(m.checkMessage("        "));
	}

}
