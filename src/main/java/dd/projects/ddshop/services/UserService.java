package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.mappers.UserMapper;
import dd.projects.ddshop.repositories.UserRepository;
import dd.projects.ddshop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    private String passwordHash(String password) {
        BigInteger number = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            number = new BigInteger(1, messageDigest);
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }

        return number.toString(16);
    }

    public User createUser(UserDTO userDTO) throws Exception {
        userValidator.validate(userDTO);
        //userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(userMapper.destinationToSource(userDTO));
    }

    public User updateUser(int id, UserDTO userDTO) throws Exception {
        userDTO.setId(id);
        userValidator.validate(userDTO);
        //userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;

        try {
            user = userRepository.findByEmailIs(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
}
