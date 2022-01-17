package com.mischa;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //Initialize global variables
    static String name; //User's name

    //Create a scanner that can take user input
    static Scanner input = new Scanner(System.in);

    //Clears the console by 50 lines
    public static void clearScreen() {
        for(int i = 0; i < 50; i++) {
            System.out.println("");
        }
    }

    //Waits x ms (1000 = 1 second)
    //Method taken from: https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    //Welcomes the user
    public static int welcomeScreen() {
        boolean incorrectInput = true;
        while (incorrectInput) {
            System.out.println("Welcome to a survey on nuclear energy generation in Alberta!");
            System.out.println("\nThe purpose of this survey is to allow you to get a general understanding of whether or not you agree with nuclear energy generation in Alberta.");
            System.out.println("I’ll ask you a series of questions that, in some way or another, connect to nuclear energy generation.");
            System.out.println("Once I’ve collected all of your answers, I’ll calculate what I believe your true opinion on the topic is.");
            System.out.println("\nEnter an input to begin:");
            System.out.println("\n1 - Get started");
            System.out.println("2 - Learn more about nuclear energy generation in Alberta");
            String welcomeInput = input.nextLine();
            switch (welcomeInput) {
                case "1":
                    incorrectInput = false;
                    break;
                case "2":
                    clearScreen();
                    System.out.println("I appreciate your curiosity!\n\nHere's a little background information:\n");
                    System.out.println("In April of 2021, Alberta formally signed a memorandum of understanding with Ontario, Saskatchewan,");
                    System.out.println("and New Brunswick to explore the development of Small Modular Nuclear Reactors (SMRs).");
                    System.out.println("The purpose of this survey is to gauge your opinion surrounding the topic of nuclear energy development in Alberta.");
                    System.out.println("\nNow that you know a little more, press enter to get started.");
                    input.nextLine();
                    incorrectInput = false;
                    break;
                default:
                    clearScreen();
                    System.out.println("You have entered an incorrect input! Please try again.");
                    incorrectInput = true;
                    break;
            }
        }
        clearScreen();
        System.out.println("Before we begin, why don't you introduce yourself?\n\nHello, my name is: ");
        name = input.nextLine();
        clearScreen();
        System.out.println("Welcome, " + name + "! It's great to meet you.\n\nWhat's your current stance on nuclear energy generation in Alberta?\nNote: this will have no effect on the final outcome of your answer.\n");
        System.out.println("1 - I strongly disagree with nuclear power generation in Alberta");
        System.out.println("2 - I somewhat disagree with nuclear power generation in Alberta");
        System.out.println("3 - I neither agree nor disagree with nuclear power generation in Alberta");
        System.out.println("4 - I somewhat agree with nuclear power generation in Alberta");
        System.out.println("5 - I strongly agree with nuclear power generation in Alberta");
        String initialOpinionString = input.nextLine();
        int initialOpinion = Integer.parseInt(initialOpinionString);
        clearScreen();
        System.out.println("That’s good to know! I’ll keep this in mind and we can see how it compares with what I come up with.");
        System.out.println("\nReady to give it a try? Press enter to start the quiz.");
        input.nextLine();
        clearScreen();
        System.out.println("Remember, try your best to answer as truthfully as possible so my calculations are as accurate as they can be.");
        wait(5000);
        clearScreen();
        return initialOpinion;
    }

    public static ArrayList<Double> questions() {
        ArrayList<Double> userResponses = new ArrayList<Double>();
        int i = 1;
        while (i <= 10) { //Increments through 10 questions
            System.out.println("\nQuestion " + i + ":\n");
            switch (i) {
                case 1:
                    System.out.println("No matter the cost, Alberta should increase its efforts in reducing greenhouse gas emissions.");
                    userResponses.add(agreeDisagree());
                    i++;
                    break;
                case 2:
                    System.out.println("If not reduced, the effects of greenhouse gas emissions will be detrimental to the earth.");
                    userResponses.add(agreeDisagree());
                    i++;
                    break;
                case 3:
                    System.out.println("CO2 (carbon dioxide) emissions are worse for the environment when compared with Nuclear waste.");
                    userResponses.add(agreeDisagree());
                    i++;
                    break;
                case 4: //Custom
                    System.out.println("In your opinion, the largest greenhouse gas emitting sector in Alberta is:");
                    userResponses.add(customSector());
                    i++;
                    break;
                case 5:
                    System.out.println("How concerned are you with nuclear disasters (Chernobyl, Fukushima, Three Mile Island) happening again in the future?");
                    userResponses.add(concernedUnconcerned());
                    i++;
                    break;
                case 6:
                    System.out.println("Would you be comfortable with having a nuclear energy plant in the rural area of your city or town?");
                    userResponses.add(comfortableUncomfortable());
                    i++;
                    break;
                case 7:
                    System.out.println("Would you be comfortable with having a nuclear waste repository in Alberta? (i.e. a storage facility for spent nuclear fuel and other high-level radioactive waste)");
                    userResponses.add(comfortableUncomfortable());
                    i++;
                    break;
                case 8:
                    System.out.println("Small Modular Reactors (SMR) are a safer option than larger traditional reactors.");
                    userResponses.add(agreeDisagree());
                    i++;
                    break;
                case 9:
                    System.out.println("Are you concerned with natural radioactivity? (i.e. naturally decaying radioactive substances)");
                    userResponses.add(concernedUnconcerned());
                    i++;
                    break;
                case 10: //Custom
                    System.out.println("In your opinion, what kind of energy production technology should be used in the future?");
                    userResponses.add(customTechnology());
                    i++;
                    break;
            }
        }
        return userResponses;
    }

    //Agree/disagree selector
    public static double agreeDisagree() {
        boolean incorrectInput = true;
        double opinionNumber = 0.0;
        while(incorrectInput) {
            System.out.println("\n1 - I strongly disagree");
            System.out.println("2 - I somewhat disagree");
            System.out.println("3 - I neither agree nor disagree");
            System.out.println("4 - I somewhat agree");
            System.out.println("5 - I strongly agree");
            String userChoice = input.nextLine();
            switch (userChoice) {
                case "1"://Strongly disagree
                    opinionNumber = -1.0;
                    incorrectInput = false;
                    break;
                case "2"://Somewhat disagree
                    opinionNumber = -0.5;
                    incorrectInput = false;
                    break;
                case "3"://Neutral
                    opinionNumber = 0.0;
                    incorrectInput = false;
                    break;
                case "4"://Somewhat agree
                    opinionNumber = 0.5;
                    incorrectInput = false;
                    break;
                case "5"://Strongly agree
                    opinionNumber = 1.0;
                    incorrectInput = false;
                    break;
                default:
                    clearScreen();
                    System.out.println("You have entered an incorrect input! Please try again.");
                    incorrectInput = true;
                    break;
            }
        }
        return opinionNumber;
    }

    //Concerned/unconcerned selector
    public static double concernedUnconcerned() {
        boolean incorrectInput = true;
        double opinionNumber = 0.0;
        while(incorrectInput) {
            System.out.println("\n1 - I am very concerned");
            System.out.println("2 - I am somewhat concerned");
            System.out.println("3 - I am neither concerned nor unconcerned");
            System.out.println("4 - I am somewhat unconcerned");
            System.out.println("5 - I am very unconcerned");
            String userChoice = input.nextLine();

            switch (userChoice) {
                case "1"://Very concerned
                    opinionNumber = -1.0;
                    incorrectInput = false;
                    break;
                case "2"://Somewhat concerned
                    opinionNumber = -0.5;
                    incorrectInput = false;
                    break;
                case "3"://Neutral
                    opinionNumber = 0.0;
                    incorrectInput = false;
                    break;
                case "4"://Somewhat unconcerned
                    opinionNumber = 0.5;
                    incorrectInput = false;
                    break;
                case "5"://Strongly unconcerned
                    opinionNumber = 1.0;
                    incorrectInput = false;
                    break;
                default:
                    clearScreen();
                    System.out.println("You have entered an incorrect input! Please try again.\n");
                    incorrectInput = true;
                    break;
            }
        }
        return opinionNumber;
    }

    //Comfortable/uncomfortable selector
    public static double comfortableUncomfortable() {
        boolean incorrectInput = true;
        double opinionNumber = 0.0;
        while(incorrectInput) {
            System.out.println("1 - I would be very uncomfortable");
            System.out.println("2 - I would be somewhat uncomfortable");
            System.out.println("3 - I would be neither comfortable nor uncomfortable");
            System.out.println("4 - I would be somewhat comfortable");
            System.out.println("5 - I would be very comfortable");
            String userChoice = input.nextLine();

            switch (userChoice) {
                case "1"://Very uncomfortable
                    opinionNumber = -1.0;
                    incorrectInput = false;
                    break;
                case "2"://Somewhat uncomfortable
                    opinionNumber = -0.5;
                    incorrectInput = false;
                    break;
                case "3"://Neutral
                    opinionNumber = 0.0;
                    incorrectInput = false;
                    break;
                case "4"://Somewhat comfortable
                    opinionNumber = 0.5;
                    incorrectInput = false;
                    break;
                case "5"://Strongly comfortable
                    opinionNumber = 1.0;
                    incorrectInput = false;
                    break;
                default:
                    clearScreen();
                    System.out.println("You have entered an incorrect input! Please try again.\n");
                    incorrectInput = true;
                    break;
            }
        }
        return opinionNumber;
    }

    //The largest greenhouse gas emitting sector in Alberta
    public static double customSector() {
        boolean incorrectInput = true;
        double opinionNumber = 0.0;
        while (incorrectInput) {
            System.out.println("1 - Transportation");
            System.out.println("2 - Industries and Manufacturing");
            System.out.println("3 - Oil and Gas");
            System.out.println("4 - Buildings");
            System.out.println("5 - Electricity");
            System.out.println("6 - Agriculture");
            System.out.println("7 - Waste and Others");
            String userChoice = input.nextLine();
            switch (userChoice) {
                case "1"://Transportation (Same)
                case "2"://Industries and Manufacturing (Same)
                case "4"://Buildings (Same)
                case "6"://Agriculture (Same)
                case "7"://Waste and Others (Same)
                    opinionNumber = 0.0;
                    incorrectInput = false;
                    break;
                case "3"://Oil and Gas (In favour of nuclear energy (oil and gas production can be powered by small module reactors))
                case "5"://Electricity (In favour of nuclear energy (electricity can be powered by nuclear energy))
                    opinionNumber = 0.5;
                    incorrectInput = false;
                    break;
                default:
                    clearScreen();
                    System.out.println("You have entered an incorrect input! Please try again.\n");
                    incorrectInput = true;
                    break;
            }
        }
        return opinionNumber;
    }

    //What kind of energy production technology should Alberta use
    public static double customTechnology() {
        boolean incorrectInput = true;
        double opinionNumber = 0.0;
        while(incorrectInput) {
            System.out.println("1 - Wind and Sun Energy");
            System.out.println("2 - Sea Wave Energy (outsourced from British Columbia)");
            System.out.println("3 - Nuclear Energy");
            System.out.println("4 - Hydro Energy");
            System.out.println("5 - Other Technology");
            String userChoice = input.nextLine();
            switch (userChoice) {
                case "1"://Same
                case "2"://Same
                case "4"://Same
                case "5"://Same
                    opinionNumber = 0.0;
                    incorrectInput = false;
                    break;
                case "3"://Much higher in favour
                    opinionNumber = 1.0;
                    incorrectInput = false;
                    break;
                default:
                    clearScreen();
                    System.out.println("You have entered an incorrect input! Please try again.\n");
                    incorrectInput = true;
                    break;
            }
        }
        return opinionNumber;
    }

    public static double calculations(ArrayList<Double> userResponses) {
        double finalValue = 0.0;
        for (int i = 0; i < userResponses.size(); i++) {
            finalValue += userResponses.get(i);
        }
        return finalValue;
    }

    //Main (calls all functions)
    public static void main(String[] args) {
        double compareValue = 0.0;
        int initialOpinion = welcomeScreen();
        ArrayList<Double> userResponses = new ArrayList<Double>(questions());
        double finalValue = calculations(userResponses);
        clearScreen();
        System.out.println("Thanks for your honesty, " + name + ".\n");
        System.out.print("At the beginning of the survey, you stated that you ");
        if (initialOpinion == 1) {
            System.out.print("“strongly disagree with nuclear power generation in Alberta.”");
        }
        if (initialOpinion == 2) {
            System.out.print("“somewhat disagree with nuclear power generation in Alberta.”");
        }
        if (initialOpinion == 3) {
            System.out.print("“neither agree nor disagree with nuclear power generation in Alberta.”");
        }
        if (initialOpinion == 4) {
            System.out.print("“somewhat agree with nuclear power generation in Alberta.”");
        }
        if (initialOpinion == 5) {
            System.out.print("“strongly agree with nuclear power generation in Alberta.”");
        }
        System.out.println("\nLet's see how your answer compares with my calculations.");
        System.out.println("\nPress enter to see your results.");
        input.nextLine();
        clearScreen();
        System.out.println("Based on how you answered the various questions throughout the survey, I believe that you...");
        if (finalValue <= -3.5) {
            System.out.println("strongly disagree with nuclear energy generation in Alberta!");
            compareValue = -1.0;
        } else if (finalValue > -3.5 && finalValue < 0) {
            System.out.println("somewhat disagree with nuclear energy generation in Alberta!");
            compareValue = -0.5;
        } else if (finalValue >= 0 && finalValue <= 2) {
            System.out.println("neither agree nor disagree with nuclear energy generation in Alberta!");
            compareValue = 0.0;
        } else if (finalValue > 2 && finalValue < 5.5) {
            System.out.println("somewhat agree with nuclear energy generation in Alberta!");
            compareValue = 0.5;
        } else if (finalValue >= 5.5) {
            System.out.println("strongly agree with nuclear energy generation in Alberta!");
            compareValue = 1.0;
        }
        System.out.println("\nRemember, my calculations may not be perfect, but I tried my best to make them as accurate as possible.");
        System.out.println("\nNow that we’ve established your opinion, let’s compare it with Mischa’s.");
        System.out.println("\nPress enter to compare your opinion with Mischa’s.");
        input.nextLine();
        clearScreen();
        System.out.println("Mischa somewhat agrees with nuclear energy generation in Alberta.");
        System.out.println("He believes it’s an adequate way of reducing greenhouse gas emissions to ultimately create cleaner energy and oil and gas sectors.");
        System.out.println("However, Mischa is frightened by the idea of a having a nuclear waste repository Alberta as it could potentially lead to nuclear disasters.");
        System.out.println("Furthermore, Mischa believes that nuclear waste could be as bad for the environment as CO2 (carbon dioxide) emissions. ");
        System.out.println("Overall, Mischa believes that Alberta’s money should be invested in more sustainable energy options, such as wind and solar.");
        if (compareValue == -1.0) {
            System.out.println("According to my calculations, it looks like you and Mischa have opposing opinions on the topic.");
            System.out.println("While Mischa somewhat agrees with nuclear energy generation in Alberta, you strongly disagree.");
        } else if (compareValue == -0.5) {
            System.out.println("According to my calculations, it looks like you and Mischa have slightly opposing opinions on the topic.");
            System.out.println("While Mischa somewhat agrees with nuclear energy generation in Alberta, you somewhat disagree.");
        } else if (compareValue == 0.0) {
            System.out.println("According to my calculations, it looks like you and Mischa have pretty similar opinions on the topic.");
            System.out.println("While Mischa somewhat agrees with nuclear energy generation in Alberta, you neither agree nor disagree.");
        } else if (compareValue == 0.5) {
            System.out.println("According to my calculations, it looks like you and Mischa have the same opinion on the topic!");
            System.out.println("You and Mischa both agree with nuclear energy generation in Alberta!");
        } else if (compareValue == 1.0) {
            System.out.println("According to my calculations, it looks like you and Mischa have pretty similar opinions on the topic.");
            System.out.println("While Mischa somewhat agrees with nuclear energy generation in Alberta, you strongly agree!");
        }
        System.out.println("\nAwesome! Press enter to continue.");
        input.nextLine();
        clearScreen();
        System.out.println("Thanks for completing my survey!");
        System.out.println("I hope you leave with a better understanding of the topic and your overall opinion on nuclear energy generation in Alberta.");
        System.out.println("\nSee you later!\n");
        System.out.println("Press enter to exit.");
        input.nextLine();
        clearScreen();
    }
}