package mywork.enhancements.ex4;

public class TestEnumAddresses {

	public static void main(String[] args) {
		Address a1 = new Address("123 Main Street", "Baltimore", "MD", "21215", "HOME");
		Address a2 = new Address("6401 Security Square Boulevard", "Woodlawn", "MD", "21756", "WORK");

		System.out.println(a1);
		System.out.println(a2);
	}

}
