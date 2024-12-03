package gestion_compte;

public class user {



    private String firstName;
    private String lastName;

    private String Email;
    private String Password;
    private long telNumber;
    private int score;



    public user(String firstName,String lastName, String Email, String Password , long telNumber,int score){
        this.firstName=firstName;
        this.lastName=lastName;
        this.Email=Email;
        this.Password=Password;
        this.telNumber=telNumber;
        this.score=score;
    }

    public user(String Email, String Password){

        this.Email=Email;
        this.Password=Password;

    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public long getTelNumber() {
        return telNumber;
    }

    public int getScore() {
        return score;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setScore(int score) {
        this.score = score;
    }
}