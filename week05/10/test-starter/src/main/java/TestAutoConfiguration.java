
import com.example.demo.props.School;
import com.example.demo.props.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(StudentProperties.class)
@ComponentScan("com.example.demo")
public class TestAutoConfiguration {

    @Autowired
    private StudentProperties studentProperties;

    @Bean
    public School getSchool(){
        return new School(studentProperties);
    }

}