//package apap.tutorial.gopud.service;
//
////import apap.tutorial.gopud.model.UserModel;
////import apap.tutorial.gopud.repository.UserDB;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.validation.constraints.Null;
//
//@Service
//@Transactional
//public class UserServiceImpl implements UserService{
//    @Autowired
//    private UserDB userDB;
//    @Override
//    public UserModel addUser(UserModel user) {
//        String pass = encrypt(user.getPassword());
//        user.setPassword(pass);
//        return userDB.save(user);
//    }
//
//    @Override
//    public String encrypt(String password) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
//        return hashedPassword;
//    }
//
//    @Override
//    public UserModel getUserByUsername(String username) {
//
//        return userDB.findByUsername(username);
//    }
//
//    @Override
//    public boolean validatePassword(String password) {
//        boolean isDigit=false;
//        boolean isHuruf=false;
//        if(password.length()<8){
//
//        }
//        for(int i =0;i<password.length();i++){
//            if(Character.isDigit(password.charAt(i))){
//                isDigit = true;
//            }
//            if(Character.isAlphabetic(password.charAt(i))){
//                isHuruf=true;
//            }
//        }
//        if(isDigit==false||isHuruf==false){
//            return false;
//        }
//        else{
//            return true;
//        }
//    }
//
//}
