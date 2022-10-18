import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class GitLab {

    public static void main(String[] args){
        BufferedReader br = null;
        try{
            File file = new File("lab3Output.txt");

            if(!file.exists())
                file.createNewFile();

            PrintWriter pw = new PrintWriter(file);
            pw.println("Результат проверки:");

            br = new BufferedReader(new FileReader("lab3.txt"));
            String line;
            while ((line = br.readLine()) != null){
                pw.println(checkWithRegExp(line));
            }
            System.out.println("Результаты проверки записаны в файле lab3Output.txt");
            pw.close();
        } catch(IOException e) {
            System.out.print("Error!");
        }

    }
    public static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("^(([А-Я]{1}[а-я]{3,8})[ ]([А-Я]{1}[а-я]{5,8}))[ ]*[|]([1-9][0-9])[ ]*[|](\\+\\d{1,3}[ ]?)?(\\((\\d{3})\\)[ ]?)?(\\d{3}[-]?)?(\\d{2}[-]?)?(\\d{2})?[ ]*[|][\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
}
