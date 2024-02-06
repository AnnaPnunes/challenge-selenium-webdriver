package br.com.anapaula.automation.test.datamass;

public class DataMassAddressForm {
    private String firstName;
    private String lastName;

    private String company;

    private String address;

    private String addressLine2;

    private String city;

    private States state;

    private String postalCode;

    private final String country = "United States";

    private String homePhone;

    private String mobilePhone;

    private String additionalInfo;

    private String alias;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public static DataMassAddressForm generateDataMass() {
        DataMassAddressForm dataMassAddressForm = new DataMassAddressForm();
        dataMassAddressForm.setFirstName(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        dataMassAddressForm.setLastName(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        dataMassAddressForm.setCompany(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        dataMassAddressForm.setAddress(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        dataMassAddressForm.setAddressLine2(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        dataMassAddressForm.setCity(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        dataMassAddressForm.setState(States.ALASKA);
        dataMassAddressForm.setPostalCode("35004");
        dataMassAddressForm.setHomePhone("41513604");
        dataMassAddressForm.setMobilePhone("995856565");
        dataMassAddressForm.setAdditionalInfo(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        dataMassAddressForm.setAlias(RandomGenerator.generateRandomStringWithoutNumbers(5, 10));
        return dataMassAddressForm;
    }
}
