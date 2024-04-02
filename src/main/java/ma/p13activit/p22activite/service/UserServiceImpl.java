package ma.p13activit.p22activite.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.p13activit.p22activite.entities.Role;
import ma.p13activit.p22activite.entities.User;
import ma.p13activit.p22activite.entities.repositories.RoleRepository;
import ma.p13activit.p22activite.entities.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;



    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);

    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);

    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user =  findUserByUserName(username);
        Role role = findRoleByRoleName(roleName);
        if (user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

//       userRepository.save(user);
    }
}
