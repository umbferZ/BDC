/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test
 * Type: TestInsertUser
 * Last update: 14-set-2017 13.18.14
 * 
 */

package test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import main.org.bdc.controls.C_UC_InsertNewUser;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.model.people.UserType;
import main.org.bdc.service.dal.exception.SaveDalException;

/**
 * Created by Sasha on 13/09/17.
 */
@RunWith(value = Parameterized.class)
public class TestInsertUser {

    private UserRegistered user;

    @Parameterized.Parameters
    public static Collection<UserRegistered> data() {

        UserRegistered admin = new UserRegistered();
        admin.setFirstName("Francesco");
        admin.setLastName("Ottaviano");
        admin.setEmail("fr.ottaviano@gmail.com");
        admin.setUserId("fra.ottaviano");
        admin.setPassword("francesco");
        admin.setUserType(UserType.ADMIN);

        UserRegistered user = new UserRegistered();
        user.setFirstName("Umberto");
        user.setLastName("Ferracci");
        user.setEmail("umbferz@gmail.com");
        user.setUserId("user_a");
        user.setPassword("user_a");
        user.setUserType(UserType.USER_REGISTERED);

        UserRegistered userEmptyNameField = new UserRegistered();
        user.setFirstName("");
        user.setLastName("Zelli");
        user.setEmail("zelli@gmail.com");
        user.setUserId("fedez94");
        user.setPassword("password");
        user.setUserType(UserType.USER_REGISTERED);

        UserRegistered userEmptySurnameField = new UserRegistered();
        user.setFirstName("Federica");
        user.setLastName("");
        user.setEmail("zelli@gmail.com");
        user.setUserId("fedez94");
        user.setPassword("password");
        user.setUserType(UserType.USER_REGISTERED);

        UserRegistered userEmptyEmailField = new UserRegistered();
        user.setFirstName("Federica");
        user.setLastName("Zelli");
        user.setEmail("");
        user.setUserId("fedez94");
        user.setPassword("password");
        user.setUserType(UserType.USER_REGISTERED);

        UserRegistered userEmptyIDField = new UserRegistered();
        user.setFirstName("Federica");
        user.setLastName("Zelli");
        user.setEmail("zelli@gmail.com");
        user.setUserId("");
        user.setPassword("password");
        user.setUserType(UserType.USER_REGISTERED);

        UserRegistered userEmptyPasswordField = new UserRegistered();
        user.setFirstName("Federica");
        user.setLastName("Zelli");
        user.setEmail("zelli@gmail.com");
        user.setUserId("fedez94");
        user.setPassword("");
        user.setUserType(UserType.USER_REGISTERED);

        return Arrays.asList(admin, user, userEmptyNameField, userEmptySurnameField, userEmptyEmailField, userEmptyIDField, userEmptyPasswordField);
    }

    public TestInsertUser(UserRegistered user) {
        this.user = user;
    }

    @Test
    public void test() {

        C_UC_InsertNewUser c_uc_insertNewUser = new C_UC_InsertNewUser();
        UserRegistered userRegistered = null;
        try {
            userRegistered = c_uc_insertNewUser.insertUser(user);
        } catch (SaveDalException e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotNull(userRegistered);
        Assert.assertNotEquals("Missing id field", "", userRegistered.getUserId());
        Assert.assertNotEquals("Missing name field", "", userRegistered.getFirstName());
        Assert.assertNotEquals("Missing surname field", "", userRegistered.getLastName());
        Assert.assertNotEquals("Missing mail field", "", userRegistered.getEmail());
        Assert.assertNotEquals("Missing password field", "", userRegistered.getPassword());

    }
}
