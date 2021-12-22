package com.example.SpringDemo.service;

import com.example.SpringDemo.model.UserEntity;
import com.example.SpringDemo.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

@Autowired
    UserRepo userRepo;

public List<UserEntity> showAllusers(){            // Read
    return userRepo.findAll();
}

public UserEntity findUserByName(String name){     //Read (by name)
List<UserEntity> userEntityList = new ArrayList<>();

userEntityList = userRepo.findAll(); //Assigning to data to arraylist

    for(UserEntity userEntity:userEntityList){

        if(userEntity.getName()==name){
            return userEntity;
        }
    }
    return null;
} //end of findUserByName(String name);


    public List<UserEntity> deleteUserByName(String name){ //delete user by name

    List<UserEntity> userEntityList = new ArrayList<>();
    userEntityList = userRepo.findAll();
    for(UserEntity user:userEntityList){
        if(user.getName()==name){
            userRepo.delete(user);
            return userRepo.findAll();
        }
    }

    return null;
}

    public List<UserEntity> deleteUserById(Long id){   //Delete by id
    Optional<UserEntity> userEntityOptional = userRepo.findById(id);
    if(userEntityOptional.isPresent()){
        userRepo.delete(userEntityOptional.get());
        System.out.println("User Deleted Successfully!");
        return userRepo.findAll();
    }
    return null;
    }


public UserEntity createUserEntity(UserEntity userEntity){ //Create

   return userRepo.save(userEntity);
}
public UserEntity updateUserEntity(UserEntity userEntity){ //update

return userRepo.save(userEntity); // create and update functions both use userRepo.save(T) method.
                                  // the reason is due to the use annontations.
                                  // putmapping for update.
                                  // getmapping for create.
}
}
