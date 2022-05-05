package service;

import domain.Nota;
import domain.Student;
import domain.Tema;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    Validator<Student> studentValidator = new StudentValidator();
    Validator<Tema> temaValidator = new TemaValidator();
    Validator<Nota> notaValidator = new NotaValidator();

    StudentXMLRepository fileRepository1 = new StudentXMLRepository(studentValidator, "studenti.xml");
    TemaXMLRepository fileRepository2 = new TemaXMLRepository(temaValidator, "teme.xml");
    NotaXMLRepository fileRepository3 = new NotaXMLRepository(notaValidator, "note.xml");

    Service service = new Service(fileRepository1, fileRepository2, fileRepository3);


    @org.junit.jupiter.api.Test
    void saveStudent_studentId_0_saveSuccess() {
        assertEquals(service.saveStudent("0", "aa", 222), 0);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_studentId_1_saveFail() {
        assertEquals(service.saveStudent("1", "aa", 222), 1);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_studentId_negative1_saveFail() {
        assertEquals(service.saveStudent("-1", "aa", 222), 1);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_studentId_maxInt_saveSuccess() {
        assertEquals(service.saveStudent("maxint", "aa", 222), 0);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_studentId_10_saveSuccess() {
        assertEquals(service.saveStudent("10", "aa", 222), 0);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_group_222_saveSuccess() {
        assertEquals(service.saveStudent("20", "aa", 222), 0);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_group_1_saveFail() {
        assertEquals(service.saveStudent("20", "aa", 0), 1);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_group_maxInt_saveFail() {
        assertEquals(service.saveStudent("20", "aa", Integer.MAX_VALUE), 1);
    }

    @org.junit.jupiter.api.Test
    void saveStudent_group_negative1_saveFail() {
        assertEquals(service.saveStudent("20", "aa", -1), 1);
    }
}