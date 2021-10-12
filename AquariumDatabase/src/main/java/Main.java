// Corey Denny - Sales and Maintenance log for my aquariums

import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner scnr = new Scanner(System.in);
        ShrimpProfit shrimpP = new ShrimpProfit();
        ShrimpMaintenance shrimpM = new ShrimpMaintenance();

        System.out.println(" --------------------------------------------------------------------------");
        System.out.println("|                    My Aquarium Sales and Maintenance Log                 |");
        System.out.println("|          1. Shrimp for Profit                                            |");
        System.out.println("|          2. Water Change on Shrimp Tank                                  |");
        System.out.println("|          3. Output Sales Log                                             |");
        System.out.println("|          4. Output Maintenance Log                                       |");
        System.out.println("|          5. Total profit                                                 |");
        System.out.println(" --------------------------------------------------------------------------");

        double tempTotal = 0;
        int userInput = scnr.nextInt();
        switch (userInput) {
            case 1:
                System.out.println("-----Shrimp for Profit-----");
                tempTotal = ShrimpProfit.serializeShrimpProfit();
                ShrimpProfit.totalMoneyMade(tempTotal);
                break;
            case 2:
                System.out.println("-----Water Change on Shrimp Tank-----");
                ShrimpMaintenance.serializeShrimpMaintenance();
                break;
            case 3:
                System.out.println("-----Sales Log-----");
                ShrimpProfit.printShrimpSales();
                break;
            case 4:
                System.out.println("-----Maintenance Log-----");
                ShrimpMaintenance.printMaintenanceLog();
                break;
            case 5:
                System.out.println("-----Total profit-----");
                ShrimpProfit.totalMoneyMade(tempTotal);
                break;
            default:
                System.out.println("Invalid Key");
        }
    }
}

