package com.parking.parkinglot1.ejb;

import com.parking.parkinglot1.common.CarDto;
import com.parking.parkinglot1.common.UserDto;
import com.parking.parkinglot1.entities.Car;
import com.parking.parkinglot1.entities.User;
import com.parking.parkinglot1.entities.UserGroup;
import jakarta.ejb.*;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class UserBean {
    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @Inject
    PasswordBean passwordBean;

    @PersistenceContext
    EntityManager entityManager;

    public List<UserDto> findAllUsers(){
        LOG.info("findAllUsers");
        try{
            TypedQuery<User> typedQuery = entityManager.createQuery("SELECT u FROM User u", User.class);
            List<User> users = typedQuery.getResultList();
            return copyUsersToDto(users);
        }catch (Exception ex){
            throw new EJBException(ex);
        }
    }

    private List<UserDto> copyUsersToDto(List<User> users){
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : users){
            UserDto userDtoEntry = new UserDto(user.getName(), user.getEmail(), user.getId(), user.getPassword());
            userDtoList.add(userDtoEntry);
        }
        return userDtoList;
    }

    public void createUser(String username, String email, String password,
                           Collection<String> groups) {
        LOG.info("createUser");
        User newUser = new User();
        newUser.setName(username);
        newUser.setEmail(email);
        newUser.setPassword(passwordBean.convertToSha256(password));
        entityManager.persist(newUser);
        assignGroupsToUser(username, groups);
    }
    private void assignGroupsToUser(String username, Collection<String>
            groups) {
        LOG.info("assignGroupsToUser");
        for (String group : groups) {
            UserGroup userGroup = new UserGroup();
            userGroup.setUsername(username);
            userGroup.setUserGroup(group);
            entityManager.persist(userGroup);
        }
    }
}
