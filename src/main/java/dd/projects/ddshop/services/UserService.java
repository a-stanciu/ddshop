package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.mappers.UserMapper;
import dd.projects.ddshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User createUser(UserDTO userDTO) {
        return userRepository.save(userMapper.destinationToSource(userDTO));
    }

    public User updateUser(UserDTO userDTO) {
        return userRepository.save(userMapper.destinationToSource(userDTO));
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::sourceToDestination)
                .toList();
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
