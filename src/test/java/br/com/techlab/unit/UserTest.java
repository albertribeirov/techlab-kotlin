package br.com.techlab.unit;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import br.com.techlab.domain.User;
import br.com.techlab.template.UserTemplate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserTest {

    @BeforeAll
    static void setup() {
        FixtureFactoryLoader.loadTemplates("br.com.techlab.template");
    }

    @Test
    @DisplayName("Deve criar um usuário com sucesso")
    public void testUser() {
        User user = Fixture.from(User.class).gimme(UserTemplate.Template.VALID.name());
        System.out.println(user);
        assertEquals("Jhonny", user.getName());
    }
}








