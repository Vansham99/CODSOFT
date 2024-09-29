import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Array to store marks obtained in each subject
        int[] marks = new int[numberOfSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            totalMarks += marks[i]; // Sum up the marks
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Determine the grade based on the average percentage
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        // Close the scanner
        scanner.close();
    }
}
