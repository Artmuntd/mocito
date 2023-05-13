import java.util.List;

public interface UserDao {

    void save(User user);
    User findById(int id);
    List<User> getAll();
    void update(User user);
    void delete(User user);


    User getUserByName(String name);
}
