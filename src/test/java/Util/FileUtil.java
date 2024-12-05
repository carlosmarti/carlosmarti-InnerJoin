package Util;

import org.junit.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileUtil {
    public static String parseSQLFile(String fileName) {

        StringBuilder sql = new StringBuilder();
        try {
            //the file to be opened for reading
            FileInputStream fis = new FileInputStream("./" + fileName);

            //file to be scanned
            Scanner sc = new Scanner(fis);

            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if(!line.contains("--")) {
                    sql.append(line + " ");
                }
            }
            sc.close();     //closes the scanner
            if(sql.length()<3){
                Assert.fail("No SQL written in "+fileName);
            }
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        return sql.toString();
    }
}