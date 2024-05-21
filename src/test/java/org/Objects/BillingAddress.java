package org.Objects;

public class BillingAddress {

	private String firstName;
	private String lastName;
	private String StreetAddress01;
	private String StreetAddress02;
	private String town;
	private String zipCode;
	private String emailID;
	private String Country;
	private String State;

	public BillingAddress(String firstName, String lastName, String StreetAddress01, String StreetAddress02,
			String town, String zipCode, String emailID) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.StreetAddress01 = StreetAddress01;
		this.StreetAddress02 = StreetAddress02;
		this.town = town;
		this.zipCode = zipCode;
		this.emailID = emailID;
		

	}

	public BillingAddress() {
	}

	public String getFirstName() {
		return firstName;
	}

	public BillingAddress setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public BillingAddress setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getStreetAddress01() {
		return StreetAddress01;
	}

	public BillingAddress setStreetAddress01(String streetAddress01) {
		StreetAddress01 = streetAddress01;
		return this;
	}

	public String getStreetAddress02() {
		return StreetAddress02;
	}

	public BillingAddress setStreetAddress02(String streetAddress02) {
		StreetAddress02 = streetAddress02;
		return this;
	}

	public String getTown() {
		return town;
	}

	public BillingAddress setTown(String town) {
		this.town = town;
		return this;
	}

	public String getZipCode() {
		return zipCode;
	}

	public BillingAddress setZipCode(String zipCode) {
		this.zipCode = zipCode;
		return this;
	}

	public String getEmailID() {
		return emailID;
	}

	public BillingAddress setEmailID(String emailID) {
		this.emailID = emailID;
		return this;
	}
	public String getCountry() {
		return Country;
	}

	public BillingAddress setCountry(String country) {
		this.Country = country;
		return this;
	}

	public String getState() {
		return State;
	}

	public BillingAddress setState(String state) {
		this.State = state;
		return this;
	}

}
