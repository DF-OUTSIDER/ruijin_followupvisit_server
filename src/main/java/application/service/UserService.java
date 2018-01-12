package application.service;

import application.domain.UserDto;

public interface UserService {
    boolean checkUserValid(String username, String password) throws Exception;

    UserDto findUserByUserName(String username);
}
