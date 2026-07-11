package utility;

import com.github.javafaker.Faker;

public class RandomUtility {
	Faker fakevalue = new Faker();

	public String randomUserName() {
		return fakevalue.name().username();
	}

	public String randomPassword() {
		return fakevalue.internet().password();
	}

	public String randomMailId() {
		return fakevalue.internet().emailAddress();
	}

	public String fullName() {
		return fakevalue.name().fullName();
	}
	
	public String randomName() {
		return fakevalue.name().fullName();
		
	}
	
	public String randomAddress()
	{
		return fakevalue.address().fullAddress();
	}

	public String randomPhoneNo() {
		return fakevalue.phoneNumber().cellPhone();
	}
}
