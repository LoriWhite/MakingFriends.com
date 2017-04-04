/**
 * 
 */
package user.details.testcases;
import user.details.validate;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author sai shanmukhi
 *
 */
public class validatetest {

	@Test
		public void emailTest() 
	    {
			validate h1 = new validate();
			
	        assertTrue(h1.validateEmail("xyz123@uncc.edu"));
	        assertFalse("has a non letter and non number in the email", h1.validateEmail("xyz!123@uncc.edu"));
	        assertFalse("doesn't contain @", h1.validateEmail("xyz123uncc.edu"));
	        assertFalse("doesn't contain @uncc.edu", h1.validateEmail("xyz123@gmail.com"));
	        assertFalse("is null", h1.validateEmail(""));
	    }
	@Test
	public void usernameTest() 
    {
		validate h1 = new validate();
        assertTrue("Username already exists",h1.validateusername("shanmukhi"));
        assertFalse("Username Does not exist", h1.validateusername("loriwhite"));
        assertFalse("Username Does not exist", h1.validateusername("saisusheel"));
    }
	@Test
	public void passwordTest() 
    {
		validate h1 = new validate();
		assertTrue(h1.validatePassword("root@123"));
		assertFalse("doesn't have at least one non letter characters except spaces",h1.validatePassword("root123"));
		assertFalse("doesn't have at least one letter character", h1.validatePassword("@1237853"));
		assertFalse("doesn't have at least one number", h1.validatePassword("@lwhite"));
		assertFalse("has at least one space", h1.validatePassword("root @123"));
		assertFalse("has less than seven characters", h1.validatePassword("k@123"));
		assertFalse("has more than twelve characters", h1.validatePassword("root@12378535"));
		assertFalse("is null", h1.validatePassword(""));
    }
	@Test
	public void dobTest() 
    {
		validate h1 = new validate();
		assertTrue(h1.validateBirthDate("01/24/1995"));
		assertFalse("not in dob format", h1.validateBirthDate("64456165"));
		assertFalse("month is not in the right format", h1.validateBirthDate("555/25/1987"));
		assertFalse("year is not in the right format", h1.validateBirthDate("01/24/19999"));
		assertFalse("month is out of range", h1.validateBirthDate("15/24/1995"));
		assertFalse("day is out of range", h1.validateBirthDate("01/32/1995"));
		assertFalse("year is out of range", h1.validateBirthDate("01/24/1800"));
		assertFalse("is null", h1.validateBirthDate(""));
    }
}


