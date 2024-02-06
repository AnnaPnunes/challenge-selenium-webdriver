package br.com.anapaula.automation.test.datamass;


public class DataMassUserForm {
    private String email;
    private Boolean title;  // true for Mr, false for Mrs

    private String firstName;
    private String lastName;
    private String password;

    private Integer day;
    private Month month;
    private Integer year;

    private Boolean newsletter; // true for yes, false for no

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getTitle() {
        return title;
    }

    public void setTitle(Boolean title) {
        this.title = title;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Boolean getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Boolean newsletter) {
        this.newsletter = newsletter;
    }

    public DataMassUserForm(String email, Boolean title, String firstName, String lastName, String password, Integer day, Month month, Integer year, Boolean newsletter) {
        this.email = email;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.day = day;
        this.month = month;
        this.year = year;
        this.newsletter = newsletter;
    }

    public static DataMassUserForm generateDataMass() {
        String mail = "ana" + "-" + RandomGenerator.generateRandomString(5, 10) + "@" + RandomGenerator.generateRandomString(5, 10) + ".com";
        return new DataMassUserForm(mail, true, "Ana", "Paula", "123456", 1, Month.JANUARY, 2000, true);
    }
}
