import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserService userService;

    @Mock
    private UserDao userDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userDao);
    }

    @Test
    public void testCheckUserExist_userExists_returnsTrue() {
        User existingUser = new User("John");
        when(userDao.getUserByName(existingUser.getName())).thenReturn(existingUser);

        boolean result = userService.checkUserExist(existingUser);

        Assert.assertTrue(result);
        verify(userDao, times(1)).getUserByName(existingUser.getName());
    }

    @Test
    public void testCheckUserExist_userDoesNotExist_returnsFalse() {
        User nonExistingUser = new User("Alex");
        when(userDao.getUserByName(nonExistingUser.getName())).thenReturn(null);

        boolean result = userService.checkUserExist(nonExistingUser);

        Assert.assertFalse(result);
        verify(userDao, times(1)).getUserByName(nonExistingUser.getName());
    }
}