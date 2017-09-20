/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test
 * Type: TestLogin
 * Last update: 14-set-2017 13.39.23
 * 
 */

package test;

import java.util.Arrays;
import java.util.Collection;

import javax.security.auth.login.LoginException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.org.bdc.controls.C_UC_Login;
import main.org.bdc.model.people.UserRegistered;


@RunWith(value = Parameterized.class)
public class TestLogin {

    private UserRegistered user;

    @Parameterized.Parameters
    public static Collection<UserRegistered> data() throws LoginException {
        UserRegistered correctUser = new UserRegistered();
        correctUser.setUserId("user_a");
        correctUser.setPassword("user_a");

        UserRegistered notindb = new UserRegistered();
        notindb.setUserId("notindb");
        notindb.setPassword("notindb");

        UserRegistered missingPasswordFieldUser = new UserRegistered();
        missingPasswordFieldUser.setUserId("utente");
        missingPasswordFieldUser.setPassword("");

        UserRegistered missingIdFieldUser = new UserRegistered();
        missingIdFieldUser.setUserId("");
        missingIdFieldUser.setPassword("password");

        return Arrays.asList(correctUser, notindb, missingPasswordFieldUser, missingIdFieldUser);
    }

    public TestLogin(UserRegistered user) {
        this.user = user;
    }

    @Test
    public void test() {

        C_UC_Login c_uc_login = C_UC_Login.getInstance();
        UserRegistered userRegistered = null;
        try {
            userRegistered = c_uc_login.login(user.getUserId(), user.getPassword());
            Assert.assertNotNull(user);
        } catch (LoginException e) {
            Assert.assertTrue(false);
        }

        /*Assert.assertEquals("Name uncorrect", "user_a", userRegistered.getFirstName());
        Assert.assertEquals("Surname uncorrect", "user_a", userRegistered.getLastName());
        Assert.assertEquals("Password uncorrect", "user_a", userRegistered.getPassword());
        Assert.assertEquals("User-id uncorrect", "user_a", userRegistered.getUserId());
        Assert.assertEquals("Email uncorrect", "admin@email", userRegistered.getEmail());
        Assert.assertNotNull("Admin", userRegistered.getUserType());
        Assert.assertNotEquals("Missing id field", "", userRegistered.getUserId());
        Assert.assertNotEquals("Missing password field", "", userRegistered.getUserId());*/

    }
}
