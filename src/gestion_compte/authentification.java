package gestion_compte;

public class authentification extends user {
    public authentification(String Email, String Password ){
        super(Email, Password);
    }




    public authentification(String firstName, String lastName, String email, String password, long telNumber,int score) {
        super(firstName, lastName, email, password, telNumber,score);
    }

    public boolean Login(String Email,String Password,user[] users){

        for (user user : users) {
            if (user.getEmail().equals(Email)&&user.getPassword().equals(Password)) {
                return true;
            }
        }

        System.out.println("login failed");
        return false;
    }

    }
