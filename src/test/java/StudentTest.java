import org.junit.jupiter.api.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentTest {

    ArrayList<Student> students;

    @BeforeAll
    public void initClass() {
        students = new ArrayList<Student>();
    }

    @AfterAll
    public void cleanClass() {
        students.clear();
    }

    @BeforeEach
    public void initMethod() {
        students.add(new Student("John Doe", 20));
        students.add(new Student("Jane Dea", 21));
    }

    @AfterEach
    public void cleanMethod() {
        students.clear();
    }

    @Test
    public void testDataCreation() {
        Student student = students.get(0);
        Student testStudent = new Student("John Doe", 20);
        Assertions.assertEquals(testStudent.getName(), student.getName());
    }

    @Test
    public void testStudentEnrolment() {
        students.get(0).enrollCourse("Math");
        students.get(0).enrollCourse("Science");
        Assertions.assertEquals(2, students.get(0).getEnrolledCourses().size());
        Assertions.assertEquals("Math", students.get(0).getEnrolledCourses().get(0));
        Assertions.assertEquals("Science", students.get(0).getEnrolledCourses().get(1));
    }

    @Test
    public void testStudentGrades() {
        students.get(0).enrollCourse("Math");
        students.get(0).enrollCourse("Science");
        students.get(0).setGrade("Math", "A");
        students.get(0).setGrade("Science", "B");
        Assertions.assertEquals("A", students.get(0).getGrade("Math"));
        Assertions.assertEquals("B", students.get(0).getGrade("Science"));
    }

}
