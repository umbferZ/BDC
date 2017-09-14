package test;

import main.org.bdc.controls.C_UC_InsertNewUser;
import main.org.bdc.controls.C_UC_Login;
import main.org.bdc.model.DaoFactory;
import main.org.bdc.model.people.UserRegistered;
import main.org.bdc.model.people.UserType;
import main.org.bdc.service.dal.exception.SaveOrUpdateDalException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.jws.soap.SOAPBinding;
import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Sasha on 13/09/17.
 */
@RunWith(value = Parameterized.class)
public class TestInsertUser {

    private UserRegistered user;

    public TestInsertUser(UserRegistered user) {
        this.user = user;
    }

    @Parameterized.Parameters
    public static Collection<UserRegistered> data(){

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
        user2.setUserId("amministratore");
        user2.setPassword("amministratore");
        user2.setUserType(UserType.USER_REGISTERED);

        return Arrays.asList(
                user1,
                user2
        );
    }

    @Test
    public void test() throws SaveOrUpdateDalException, LoginException {

        C_UC_InsertNewUser c_uc_insertNewUser = new C_UC_InsertNewUser();
        c_uc_insertNewUser.insert(this.user);
        Assert.assertNotEquals("Already in DB", "amministratore", user.getUserId());

    }
}
