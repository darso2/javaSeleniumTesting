import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PersonTest {

	Person testing = new Person("",0,"none");
	Author testing2 = new Author();
	
	@Ignore
	public void failTest(){
	fail("Not yet implemented");
	}
	
	@After
	public void tearDown(){
	testing2=null;
	}
	
	@Before 
	public void setUp(){
		 testing.setAge(23);
		 testing.setJobTitle("Homeless");
		 
	}
	@Test
	public void test1() {
		assertEquals(23,testing.getAge());
	//	assertNull(testing.getName()); 
		assertEquals("Homeless",testing.getJobTitle());
	}

	@Test
	public void test2(){
		
		testing2.setName("Jeff");
		assertNotNull(testing2.getName());
	}
	
	@Test
	public void test3(){
		assertNull(testing2.getName());
	}
	
	@Test
	public void test4(){
		 Object expected="Name:  Age: 23 JobTitle: Homeless"; 
		assertEquals(expected, testing.personContents());
	}
}