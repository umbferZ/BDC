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

        return Arrays.asList(
                correctUser,
                notindb
        );
    }

    @Test
    public void test() throws LoginException {

        C_UC_Login c_uc_login = new C_UC_Login();
        c_uc_login.login(this.user.getUserId(), this.user.getPassword());

        Assert.assertEquals("Name uncorrect", "amministratore", user.getFirstName());
        Assert.assertEquals("Surname uncorrect", "amministratore", user.getLastName());
        Assert.assertEquals("Password uncorrect", "amministratore", user.getPassword());
        Assert.assertEquals("User-id uncorrect", "amministratore", user.getUserId());
        Assert.assertEquals("Email uncorrect", "admin@email", user.getEmail());
        Assert.assertNotNull("Admin", user.getUserType());

    }
}
