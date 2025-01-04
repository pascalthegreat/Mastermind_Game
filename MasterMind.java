import java.util.Random;
import java.util.Scanner;

public class MasterMind {

    int range=0;
    int num;
    int guessNo=0;
    int wins=0;
    int computerWins=0;

    MasterMind(int r,int n,int g){
        this.guessNo=g;
        this.range=r;
        this.num=n;
    }
    MasterMind(){

    }
    private char color[] = {'P', 'G', 'B', 'R', 'O', 'Y','S','W','L','T'};
    private char[] getColors=null;

    void generateCode() {
        char[] getColors = new char[num];
        Random random = new Random();

        for (int i = 0; i < getColors.length; i++) {

            char temp = color[random.nextInt(range)];
            boolean b = false;
            for (int j = 0; j < getColors.length; j++) {
                if (temp == getColors[j]) {
                    b = true;
                }
            }
            if (!b) {
                getColors[i] = temp;
            } else {
                i--;
            }

        }

        this.getColors=getColors;
    }

    void matchResults() {

        System.out.println("Color Range is: ");
        System.out.print("{ ");
        for(int i=0;i<range;i++) {
            System.out.print(color[i]+",");
        }
        System.out.println("}");
            generateCode();
        int no=guessNo;

        loop:do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Guess Remaining: "+no);
            System.out.println("Enter your Guess in "+ num +" characters");
            String input = sc.nextLine();

            while (input.length() != num) {
                System.out.println("Input should be of "+ num + "characters. Enter again");
                input = sc.nextLine();
            }

            char[] userEntered = input.toUpperCase().toCharArray();

            String str=new String();
            int a=0;

            for (int i = 0; i < getColors.length; i++) {
                for (int j = 0; j < getColors.length; j++) {
                    if (userEntered[i] == getColors[j] && i!=j) {
                        str=str+"⚪";
                    }
                }
                if (userEntered[i] == getColors[i]) {
                    str="⚫"+str;
                }

                else {str = str+" ";}
            }

            if(str.length()!=num) {
//                str=str.substring(0, num);
                str.trim();
            }

            System.out.println(str);
            no-=1;

            if(input.equalsIgnoreCase(String.valueOf(getColors))) {
                System.out.println("Congratulations!!!!!!");
                System.out.println("\n**Win**");
                wins++;
                System.out.println("Score is: "+ (range+num+no));
                System.out.println("Player vs Computer Score: "+ wins+ "-"+ computerWins);
                break loop;
            }
            else if(no==0) {
                System.out.println("You have Lost the game");
                System.out.println("Code was: "+ String.valueOf(getColors));
                computerWins++;
                System.out.println("Player vs Computer Score: "+ wins+ "-"+ computerWins);
            }

        }while(no!=0);


    }

    public char[] getColor() {
        return color;
    }

    public void setColor(char[] color) {
        this.color = color;
    }

    public char[] getGetColors() {
        return getColors;
    }

    public void setGetColors(char[] getColors) {
        this.getColors = getColors;
    }

    public void matchresultsforhumancoder(String code,int noofguess){

        System.out.println("Color Range is: ");
        System.out.print("{ ");
        for(int i=0;i<range;i++) {
            System.out.print(color[i]+",");
        }
        System.out.println("}");

        char[] ch = new char[code.length()];
        for (int i = 0; i < code.length(); i++) {
            ch[i] = code.charAt(i);
        }
        this.getColors=ch;
        guessNo=noofguess;
        int no=guessNo;
        num=code.length();

        loop:do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Guess Remaining: "+no);
            System.out.println("Enter your Guess in "+ num +" characters");
            String input = sc.nextLine();

            while (input.length() != num) {
                System.out.println("Input should be of "+ num + "characters. Enter again");
                input = sc.nextLine();
            }

            char[] userEntered = input.toUpperCase().toCharArray();

            String str=new String();
            int a=0;

            for (int i = 0; i < getColors.length; i++) {
                for (int j = 0; j < getColors.length; j++) {
                    if (userEntered[i] == getColors[j] && i!=j) {
                        str=str+"⚪";
                    }
                }
                if (userEntered[i] == getColors[i]) {
                    str="⚫"+str;
                }

                else {str = str+" ";}
            }

            if(str.length()!=num) {
//                str=str.substring(0, num);
                str.trim();
            }

            System.out.println(str);
            no-=1;

            if(input.equalsIgnoreCase(String.valueOf(getColors))) {
                System.out.println("Congratulations!!!!!!");
                System.out.println("\n**Win**");
                wins++;
                System.out.println("Score is: "+ (range+num+no));
                System.out.println("Player vs Computer Score: "+ wins+ "-"+ computerWins);
                break loop;
            }
           else if(no==0) {
                System.out.println("You have Lost the game");
                System.out.println("Code was: "+ String.valueOf(getColors));
                computerWins++;
                System.out.println("Coder breaker vs Code maker: "+ wins+ "-"+ computerWins);
            }

        }while(no!=0);
    }


    public void computervscomputer(){
        int possibility=0;

        System.out.println("Color Range is: ");
        System.out.print("{ ");
        for(int i=0;i<range;i++) {
            System.out.print(color[i]+",");
        }
        System.out.println("}");
        int no=guessNo;
        String input = null;
        loop:do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Guess Remaining: "+no);
            System.out.println("Enter your Guess in "+ num +" characters");
            try {
                 input = Main.allpossibilities.get(possibility);
                 System.out.println( Main.allpossibilities.get(possibility));
            }catch (IndexOutOfBoundsException e){
                System.out.println("Your computer broke down");
            }

            while (input.length() != num) {
                System.out.println("Input should be of "+ num + "characters. Enter again");
                input = sc.nextLine();
            }

            char[] userEntered = input.toUpperCase().toCharArray();

            String str=new String();
            int a=0;

            for (int i = 0; i < getColors.length; i++) {
                for (int j = 0; j < getColors.length; j++) {
                    if (userEntered[i] == getColors[j] && i!=j) {
                        str=str+"⚪";
                    }
                }
                if (userEntered[i] == getColors[i]) {
                    str="⚫"+str;
                }

                else {str = str+" ";}
            }

            if(str.length()!=num) {
//                str=str.substring(0, num);
                str.trim();
            }
input= same.transform(23)
        change.system(43)
                alteridentity= println(str)
            if state == null then input (alteridentity)
                    else
                        undo layout () -> def
                    input - output = state


            }
            System.out.println(str);
            no-=1;

            if(input.equalsIgnoreCase(String.valueOf(getColors))) {
                System.out.println("Congratulations!!!!!!");
                System.out.println("\n**Win**");
                wins++;
                System.out.println("Score is: "+ (range+num+no));
                System.out.println("Computer codebreaker vs Computer codemaker:: "+ wins+ "-"+ computerWins);
                break loop;
            }
            else if(no==0) {
                System.out.println("You have Lost the game");
                System.out.println("Code was: "+ String.valueOf(getColors));
                computerWins++;
                System.out.println("Computer codebreaker vs Computer codemaker: "+ wins+ "-"+ computerWins);
            }
            possibility++;

        }while(no!=0);

    }
}