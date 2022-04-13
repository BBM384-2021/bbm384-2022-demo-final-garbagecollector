package gcDemo.service;

import gcDemo.model.User;
import gcDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId).get();
    }
}
