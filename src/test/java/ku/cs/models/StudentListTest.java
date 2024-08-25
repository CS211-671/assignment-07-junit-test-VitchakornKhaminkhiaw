package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class StudentListTest {
    StudentList studentList;

    @BeforeEach
    void init(){
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนแบบไม่ใส่คะแนน")
    void testAddNewStudent1(){
        studentList.addNewStudent("6610451117", "Dew");
        Student s1 = studentList.findStudentById("6610451117");
        assertNotNull(s1);
        assertEquals("6610451117", s1.getId());
        assertEquals("Dew", s1.getName());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มนักเรียนแบบใส่คะแนน")
    void testAddNewStudent2(){
        studentList.addNewStudent("6610451117", "Dew", 50.0);
        Student s1 = studentList.findStudentById("6610451117");
        assertNotNull(s1);
        assertEquals("6610451117", s1.getId());
        assertEquals("Dew", s1.getName());
        assertEquals(50.0, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบการค้นหานักเรียนด้วย id")
    void testFindStudentById(){
        //หาพบ
        studentList.addNewStudent("6610451117", "Dew");
        Student s1 = studentList.findStudentById("6610451117");
        assertNotNull(s1);
        assertEquals("Dew", s1.getName());
        //หาไม่พบ
        Student s2 = studentList.findStudentById("6610450000");
        assertNull(s2);
    }

    @Test
    @DisplayName("ทดสอบการให้คะแนนนักเรียนผ่าน id")
    void testGiveScoreToId(){
        studentList.addNewStudent("6610451117", "Dew");
        studentList.giveScoreToId("6610451117", 70.5); //เพิ่มคะแนนครั้งแรก
        Student s1 = studentList.findStudentById("6610451117");
        assertNotNull(s1);
        assertEquals(70.5, s1.getScore());
        studentList.giveScoreToId("6610451117", 10.5); //เพิ่มคะแนนครั้งที่สอง
        assertEquals(81.0, s1.getScore());
    }

    @Test
    @DisplayName("ทดสอบการดูเกรดนักเรียน")
    void testViewGradeOfId(){
        studentList.addNewStudent("6610451117", "Dew");
        studentList.giveScoreToId("6610451117", 79.9);
        Student s1 = studentList.findStudentById("6610451117");
        assertNotNull(s1);
        assertEquals("B", s1.grade());
    }

    @Test
    @DisplayName("ทดสอบ getStudents")
    void testGetStudents(){
        studentList.addNewStudent("6610451117", "Dew");
        studentList.addNewStudent("6610451000", "Mo", 90.0);

        ArrayList<Student> students = studentList.getStudents();
        assertEquals(2, students.size());
        assertEquals("Dew", students.get(0).getName());
        assertEquals("Mo", students.get(1).getName());
        assertEquals(90.0, students.get(1).getScore());
    }
}