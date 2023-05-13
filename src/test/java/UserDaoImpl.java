import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private List<User> userList;

    public UserDaoImpl() {
        userList = new ArrayList<>();
        initializeUsers();
    }

    private void initializeUsers() {
        User user1 = new User("John");
        User user2 = new User("Alice");
        User user3 = new User("Bob");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
    }

    public void save(User user) {
        userList.add(user);
    }

    public User findById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        return userList;
    }

    public void update(User user) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId() == user.getId()) {
                userList.set(i, user);
                break;
            }
        }
    }

    public void delete(User user) {
        userList.remove(user);
    }

    public User getUserByName(String name) {
        for (User user : userList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAllUsers() {
        return userList;
    }
}