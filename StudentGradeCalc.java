import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class StudentGradeCalc {

    private static void saveToFile(String name, String idNum, double circuitTheory, 
            double discreteMaths, double pureMaths, double it, double commSkills,
            double economics, double cpp, double total, double average, String grade) {

        String desktopPath = System.getProperty("user.home") + "/Desktop/student_result.txt";

        try {
            Path filePath = Paths.get(desktopPath);
            Files.createDirectories(filePath.getParent());

            FileWriter writer = new FileWriter(desktopPath, true);

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            writer.write("\n\n====================================");
            writer.write("\n    RESULT RECORD - " + dtf.format(LocalDateTime.now()));
            writer.write("\nStudent Name: " + name);
            writer.write("\nID Number: " + idNum);
            writer.write("\n------------------------------------");
            writer.write("\nCircuit Theory: " + circuitTheory);
            writer.write("\nDiscrete Maths: " + discreteMaths);
            writer.write("\nPure Maths: " + pureMaths);
            writer.write("\nIT: " + it);
            writer.write("\nCommunication Skills: " + commSkills);
            writer.write("\nEconomics: " + economics);
            writer.write("\nProgramming With C++: " + cpp);
            writer.write("\nTOTAL MARKS: " + total + "/700");
            writer.write("\nAVERAGE: " + average + "%");
            writer.write("\nGRADE: " + grade);
            writer.write("\n====================================");

            writer.close();
            System.out.println("\nResults saved to: " + desktopPath);

        } catch (IOException e) {
            System.out.println("Error saving file! Trying default location...");
            saveToFileDefault(name, idNum, circuitTheory, discreteMaths, pureMaths, 
                             it, commSkills, economics, cpp, total, average, grade);
        }
    }

    private static void saveToFileDefault(String name, String idNum, double circuitTheory, 
            double discreteMaths, double pureMaths, double it, double commSkills,
            double economics, double cpp, double total, double average, String grade) {
        try {
            FileWriter writer = new FileWriter("student_result.txt", true);
            writer.write("\n\n====================================");
            writer.write("\nStudent Name: " + name);
            writer.write("\nID Number: " + idNum);
            writer.write("\nCircuit Theory: " + circuitTheory);
            writer.write("\nDiscrete Maths: " + discreteMaths);
            writer.write("\nPure Maths: " + pureMaths);
            writer.write("\nIT: " + it);
            writer.write("\nCommunication Skills: " + commSkills);
            writer.write("\nEconomics: " + economics);
            writer.write("\nProgramming With C++: " + cpp);
            writer.write("\nTOTAL MARKS: " + total + "/700");
            writer.write("\nAVERAGE: " + average + "%");
            writer.write("\nGRADE: " + grade);
            writer.write("\n====================================");
            writer.close();
            System.out.println("\nResults saved to: student_result.txt");
        } catch (IOException e) {
            System.out.println("Failed to save results anywhere!");
        }
    }

    // You can add a main method here to test your saveToFile method if you want
}