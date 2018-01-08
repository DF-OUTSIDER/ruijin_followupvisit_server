package application.service;

public interface UserService {
    boolean checkUserValid(String username, String password) throws Exception;
}
