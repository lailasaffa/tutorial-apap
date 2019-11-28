//package apap.tutorial.gopud.controller;
//
//import apap.tutorial.gopud.model.UserModel;
//import apap.tutorial.gopud.repository.UserDB;
//import apap.tutorial.gopud.service.RoleService;
//import apap.tutorial.gopud.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private RoleService roleService;
//
//    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
//    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
//        String password = user.getPassword();
//        boolean isValid = userService.validatePassword(password);
//        if(isValid==true){
//            userService.addUser(user);
//            model.addAttribute("addUser","User Berhasil Ditambahkan");
//        }else{
//            model.addAttribute("addUser","User Gagal Ditambahkan");
//        }
//        model.addAttribute("title","Tutorial APAP");
//        model.addAttribute("listRole",roleService.findAll());
//        return "home";
//    }
//    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
//    private String changePassword(String oldPass,String newPass,String confirmPass,
//            @ModelAttribute UserModel user, Model model
//    ){
//        UserModel updateUser = userService.getUserByUsername(user.getUsername());
//        boolean newPassValid = userService.validatePassword(newPass);
//        boolean oldPassValid = userService.validatePassword(oldPass);
//        boolean confirmPassValid = userService.validatePassword(confirmPass);
//        if(newPassValid && oldPassValid && confirmPassValid){
//            if(confirmPass.equals(newPass)){
//                if(oldPass.equals(newPass)){
//                    model.addAttribute("changePassword","Password Gagal Diubah");
//                }else{
//                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//                    boolean isMatch = passwordEncoder.matches(oldPass,updateUser.getPassword());
//                    if(isMatch==true){
//                        updateUser.setPassword(newPass);
//                        userService.addUser(updateUser);
//                        model.addAttribute("changePassword","Password Berhasil Diubah");
//                    }
//                }
//            }
//            else{
//                model.addAttribute("changePassword","Password Gagal Diubah");
//            }
//        }else{
//            model.addAttribute("changePassword","Password Gagal Diubah");
//        }
//        model.addAttribute("title","Update Password");
//        return "home";
//    }
//
//}
