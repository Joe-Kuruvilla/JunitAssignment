package app;

public class Main {
	public static void main(String args[])
	{
		ContactManager contactManager=new ContactManager();
		contactManager.addContact("Joe", "Kuruvilla", "0973123264");
		System.out.println(contactManager.getAllContacts());
	}
}
