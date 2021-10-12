import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;

public class ShrimpMaintenance {

    private String name;
    private int count;
    private String waterChange;

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

    public String getWaterChange() {
        return waterChange;
    }

    public void setWaterChange(String waterChange) {
        this.waterChange = waterChange;
    }

    public void ShrimpMaintenance(String name, int count, String waterChange) {
        this.name = name;
        this.count = count;
        this.waterChange = waterChange;
    }

    static void serializeShrimpMaintenance() throws IOException {
        Scanner input = new Scanner(System.in);
        ShrimpMaintenance shrimpP = new ShrimpMaintenance();
        int count;
        String name;
        String date;
        String filepath = "database/MaintenanceDatabase.json";

        System.out.println("Enter Cherry or Blue");
        name = input.nextLine();
        shrimpP.setName(name);

        System.out.println("Enter the estimated amount of shrimp in the tank");
        count = input.nextInt();
        input.nextLine();
        shrimpP.setCount(count);

        System.out.println("Enter the date of water change as: MM.DD.YEAR");
        date = input.nextLine();
        shrimpP.setWaterChange(date);

        // Created ObjectMapper object and stores it in designated file
        ObjectMapper mapper = new ObjectMapper();

        // Create JSON data
        final String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(shrimpP);

        // Content is appended (due to StandardOpenOption.APPEND)
        Files.write(new File(filepath).toPath(), Arrays.asList(json), StandardOpenOption.APPEND);
    }

    static void printMaintenanceLog() throws IOException {
        String filepath = "database/MaintenanceDatabase.json";

        // Created ObjectMapper object and stores it in designated file
        //ObjectMapper mapper = new ObjectMapper();
        System.out.println(Files.readString(Path.of(filepath)));
    }
}