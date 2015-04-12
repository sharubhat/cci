package practicalunittesting.exercise.mockito;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by sharath on 4/11/15.
 */
public class UserServiceImplTest {

    // Write a happy-path test for the class presented below.
    // Verify that the user gets his new password,
    // and that the updateUser() method of userDAO is called.

    UserDAO dao = mock(UserDAO.class);
    User user = mock(User.class);
    SecurityService service = mock(SecurityService.class);
    UserServiceImpl impl = new UserServiceImpl(dao, service);

    @Test
    public void verifyAssignGetsNewPassword() throws Exception {
        impl.assignPassword(user);

        verify(user).getPassword();
        verify(dao).updateUser(user);
    }
}