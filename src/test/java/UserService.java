public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean checkUserExist(User user) {
        User existingUser = userDao.getUserByName(user.getName());
        return existingUser != null;
    }
}