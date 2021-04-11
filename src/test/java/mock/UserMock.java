package mock;

import dto.UserDTO;

import static utils.StringUtils.rand;
import static utils.StringUtils.randEmail;

public class UserMock {
    public  static UserDTO basic(String role){
        UserDTO user = new UserDTO();
        user.email = randEmail();
        user.name = rand();
        user.password = "123456";
        user.phone = "0388053333";
        user.role = role;
        return user;
    }
}
