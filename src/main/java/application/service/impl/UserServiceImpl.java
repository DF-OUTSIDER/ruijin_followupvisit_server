package application.service.impl;

import application.common.Encrypt;
import application.entity.UserEntity;
import application.repository.UserRepository;
import application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean checkUserValid(String username, String password) throws Exception {
        if (!StringUtils.hasText(password))
            throw new Exception("No password");
        if (!StringUtils.hasText(username))
            throw new Exception("No username");
        UserEntity user = userRepository.findByUserNameEquals(username);

        String md5Pwd = Encrypt.getMd5String(password);

        return user.getPassword().contentEquals(md5Pwd);
    }
}
