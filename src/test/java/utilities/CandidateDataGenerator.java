package utilities;

import java.util.concurrent.TimeUnit;

import net.datafaker.Faker;

public class CandidateDataGenerator {
    
    String firstname;
    String middlename;
    String lastname;
    String vacancy;
    String email;
    String interviewtitle;
    String date;

    public CandidateDataGenerator(){
        Faker faker = new Faker();
        firstname = faker.name().firstName();
        middlename = faker.name().maleFirstName();
        lastname = faker.name().lastName();
        vacancy = faker.job().seniority() + faker.job().title();
        email = faker.internet().emailAddress();
        date = faker.timeAndDate().future(2,TimeUnit.DAYS,"yyyy-MM-dd");
        interviewtitle = vacancy + " Interview";
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
    public String getVacancy(){
        return vacancy;
    }
    public String getEmail(){
        return email;
    }
    public String getDate(){
        return date;
    }
    public String getInterviewTitle(){
        return interviewtitle;
    }

}
