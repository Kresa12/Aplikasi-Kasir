package function;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {

    static String folder = "Log_Activity";
    static String pathFolder = "src" + File.separator + "log" + File.separator + folder;
    static String logName = "log_aplikasi_kasir.txt";
    static String pathLog = pathFolder + File.separator + logName;

    // Method untuk mendapatkan format tanggal dan waktu
    public static String getDateNow() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss z");
        return sdf.format(d);
    }

    // Method untuk menyimpan log
    public static void savelog(String activity) {
        try {
            File f = new File(pathFolder);
            f.mkdirs();

            File log = new File(pathLog);
            log.createNewFile();
            String formattedDate = getDateNow();
            System.out.println("Formatted date: " + formattedDate);
            String logEntry = "[" + "Log Activity : " + formattedDate + "] "  + "Log Information : " + activity + ".\n";

            Files.write(
                    Paths.get(pathLog),
                    logEntry.getBytes(),
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            System.err.println("Error Code: 101 => " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        savelog("Aplikasi dijalankan"); // Contoh penggunaan savelog()
    }
}