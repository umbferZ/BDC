package test;

import main.org.bdc.controls.C_UC_Login;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Sasha on 13/09/17.
 */
@RunWith(value = Parameterized.class)
public class TestLogin {

    private UserRegistered user;

    public TestLogin(UserRegistered user) {
        this.user = user;
    }

    @Parameterized.Parameters
    public static Collection<UserRegistered> data() throws LoginException {
        UserRegistered correctUser = new UserRegistered();
        correctUser.setUserId("amministratore");
        correctUser.setPassword("amministratore");

        UserRegistered notindb = new UserRegistered();
        notindb.setUserId("notindb");
        notindb.setPassword("notindb");

        UserRegistered missingPasswordFieldUser = new UserRegistered();
        missingPasswordFieldUser.setUserId("utente");
        missingPasswordFieldUser.setPassword("");

        UserRegistered missingIdFieldUser = new UserRegistered();
        missingIdFieldUser.setUserId("");
        missingIdFieldUser.setPassword("password");

        return Arrays.asList(
                correctUser,
                notindb,
                missingPasswordFieldUser,
                missingIdFieldUser
        );
    }

    @Test
    public void test() throws LoginException {

        C_UC_Login c_uc_login = new C_UC_Login();
        UserRegistered userRegistered = c_uc_login.login(this.user.getUserId(), this.user.getPassword());

        Assert.assertEquals("Name uncorrect", "amministratore", userRegistered.getFirstName());
        Assert.assertEquals("Surname uncorrect", "amministratore", userRegistered.getLastName());
        Assert.assertEquals("Password uncorrect", "amministratore", userRegistered.getPassword());
        Assert.assertEquals("User-id uncorrect", "amministratore", userRegistered.getUserId());
        Assert.assertEquals("Email uncorrect", "admin@email", userRegistered.getEmail());
        Assert.assertNotNull("Admin", userRegistered.getUserType());
        Assert.assertNotEquals("Missing id field", "", userRegistered.getUserId());
        Assert.assertNotEquals("Missing password field", "", userRegistered.getUserId());

    }
}
