// MVCPatternTest.java
public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a Student
        Student model = new Student("1", "John Doe", "A");

        // Create a View
        StudentView view = new StudentView();

        // Create a Controller
        StudentController controller = new StudentController(model, view);

        // Display initial details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Doe");
        controller.setStudentGrade("B");

        // Display updated details
        controller.updateView();
    }
}
