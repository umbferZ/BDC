/*
 * 
 * Created by Umberto Ferracci, Francesco Ottaviano and Federica Zelli
 * Project: BdC - Osservatorio Astronomico Virtuale
 * Package: test
 * Type: TestInsertUser
 * Last update: 14-set-2017 11.33.09
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

        UserRegistered user1 = new UserRegistered();
        user1.setFirstName("Francesco");
        user1.setLastName("Ottaviano");
        user1.setEmail("fr.ottaviano@gmail.com");
        user1.setUserId("fra.ottaviano");
        user1.setPassword("francesco");
        user1.setUserType(UserType.ADMIN);

        UserRegistered user2 = new UserRegistered();
        user2.setFirstName("Umberto");
        user2.setLastName("Ferracci");
        user2.setEmail("umbferz@gmail.com");
        user2.setUserId("user_a");
        user2.setPassword("amministratore");
        user2.setUserType(UserType.USER_REGISTERED);

        return Arrays.asList(user1, user2);
    }

    public TestInsertUser(UserRegistered user) {
        this.user = user;
    }

    @Test
    public void test() {

        C_UC_InsertNewUser c_uc_insertNewUser = new C_UC_InsertNewUser();

        try {
            Assert.assertNotNull("", c_uc_insertNewUser.insertUser(user));
        } catch (SaveDalException e) {
            Assert.assertTrue(false);
        }
        Assert.assertNotEquals("Already in DB", "user_a", user.getUserId());

    }
}
