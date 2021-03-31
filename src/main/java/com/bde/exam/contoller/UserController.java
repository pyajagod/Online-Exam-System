package com.bde.exam.contoller;

import com.bde.exam.model.UserModel;
import com.bde.exam.service.Impl.UserServiceImpl;
import com.bde.exam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService = new UserServiceImpl();

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/add")
    public String toAdd(Model model,String userId, String userName, String userSex, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date userBirthday, String userPwd, String pwdQues, String pwdAns, String userProfession, String userProsition){
        UserModel user = new UserModel(Integer.parseInt(userId), userName, userSex, userBirthday, userPwd, pwdQues, pwdAns, userProfession, userProsition);
        if (userService.isExit(user)){
            model.addAttribute("error", "此用户已经存在");
            return "register";
        }

        userService.addUser(user);
        model.addAttribute("msg", "注册成功，欢迎登录");
        model.addAttribute("userId", userId);
        model.addAttribute("userPwd", userPwd);
        return "login";

    }
    /*
          后期仍需优化
     */
    @RequestMapping("/check")
    public String toCheck(Model model, String userId, String userPwd){
        if ("".equals(userId) || "".equals(userPwd)){
            model.addAttribute("data", "用户名或密码不能为空");
            return "login";
        }else {
            UserModel user = new UserModel();
            int id = Integer.parseInt(userId);
            user.setUserId(id);
            UserModel userModel = userService.queryUser(user);
//        System.out.println(userModel);
//        System.out.println(userModel.getUserId());
            if (userModel != null){
                if (userPwd.equals(userModel.getUserPwd())){
                    model.addAttribute("userId", userId);
                    model.addAttribute("userName", userModel.getUserName());
                    model.addAttribute("userIsAdmin", userModel.getUserProsition());
//                    System.out.println(userModel.getUserProsition());
                    model.addAttribute("msg", "欢迎登录!");
                    return "examinations";
                }else {
                    model.addAttribute("data", "用户名或密码错误");
                    return "login";
                }
            }else {
                model.addAttribute("data", "该用户不存在");
                return "login";
            }
        }

    }

    @RequestMapping("/update")
    public String toUpdate(Model model, String userId){
        int id = Integer.parseInt(userId);
        UserModel userModel = new UserModel();
        userModel.setUserId(id);
        UserModel user = userService.queryUser(userModel);
//        System.out.println(user.getUserProsition());
        model.addAttribute("user", user);

        return "updateUser";
    }

    @RequestMapping("/updateUser")
    public String toUpdateUser(Model model,String id, String userId, String userName, String userSex, @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date userBirthday, String userPwd, String pwdQues, String pwdAns, String userProfession, String userProsition){
        UserModel user = new UserModel(Integer.parseInt(id), Integer.parseInt(userId), userName, userSex, userBirthday, userPwd, pwdQues, pwdAns, userProfession, userProsition);
        userService.updateUser(user);
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        model.addAttribute("userIsAdmain", userProsition);
        return "examinations";
    }

    @RequestMapping("/isAdmin")
    public String toIsAdmin(Model model, String userId, String userName, String userIsAdmin){
        if ("管理员".equals(userIsAdmin)){
            model.addAttribute("userId", userId);
            model.addAttribute("userName", userName);
            return "backstage";
        }else {
            model.addAttribute("msg", "您没有此权限！");
            model.addAttribute("userId", userId);
            model.addAttribute("userName", userName);
            model.addAttribute("userIsAdmin", userIsAdmin);
            return "examinations";
        }
    }

//    @ResponseBody
    @RequestMapping("/updateProtision")
    public String toUpdateProtision(Model model, String userId, String userName){
        UserModel user = new UserModel();
        user.setUserId(Integer.parseInt(userId));
        user.setUserName(userName);
        if ("普通用户".equals(userService.queryUser(user).getUserProsition())) {
            user.setUserProsition("管理员");
        }else {
            user.setUserProsition("普通用户");
        }
        userService.updateProsition(user);
        model.addAttribute("msg", "修改成功!");
        return "pika";
    }

    @RequestMapping("/show")
    public String toShow(Model model, Integer curPage){
        int pageSize = 10;
        if (curPage == null || curPage <= 0){
            curPage = 1;
        }
        int totalRows = userService.queryUserCounts();
        int totalPages = totalRows / pageSize;
        int left = totalRows % pageSize;
        if (left > 0){
            totalPages += 1;
        }

        if (curPage > totalPages){
            curPage = totalPages;
        }

        int startRow = (curPage - 1) * pageSize;

        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);

        List<UserModel> users = userService.queryUserByPage(paramMap);
        model.addAttribute("users", users);
        model.addAttribute("curPage", curPage);
        model.addAttribute("totalPages", totalPages);
        return "users";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }

}
