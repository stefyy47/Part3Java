package part1and2.proiect;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;

public class WriteService {
    public static void writeFunction(String str) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Path pth = Paths.get("./csvs/audit.csv");
        try (
                BufferedWriter out = Files.newBufferedWriter(pth, StandardOpenOption.APPEND)) {
            out.write(str + " " + time + '\n');
        } catch (IOException e) {
            System.out.println("Nu am reusit sa scriu");
        }
    }

}
