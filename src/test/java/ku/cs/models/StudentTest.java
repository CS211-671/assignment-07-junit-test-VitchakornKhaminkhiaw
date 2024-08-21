package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s1;

    @BeforeEach
    void init(){
        s1 = new Student("6xxxxxxxxx", "StudentTest");
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน")
    void testAddScore(){
//        Student s1 = new Student("6xxxxxxxxx", "StudentTest");
        assertEquals(0, s1.getScore());
        s1.addScore(40.5);
        assertEquals(40.5, s1.getScore());
        s1.addScore(10);
        assertEquals(50.5, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบการคิดเกรด 60.8 คะแนน")
    void testCalculateGrade(){
//        Student s1 = new Student("6xxxxxxxxx", "StudentTest");
        s1.addScore(60.8);
        assertEquals("C", s1.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อ")
    void testChangeName(){
        s1.changeName("Dew");
        assertEquals("Dew", s1.getName());
        s1.changeName("Mo");
        assertEquals("Mo", s1.getName());
    }

    @Test
    @DisplayName("ทดสอบ constructor1")
    void testStudent1(){
        Student s2 = new Student("6610451117","Dew");
        assertEquals("6610451117", s2.getId());
        assertEquals("Dew", s2.getName());
        assertEquals(0, s2.getScore());
    }

    @Test
    @DisplayName("ทดสอบ constructor2")
    void testStudent2(){
        Student s2 = new Student("6610451117","Dew",69.5);
        assertEquals("6610451117", s2.getId());
        assertEquals("Dew", s2.getName());
        assertEquals(69.5, s2.getScore());
    }

    @Test
    @DisplayName("ทดสอบ toString")
    void testToString(){
        assertEquals("{id: '6xxxxxxxxx', name: 'StudentTest', score: 0.0}", s1.toString());
    }
    @Test
    @DisplayName("ทดสอบการเช็ค ID")
    void testIsId(){
        assertTrue(s1.isId("6xxxxxxxxx"));
    }

}