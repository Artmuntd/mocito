import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {
    private UserDao userDao;

    @Before
    public void setUp() {
        userDao = new UserDaoImpl();
    }

    @Test
    public void testGetUserByName_existingName_returnsUser() {
        String existingName = "John";
        User user = userDao.getUserByName(existingName);
        Assert.assertNotNull(user);
        Assert.assertEquals(existingName, user.getName());
    }

    @Test
    public void testGetUserByName_nonExistingName_returnsNull() {
        String nonExistingName = "Alex";
        User user = userDao.getUserByName(nonExistingName);
        Assert.assertNull(user);
    }
}