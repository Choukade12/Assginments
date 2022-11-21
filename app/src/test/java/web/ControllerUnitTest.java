package web;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.controller.StudentController;
import org.example.model.Student;
import org.example.service.StudentRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)

@ActiveProfiles("test")
public class ControllerUnitTest {
    private static final String BASE_URL = "/StudentCRUD";
    private static final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;
    @MockBean
    StudentRepository studentRepository;

    @Test
    void createStudentTest() throws Exception{
        Student student = new Student();
       student.setStudentName("teststudent");
       student.setEmail("test@123");
       student.setPasswrod("student1234");
       Student student1 = student;
       UUID id = UUID.randomUUID();
       student1.setStudentId(id);
        when(studentRepository.save(any(Student.class))).thenReturn(student1);
        mockMvc.perform(
                post(BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .contentType(String.valueOf(convert(student))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.StudentId", Matchers.equalTo(student1.getStudentId().toString())))
                .andExpect(jsonPath("$.StudentName", Matchers.equalTo(student1.getStudentName().toString())))
                .andExpect(jsonPath("$.email", Matchers.equalTo(student1.getEmail().toString())))
                .andExpect(jsonPath("$.password", Matchers.equalTo(student1.getPasswrod().toString())));

    }

    @Test
    @WithMockUser(username = "admin@leegality.com")
    void findUserByIdSuccessTest() throws Exception {
        Student student = new Student();
        student.setStudentName("testUser");
        student.setEmail("testUser@leegality.com");
        student.setPasswrod("test");
        UUID userId = UUID.randomUUID();
        Student student1 = student;
        student1.setStudentId(userId);
        when(studentRepository.findById(userId)).thenReturn(Optional.of(student1));
        mockMvc.perform(
                        get((BASE_URL + "/" + userId)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.StudentId", Matchers.equalTo(student1.getStudentId().toString())))
                .andExpect(jsonPath("$.StudentName", Matchers.equalTo(student1.getStudentName())))
                .andExpect(jsonPath("$.email", Matchers.equalTo(student1.getEmail())))
                .andExpect(jsonPath("$.password", Matchers.equalTo(student1.getPasswrod())));
    }


    private byte[] convert(Object object) {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        JavaTimeModule module = new JavaTimeModule();
        mapper.registerModule(module);
        byte[] objectBytes = new byte[10];
        try {
            return mapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectBytes;
    }
}
