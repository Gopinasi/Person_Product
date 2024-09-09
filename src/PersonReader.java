import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonReader {
    public static void main(String[] args) {


        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        ArrayList<Person> people = new ArrayList<>();
        String rec = "";
        Person person = null;

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            System.out.printf("   %s      %s     %s    %s      %s", "ID", "FirstName", "LastName", "Title", "YOB");
            System.out.printf("\n%s", "=========================================================");

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                while (reader.ready()) {
                    rec = reader.readLine();
                    String recFirst = rec.split("\\{")[0];
                    String first = recFirst;
                    String[] fields = first.split(", ");
                    person = new Person(fields[0], fields[1], fields[2], fields[3], fields[4]);
                    people.add(person);
                    System.out.println();
                    System.out.println(person.getIDnum() + "\t\t" + person.getFirstName() + "\t\t" + person.getLastName() + "\t\t" + person.getTitle() + "\t\t " + person.getYOB());


                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            } else  // User closed the chooser without selecting a file
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!!!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
