/**
 * 
 */
package user.details;
import user.details.validate;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author sai shanmukhi
 *
 */
public class validatetest {

	@Test
		public void testValidate() 
	    {
			validate h1 = new validate();
			assertEquals(true,h1.validateEmail("xyz123@gmail.com"));
	        /*assertTrue(h1.validateemail("xyz123@uncc.edu"));
	        assertFalse("has a non letter and non number in the email", h1.validateemail("xyz!123@uncc.edu"));
	        assertFalse("doesn't contain @", h1.validateemail("xyz123uncc.edu"));
	        assertFalse("doesn't contain @uncc.edu", h1.validateemail("xyz123@gmail.com"));
	        assertFalse("is null", h1.validateemail(""));*/
	    }

}
