import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter
{
    public static void main (String[] args)
    {
        ArrayList<Product> item = new ArrayList<>();
        Scanner in  = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\productTestData.txt");

        boolean done = false;
        String ID = "";
        String name = "";
        String desc = "";
        double cost = 0;

        do{
            ID = SafeInput.getNonZeroLenString(in,"Enter the ID [6 digits]");
            name = SafeInput.getNonZeroLenString(in,"Enter the name");
            desc = SafeInput.getNonZeroLenString(in,"Enter the description");
            cost = SafeInput.getDouble(in,"Enter the cost");

            Product object = new Product(ID, name, desc, cost);
            item.add(object);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);

        for(Product p: item ) {
            System.out.println(p);

            try
            {

                OutputStream out =
                        new BufferedOutputStream(Files.newOutputStream(file, CREATE));
                BufferedWriter writer =
                        new BufferedWriter(new OutputStreamWriter(out));


                for(Product rec : item)
                {
                    writer.write(rec.toCSV());
                    writer.write(rec.toJSON());
                    writer.write(rec.toXML());
                    writer.newLine();

                }
                writer.close();
                System.out.println("Data file written!");
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}