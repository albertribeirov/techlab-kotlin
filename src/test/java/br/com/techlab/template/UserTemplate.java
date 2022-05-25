package br.com.techlab.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import br.com.techlab.domain.User;
import org.apache.logging.log4j.util.Strings;

public class UserTemplate implements TemplateLoader {

    public void load() {
        Fixture.of(User.class)
                .addTemplate(Template.VALID.name(), new Rule() {
                    {
                        add("name", "Jhonny");
                        add("email", "fulano@mail.com");
                        add("password", regex("[a-zA-Z0-9]{10}"));
                    }
                }).addTemplate(Template.INVALID.name())
                .inherits(Template.VALID.name(), new Rule() {
                    {
                        add("name", Strings.EMPTY);
                    }
                });
    }
    public enum Template {
        VALID, INVALID
    }
}











