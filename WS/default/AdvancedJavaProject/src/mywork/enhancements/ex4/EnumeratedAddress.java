package mywork.enhancements.ex4;

public enum EnumeratedAddress {
	HOME("Home"), WORK("Work");
	
	private String addressType;
	
	EnumeratedAddress(String addressType) { this.addressType = addressType; }
	
	public String getAddressType() { return addressType; }
}
