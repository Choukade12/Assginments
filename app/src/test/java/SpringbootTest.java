import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.model.Student;
import org.example.service.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")

public class SpringbootTest {
    private static final String BASE_URL = "/v1/users";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @WithMockUser(username = "admin@leegality.com")
    void createNewUserSuccessTest() throws Exception {
        Student student = new Student();
        student.setStudentName("testUser");
        student.setEmail("testUser@leegality.com");
        student.setPasswrod("test");
        mockMvc.perform(
                        (RequestBuilder) post(BASE_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.valueOf(String.valueOf(convertObjectToJsonBytes(student)))))
                .andExpect(status().isCreated());

        Optional<Student> savedStudent = studentRepository.findById(student.getStudentId());
        assertTrue(savedStudent.isPresent());
        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.get().getStudentName()).isNotNull();
        assertEquals(student.getEmail(), savedStudent.get().getEmail());
    }

    private byte[] convertObjectToJsonBytes(Object object) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        byte[] objectBytes = new byte[10];
        try {
            return objectMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return objectBytes;
    }

}


