package app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class ContactManagerTest {
	private ContactManager contactManager = null;
	
	@BeforeAll
	void setUpBeforeClass() throws Exception {
		contactManager=new ContactManager();
	}
	
	@Test
	@DisplayName("Should Create Contact")
	public void createContactTest() {
		contactManager.addContact("Joe", "Kuruvilla", "0973123264");
		assertEquals("[Contact [firstName=Joe, lastName=Kuruvilla, phoneNumber=0973123264]]",contactManager.getAllContacts().toString());
	}
	
	@Test
	@DisplayName("Should Not Create Contact When First Name is Null")
	public void createContactFirstNameNotNullTest() {
		Throwable exception=assertThrows(RuntimeException.class,()->{
			contactManager.addContact("", "kuruvilla Joe","073123264");
		});
		assertEquals("First Name Cannot be null or empty",exception.getMessage());
	}

	@Test
	@DisplayName("Phone Number should start with 0")
	public void createContactPhoneNumberTest() {
		Throwable exception=assertThrows(RuntimeException.class,()->{
			contactManager.addContact("joe", "kuruvilla","9731232646");
		});
		assertEquals("Phone Number Should Start with 0",exception.getMessage());
	}

	@Test
	@Disabled
	@DisplayName("Test which is disabled")
	void disabledTest() {
	}
	
	@AfterAll
	void setUpAfterClass() throws Exception {
		contactManager=null;
	}

}
