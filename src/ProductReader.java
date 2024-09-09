import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {
    public static void main(String[] args) {


        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        ArrayList<Product> item = new ArrayList<>();
        String rec = "";
        Product object = null;

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            System.out.printf("%s          %s           %s            %s", "ID", "Name", "Description", "Cost");
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
                    object = new Product(fields[0], fields[1], fields[2], fields[3]);
                    item.add(object);
                    System.out.println();
                    System.out.println(object.getID() + "\t\t" + object.getName() + "\t\t" + object.getDesc() + "\t\t" + object.getCost());


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
