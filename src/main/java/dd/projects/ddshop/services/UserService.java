package dd.projects.ddshop.services;

import dd.projects.ddshop.dto.UserDTO;
import dd.projects.ddshop.entities.AuthenticationRequest;
import dd.projects.ddshop.entities.User;
import dd.projects.ddshop.mappers.UserMapper;
import dd.projects.ddshop.repositories.UserRepository;
import dd.projects.ddshop.util.JwtUtil;
import dd.projects.ddshop.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final JwtUtil jwtTokenUtil;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, UserValidator userValidator, JwtUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    private String passwordHash(String password) {
        String hash = null;

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            hash = number.toString(16);
        } catch (NoSuchAlgorithmException exception) {
            exception.printStackTrace();
        }

        return hash;
    }

    public User createUser(UserDTO userDTO) {
        userValidator.validate(userDTO);
        //userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(userMapper.destinationToSource(userDTO));
    }

    public User updateUser(int id, UserDTO userDTO) {
        userDTO.setId(id);
        userValidator.validate(userDTO);
        //userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepository.save(userMapper.destinationToSource(userDTO));
    }

    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    public List<UserDTO> getUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::sourceToDestination)
                .toList();
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;

        try {
            user = userRepository.findByEmail(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public String authenticate(AuthenticationRequest authenticationRequest) {
        final User userDetails = loadUserByUsername(authenticationRequest.getUsername());

        return jwtTokenUtil.generateToken(userDetails);
    }

    public int getUserId(User user) {
        return user.getId();
    }

    public User getUserById(int id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }
}
