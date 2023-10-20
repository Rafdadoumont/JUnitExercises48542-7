import org.example.exercise3.CourseUnit;
import org.example.exercise3.Mark;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class CourseUnitTest {

    static CourseUnit courseUnit;

    @BeforeEach
    public void setup() { courseUnit = new CourseUnit("Course 1", 10);}

    @Test
    public void given_courseUnit_when_markAdded_then_markAdded() {
        // Given
        assertEquals(0, courseUnit.getMarks().size());

        // When
        Mark mark = new Mark(20, 1);
        courseUnit.insertMark(mark);

        // Then
        assertEquals(1, courseUnit.getMarks().size());
    }

    @ParameterizedTest
    @CsvSource({"15, 1", "9, 2", "13, 1234", "2, 52"})
    public void given_courseUnitWithMarks_when_SearchStudent_then_studentIsReturned(ArgumentsAccessor argumentsAccessor) {
        // Given
        assertNotNull(courseUnit);

        // When
        int grade = argumentsAccessor.getInteger(0);
        int numStudent = argumentsAccessor.getInteger(1);

        Mark mark = new Mark(grade, numStudent);
        courseUnit.insertMark(mark);

        // Then
        assertNotEquals(-1, courseUnit.searchStudent(numStudent));
    }

    @Test
    public void given_courseUnitWithMarks_when_averageGrade_then_averageGradeIsReturned() {
        // Given
        assertNotNull(courseUnit);

        // When
        Mark mark1 = new Mark(12, 1);
        Mark mark2 = new Mark(20, 2);
        Mark mark3 = new Mark(9, 3);
        Mark mark4 = new Mark(7, 4);
        Mark mark5 = new Mark(16, 5);

        courseUnit.insertMark(mark1);
        courseUnit.insertMark(mark2);
        courseUnit.insertMark(mark3);
        courseUnit.insertMark(mark4);
        courseUnit.insertMark(mark5);

        // Then
        assertEquals(((double) (12 + 20 + 9 + 7 + 16) / 5), courseUnit.averageGrade());

    }

    @Test
    public void given_courseUnitWithPassedMarks_when_isApproved_then_returnTrue() {
        // Given
        assertNotNull(courseUnit);

        // When
        Mark mark = new Mark(17, 1);
        courseUnit.insertMark(mark);

        // Then
        assertTrue(courseUnit.isApproved(1));
    }


    @Test
    public void given_courseUnitWithFailedMarks_when_isApproved_then_returnFalse() {
        // Given
        assertNotNull(courseUnit);

        // When
        Mark mark = new Mark(7, 1);
        courseUnit.insertMark(mark);

        // Then
        assertFalse(courseUnit.isApproved(1));
    }

}
