package ma.p13activit.p22activite.service;

import ma.p13activit.p22activite.entities.Role;
import ma.p13activit.p22activite.entities.User;

public interface UserService  {
    User addNewUser (User user);
    Role addNewRole (Role role);
    User findUserByUserName (String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username, String roleName);

}
