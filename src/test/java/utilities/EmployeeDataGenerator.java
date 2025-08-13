package utilities;

import java.util.concurrent.TimeUnit;

import net.datafaker.Faker;

public class EmployeeDataGenerator {
   
    String firstname;
    String middlename;
    String lastname;
    String username;
    String password;
    String date;
    private static EmployeeDataGenerator instance;


    EmployeeDataGenerator(){
        Faker faker = new Faker();
        firstname = faker.name().firstName();
        middlename = faker.name().maleFirstName();
        lastname = faker.name().lastName();
        password = faker.internet().password(8, 9, true, false, true);
        username = faker.internet().username();
        date = faker.timeAndDate().future(2,TimeUnit.DAYS,"yyyy-MM-dd");
    }

    public static EmployeeDataGenerator getInstance() {
        if (instance == null) {
            instance = new EmployeeDataGenerator();
        }
        return instance;
    }
    public EmployeeDataGenerator getNewInstance() {
            instance = new EmployeeDataGenerator();
        return instance;
    }

    public String getFirstname(){
        return firstname;
    }
    public String getMiddlename(){
        return middlename;
    }
    public String getLastname(){
        return lastname;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getDate(){
        return date;
    }

}
