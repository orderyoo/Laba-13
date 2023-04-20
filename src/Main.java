import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        String ip = examinationIp(in);
        WriteIp(ip);
        System.out.println(ip);
    }
    public static String examinationIp(String in){
        Pattern pattern = Pattern.compile("(.*)((0|[0-1]([0-9]{2})|(2([0-5]{2})))\\.(0|[0-1]([0-9]{2})|(2([0-5]{2})))\\.\\d\\.\\d\\b)(.*)");
        Matcher matcher = pattern.matcher(in);
        String ip = null;
        if (matcher.find()){
            ip = matcher.group(2);
            return ip;
        }
        else return "Невереный IP!";
    }
    public static void WriteIp(String ip) {
        try (FileWriter writer = new FileWriter("listOfIp.txt")) {
            writer.write(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}