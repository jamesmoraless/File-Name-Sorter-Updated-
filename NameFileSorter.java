package Q1BL5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NameFileSorter
{
    public static void main(String[] args) throws Exception {

        TreeMap<String, IntegerAndArrayList> lastName = new TreeMap<>();

        File file = new File("SE2205Students.txt");
        Scanner fileInput = new Scanner(file);
        if (!file.exists()) {
            System.out.println("File not found!");
            System.exit(0);
        }

        while (fileInput.hasNext()) {
            String inp = fileInput.nextLine();

            String splits[] = inp.split(" ");

            if (lastName.get(splits[0]) == null) {

                String fullName = "";

                for (int i = 0; i < splits.length; i ++){
                    if (!fullName.equals("")){
                        fullName += " ";
                    }
                    fullName += splits[i];
                }

                lastName.put(splits[0], new IntegerAndArrayList(fullName));
            }

            else {
                IntegerAndArrayList run = lastName.get(splits[0]);

                String fullName = "";

                for (int i = 0; i < splits.length; i ++){
                    if (!fullName.equals("")){
                        fullName += " ";
                    }
                    fullName += splits[i];
                }

                run.addName(fullName);

                lastName.put(splits[0], run);
            }
        }

        fileInput.close();


        header("James Morales", 251136192);
        System.out.println("List of the Number of students with the same Last Names:\n" +
                "===============================================================\n" +
                "Last Name       # of Students       Full Names\n" +
                "===============================================================");

        Set<Map.Entry<String, IntegerAndArrayList>> last = lastName.entrySet();

        for (Map.Entry<String, IntegerAndArrayList> entry : last)
        {
            IntegerAndArrayList checker = entry.getValue();

            if (checker.moreThanOnce() == true) {
                System.out.printf("%s", entry.getKey());

                String printStatement = checker.toString();
                System.out.print("\t\t" + printStatement);
            }
        }

        footer();

    }

    public static void header(String name, int studentNum)
    {
        String nm = name;
        int sN = studentNum;

        System.out.println("_______________________________________");
        System.out.println("|  "+ nm + " ********* " + sN+"  |");
        System.out.println("---------------------------------------\n");

    }

    public static void footer()
    {
        System.out.println("\nGoodbye from James :)");
    }
}

