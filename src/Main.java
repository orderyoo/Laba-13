import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        Pattern pattern = Pattern.compile("^((([0-9]|[1-9][0-9]|1([0-9]{2})|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1([0-9]{2})|2[0-4][0-9]|25[0-5]))$");
        if (pattern.matcher(in).find()){
            in = in + " Верный IP";
            WriteIp(in);
        }
        else {
            in = in + " Неверный IP";
            WriteIp(in);
        }
    }
    public static void WriteIp(String ip) {
        try (FileWriter writer = new FileWriter("listOfIp.txt")) {
            writer.write(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}