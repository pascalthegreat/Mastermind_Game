import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner in=new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter your choice: ");
        System.out.println("1) Codemaker vs codebreaker ");
        System.out.println("2) Computer-based codemaker and human codebreaker ");
        System.out.println("3) Computer-based codemaker and one computer-based codebreaker ");
        System.out.println("4) Exit game");

        System.out.println("Enter your choice: ");
        int choice = in.nextInt();
        while (true){
        if(choice == 1){
            humanvshuman();
        }else if(choice == 2){
            computervshuman();
        }else if(choice == 3){
            computervscomputer();
        }else if(choice == 4){
            System.exit(0);
        }else {
            System.out.println("Enter the correct option.");
        }}


    }

    public static void humanvshuman(){
        System.out.println("Select from the colors from the list below:");
        MasterMind masterMind = new MasterMind();
        char color[] = masterMind.getColor();
        System.out.print("{");
        for(int i=0;i<color.length;i++) {
            System.out.print(color[i]+",");
        }
        System.out.println("}");
        System.out.println("Code maker please enter the code without any duplicates: ");
        String code = in.next();
        System.out.println("Enter Number of guesses allowed: ");
        int g=in.nextInt();
        while (g==0 || g<0){
            System.out.println("Please Enter Number of guesses allowed again more than zero:");
            g = in.nextInt();
        }

        Scanner sc=new Scanner(System.in);
        //   MasterMind masterMind = new MasterMind(r,n,g);

        masterMind.matchresultsforhumancoder(code,g);

        do {

            System.out.println("\nDo you want to play again? Press Y for Yes");

            if(sc.next().equalsIgnoreCase("y")) {
                masterMind.matchresultsforhumancoder(code,g);
            }
            else {
                System.out.println("Game Ended");
                break;
            }

        }while(true);

    }
    public static void computervshuman(){
        System.out.println("Mastermind Game");
        System.out.println("Enter Color range(3-8): ");
        int r=in.nextInt();
        while (r>8 || r<3){
            System.out.println("Please Enter range(6-10) again:");
            r = in.nextInt();
        }
        System.out.println("Number of Code in Color(3-4): ");
        int n=in.nextInt();

        while (n>4 || n<3){
            System.out.println("Please Enter Number of Code in Color(3-4) again:");
            n = in.nextInt();
        }
        System.out.println("Enter Number of guesses allowed: ");
        int g=in.nextInt();
        while (g==0 || g<0){
            System.out.println("Please Enter Number of guesses allowed again more than zero:");
            g = in.nextInt();
        }


        Scanner sc=new Scanner(System.in);
        MasterMind masterMind = new MasterMind(r,n,g);

        masterMind.matchResults();

        do {

            System.out.println("\nDo you want to play again? Press Y for Yes");

            if(sc.next().equalsIgnoreCase("y")) {
                masterMind.matchResults();
            }
            else {
                System.out.println("Game Ended");
                break;
            }

        }while(true);
    }

    public static void computervscomputer(){
        System.out.println("Enter information for the computer to make code");
        System.out.println("Enter Color range(3-8): ");
        int r=in.nextInt();
        while (r>8 || r<3){
            System.out.println("Please Enter range(6-10) again:");
            r = in.nextInt();
        }
        System.out.println("Number of Code in Color(3-4): ");
        int n=in.nextInt();

        while (n>4 || n<3){
            System.out.println("Please Enter Number of Code in Color(3-4) again:");
            n = in.nextInt();
        }
        System.out.println("Enter Number of guesses allowed: ");
        int g=in.nextInt();
        while (g==0 || g<0){
            System.out.println("Please Enter Number of guesses allowed again more than zero:");
            g = in.nextInt();
        }

        Scanner sc=new Scanner(System.in);
        MasterMind masterMind = new MasterMind(r,n,g);
        masterMind.generateCode();
        char color[] =  masterMind.getGetColors();
        String string = new String(color);
       // System.out.println(string);
        allpossibilities.clear();
        codeBreaker(string,"");

        masterMind.computervscomputer();

        do {

            System.out.println("\nDo you want to play again? Press Y for Yes");

            if(sc.next().equalsIgnoreCase("y")) {
                masterMind.computervscomputer();
            }
            else {
                System.out.println("Game Ended");
                break;
            }

        }while(true);

    }

    static ArrayList<String> allpossibilities = new ArrayList<>();
    static void codeBreaker(String code, String possiblecode)
    {
        if (code.length() == 0) {
            allpossibilities.add(possiblecode);
           // System.out.print(possiblecode + " ");
            return;
        }
        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);
            String ros = code.substring(0, i) + code.substring(i + 1);
            codeBreaker(ros, possiblecode + ch);
        }
    }

}