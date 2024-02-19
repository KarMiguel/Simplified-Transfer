package org.example.service;

import org.example.domain.user.User;
import org.example.domain.user.UserType;
import org.example.dtos.UserDTO;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User send, Double amount) throws Exception {
        if(send.getUserType() == UserType.MERCHANT){
            throw new Exception("Usuário do tipo lojista não esta autorizado fazer transação");
        }if(send.getBalance().compareTo(amount) < 0){
            throw new Exception("Saldo Insuficinete");
        }
    }

    public User findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(()->
                new Exception("Usuario não Encontrado..."));
    }

    public  User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return  newUser;
    }
    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public List<User> listUser(){
        return  this.userRepository.findAll();
    }

}
