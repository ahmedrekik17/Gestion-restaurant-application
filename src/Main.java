import gestion_compte.authentification;
import gestion_compte.receipt;
import gestion_compte.recipe;
import gestion_compte.user;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        recipe[] menu={
                new recipe("Pasta","With seafood",new String[]{"sauce rosé","calamare","soumont"},25),
                new recipe("Pizza","Neptune",new String[]{"Cheese","Sauce","Thon"},19)
        };

        user[] users={
                new user("Ahmed", "Rekik", "ahmed@aaa.com", "123456789", 1234567890L,10),
                new user("Abderahmen", "bouzaienne", "abderahmen@bbb.com", "123456789", 2345678901L,10),

        };
        recipe[] ingredients={
             new recipe("onion",0.5),
                new recipe("pepper",0.8),
                new recipe("pasta",1.5)
        };
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\n==========*Menu*===========");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");
            int choice = s.nextInt();
            s.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("==========*Login*============");
                    System.out.println(" ");
                    System.out.println("Enter your email : ");
                    String Email = s.nextLine();
                    System.out.println("Enter your password : ");
                    String Password = s.nextLine();
                    authentification auth = new authentification(Email, Password);
                    if (auth.Login(Email,Password,users)==true){
                        for (int k=0;k< users.length;k++){
                            System.out.println("Login successful");
                            System.out.println("Welcome To DINER "+users[k].getFirstName()+" "+users[k].getLastName());
                            while (true) {
                                System.out.println("\n==========*DINER Restaurant*===========");
                                System.out.println("Hello welcome to our restaurant do you want to..");
                                System.out.println("1. Take our menu");
                                System.out.println("2. Create you own plat ");
                                System.out.print("Choose an option: ");
                                choice = s.nextInt();
                                s.nextLine();
                                switch (choice){
                                    case 1:
                                        for (int i=0;i< menu.length;i++){
                                            System.out.println("-------Dish "+(i+1)+"------------");
                                            System.out.println(
                                                    "Title: "+menu[i].getTitle()+
                                                            "\nDescription: "+menu[i].getDescription()+
                                                            "\nIngredients: "+menu[i].getIngredients()+
                                                            "\nPrice: "+menu[i].getPrice());
                                        }
                                        double total=0;
                                        System.out.println("-------------------------------");
                                        System.out.println("how many number of family");
                                        int nbFamily=s.nextInt();
                                        s.nextLine();

                                        for (int i=0;i<nbFamily;i++){
                                            boolean found=false;
                                            System.out.println(" which plate do you want: ");
                                            String dishName=s.nextLine().toLowerCase()  ;
                                            for (int j=0;j< menu.length;j++) {
                                                if (menu[j].getTitle().toLowerCase().equals(dishName)){
                                                    total=total+menu[j].getPrice();
                                                    found=true;
                                                    break;
                                                }
                                            }
                                            if (!found) {
                                                System.out.println("Dish not found Please try again.");
                                                System.out.println("---------------------------------");
                                                i--;
                                            }
                                        }
                                        receipt receipt1 = new receipt("Total Order", total, total);
                                        receipt receipt2 = new receipt("Total Order", total+7, total+7);

                                        System.out.println("---------------------------------");
                                        while (true){
                                            System.out.println("You want to..");
                                            System.out.println("1. Eat here");
                                            System.out.println("2. Take out ");
                                            System.out.print("Choose an option: ");
                                            choice = s.nextInt();
                                            s.nextLine();
                                            switch (choice){
                                                case 1:
                                                    Random random=new Random();
                                                    int randomTable=random.nextInt(20)+1;
                                                    System.out.println("Here is your receipt:");
                                                    System.out.println("================================");
                                                    System.out.println("|          Receipt              |");
                                                    System.out.println("================================");
                                                    System.out.println(receipt1.toString());
                                                    int randomScore=random.nextInt(11)+30;
                                                    users[k].setScore(users[k].getScore()+randomScore);
                                                    System.out.println("You earned "+randomScore+" points");
                                                    System.out.println("Thank you, Your table is "+randomTable);
                                                    System.out.println("================================");
                                                    if (users[k].getScore()>50){
                                                    System.out.println("Congratulations! Your score is: " + users[k].getScore());
                                                        System.out.println("You have 50% discount on your next purchased");
                                                    }
                                                    System.out.println("Goodbye");
                                                    return;
                                                case 2:
                                                    random=new Random();
                                                    System.out.println("Here is your receipt:");
                                                    System.out.println("================================");
                                                    System.out.println("|          Receipt              |");
                                                    System.out.println("================================");
                                                    System.out.println("Delivery costs:"+ 7);
                                                    System.out.println(receipt2.toString());
                                                    randomScore=random.nextInt(11)+30;
                                                    users[k].setScore(users[k].getScore()+randomScore);
                                                    System.out.println("You earned "+randomScore+" points");
                                                    System.out.println("================================");
                                                    if (users[k].getScore()>20){
                                                        System.out.println("Congratulations! Your score is: " + users[k].getScore());
                                                        System.out.println("You have 50% discount on your next purchased");}
                                                    System.out.println("Goodbye");
                                                    return;
                                            }
                                        }
                                    case 2:
                                        System.out.println("This the ingredients: ");
                                        for (int i=0;i<ingredients.length;i++){
                                            System.out.println(ingredients[i].getTitle());
                                            System.out.println("---------------------------");
                                        }
                                        System.out.println("Enter you dish name: ");
                                        String dishName=s.nextLine();
                                        System.out.println("How many ingredients do you need to use: ");
                                        int nbIngredients=s.nextInt();
                                        s.nextLine();
                                        double totalPrice=0;
                                        double dishPrice=0;
                                        System.out.println("-------------------------------");
                                        System.out.println("how many number of family");
                                        int nbofFamily=s.nextInt();
                                        s.nextLine();
                                        for (int j=0;j<nbIngredients;j++){
                                            System.out.println("Choose you ingredient name: ");
                                            String ingredientName=s.nextLine();
                                            boolean found=false;
                                            for (int l=0;l<ingredients.length;l++){
                                                if (ingredients[l].getTitle().toLowerCase().equals(ingredientName)){
                                                    dishPrice=dishPrice+ingredients[l].getPrice();
                                                    found=true;
                                                    break;
                                                }
                                            }
                                            if (!found) {
                                                System.out.println("Ingredient not found Please try again.");
                                                System.out.println("---------------------------------------");
                                                j--;
                                            }
                                        }

                                        receipt receipt11 = new receipt("Total Order", dishPrice+4.0, (totalPrice+dishPrice+4.0)*nbofFamily);
                                        receipt receipt22 = new receipt("Total Order", dishPrice+4.0, ((totalPrice*nbofFamily+dishPrice+4.0))+7.0);

                                        System.out.println("---------------------------------");
                                        while (true){
                                            System.out.println("You want to..");
                                            System.out.println("1. Eat here");
                                            System.out.println("2. Take out ");
                                            System.out.print("Choose an option: ");
                                            choice = s.nextInt();
                                            s.nextLine();
                                            switch (choice){
                                                case 1:
                                                    Random random=new Random();
                                                    int randomTable=random.nextInt(20)+1;
                                                    System.out.println("Here is your receipt:");
                                                    System.out.println("================================");
                                                    System.out.println("|          Receipt              |");
                                                    System.out.println("================================");
                                                    System.out.println(receipt11.toString());
                                                    int randomScore=random.nextInt(11)+30;
                                                    users[k].setScore(users[k].getScore()+randomScore);
                                                    System.out.println("You earned "+randomScore+" points");
                                                    System.out.println("Thank you, Your table is "+randomTable);
                                                    System.out.println("================================");
                                                    if (users[k].getScore()>50){
                                                        System.out.println("Congratulations! Your score is: " + users[k].getScore());
                                                        System.out.println("You have 50% discount on your next purchased");
                                                    }
                                                    System.out.println("Goodbye");
                                                    return;
                                                case 2:
                                                    random=new Random();
                                                    System.out.println("Here is your receipt:");
                                                    System.out.println("================================");
                                                    System.out.println("|          Receipt              |");
                                                    System.out.println("================================");
                                                    System.out.println("Delivery costs:"+ 7);
                                                    System.out.println(receipt22.toString());
                                                    randomScore=random.nextInt(11)+30;
                                                    users[k].setScore(users[k].getScore()+randomScore);
                                                    System.out.println("You earned "+randomScore+" points");
                                                    System.out.println("================================");
                                                    if (users[k].getScore()>20){
                                                        System.out.println("Congratulations! Your score is: " + users[k].getScore());
                                                        System.out.println("You have 50% discount on your next purchased");}
                                                    System.out.println("Goodbye");
                                                    return;
                                            }
                                        }
                                }
                            }
                        }
                        break;
                        }

                case 2:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice try again");
            }
        }
    }
}