package user.details.testcases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import user.details.matchuser;
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
	
	/*public void recipientCheckTest()
	{
		message m = new message();
		matchuser n = Mockito.mock(matchuser.class);
		when(n.getUser("")).thenReturn();
		
		
		
	}*/

}
