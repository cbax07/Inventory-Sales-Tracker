import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;


public class ShrimpProfit {
    private String name;
    private int count;
    private double money;
    private String date;

    public ShrimpProfit(String name, int count, double money, String date) {
        this.name = name;
        this.count = count;
        this.money = money;
        this.date = date;
    }

    public ShrimpProfit() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    static double serializeShrimpProfit() throws IOException {
        Scanner input = new Scanner(System.in);
        ShrimpProfit shrimpP = new ShrimpProfit();

        int count;
        double money;
        String name;
        String date;
        String filepath = "database/SalesDatabase.json";

        System.out.println("Enter Cherry or Blue");
        name = input.nextLine();
        shrimpP.setName(name);

        System.out.println("Enter the amount of shrimp sold");
        count = input.nextInt();
        input.nextLine();
        shrimpP.setCount(count);

        System.out.println("Enter the amount of money made");
        money = input.nextDouble();
        input.nextLine();
        shrimpP.setMoney(money);

        System.out.println("Enter the date sold as: MM.DD.YEAR");
        date = input.nextLine();
        shrimpP.setDate(date);

        // Create JSON data
        ObjectMapper mapper = new ObjectMapper();
        final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(shrimpP);

        // Content is appended (due to StandardOpenOption.APPEND)
        Files.write(new File(filepath).toPath(), List.of(json), StandardOpenOption.APPEND);

        return shrimpP.getMoney();
    }

    static void printShrimpSales() throws IOException {
        String filepath = "database/SalesDatabase.json";
        System.out.println(Files.readString(Path.of(filepath)));
    }

    static void totalMoneyMade(double tempTotal) throws IOException {
        String filepath = "database/totalSales.txt";
        double total = 0.00;
        String totalString = String.valueOf(total);

        /* If txt file has total amount, store and convert to total variable
        otherwise create the txt file with the total */
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String ts;
        while((ts = br.readLine()) != null) {
            totalString = ts;
        }
        br.close();
        total = Double.parseDouble(totalString);

        //If no total was found above or total was 0, tempTotal becomes total, otherwise add temptotal to total
        if (total == 0) {
            total = tempTotal;
        } else {
            total += tempTotal;
        }
        //rewrite total to string because changes may have been made
        totalString = String.valueOf(total);
        //Write total to txt file and close
        BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
        bw.write(totalString);
        bw.close();
        System.out.println("The total money made from all sales is $" + totalString);
    }
}