package com.lhzs.springbootdemo.controller;

import com.lhzs.springbootdemo.model.DicModel;
import com.lhzs.springbootdemo.model.PublicUsersModel;
import com.lhzs.springbootdemo.model.ResponseModel;
import com.lhzs.springbootdemo.service.LoginService;
import com.lhzs.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/login")
    public String login(Model model) {
        List<DicModel> dicModelList = userInfoService.getTypeManagerModelList("login_type");
        model.addAttribute("dicModelList", dicModelList);
        return "login";
    }

    @RequestMapping(value = "/loginIn")
    @ResponseBody
    public ResponseModel login(HttpServletRequest httpServletRequest, @RequestParam(value = "loginType", required = false) String loginType, @RequestParam(value = "username", required = false) String name, @RequestParam(value = "password", required = false) String paw, Model model) {

        ResponseModel responseModel = new ResponseModel();
        boolean checkName = loginService.checkName(name);
        boolean checkNameWithType = loginService.checkNameWithType(name, loginType);
        boolean checkPaw = loginService.login(name, paw);

        if (!checkName) {
            responseModel.setCode(1);
            responseModel.setMessage("用户未注册");
        }
        else if (checkName && !checkNameWithType){
            responseModel.setCode(1);
            responseModel.setMessage("用户类型错误");
        }
        else if (checkName && checkNameWithType && !checkPaw) {
            responseModel.setCode(1);
            responseModel.setMessage("密码错误");
        }
        else if (checkName && checkPaw && checkNameWithType) {
            PublicUsersModel publicUsersModel = new PublicUsersModel();
            publicUsersModel.setName(name);
            publicUsersModel.setPaw(paw);
            model.addAttribute("nameandpaw", publicUsersModel);
            responseModel.setCode(0);
            responseModel.setMessage("登录成功");
            responseModel.setData(publicUsersModel);//不能删
            httpServletRequest.getSession().setAttribute("nameandpaw", publicUsersModel);//传到下一个页面index
        }
        return responseModel;
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    public ResponseModel register(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "username", required = false) String name,
            @RequestParam(value = "paw", required = false) String paw,
            @RequestParam(value = "paw2", required = false) String paw2,
            @RequestParam(value = "ok", required = false) String ok) {
        ResponseModel responseModel = new ResponseModel();
        if (name != "" && paw != "" && paw2 != "") {
            System.out.println(ok);
            if (ok != null) {
                if (paw.equals(paw2)) {
                    boolean login = loginService.checkName(name);
                    if (login) {
                        responseModel.setCode(1);
                        responseModel.setMessage("用户已注册");
                    } else {
                        boolean register = loginService.register(name, paw);
                        if (register) {
                            responseModel.setCode(0);
                            responseModel.setMessage("注册成功");
                        } else {
                            responseModel.setCode(1);
                            responseModel.setMessage("注册失败");
                        }
                    }
                } else {
                    responseModel.setCode(1);
                    responseModel.setMessage("两次输入的密码不相同");
                }
            } else {
                responseModel.setCode(1);
                responseModel.setMessage("未接受用户协议");
            }
        } else {
            responseModel.setCode(1);
            responseModel.setMessage("请填写信息");
        }
        return responseModel;
    }

    @RequestMapping(value = "/upData")
    @ResponseBody
    public ResponseModel upData(
            @RequestParam(value = "oldname", required = false) String oldname,
            @RequestParam(value = "newname", required = false) String newname,
            @RequestParam(value = "paw", required = false) String paw) {
        ResponseModel responseModel = new ResponseModel();
        if (oldname.equals(newname)) {
            boolean updata = loginService.upData(oldname, newname, paw);
            if (updata) {
                responseModel.setCode(0);
                responseModel.setMessage("重置成功");
            } else {
                responseModel.setCode(1);
                responseModel.setMessage("重置失败");
            }
        } else if (!oldname.equals(newname)) {
            boolean checkoldname = loginService.checkName(oldname);
            boolean checknewname = loginService.checkName(newname);
            if (!checkoldname) {
                responseModel.setCode(1);
                responseModel.setMessage("用户未注册");
            }
            else if (checkoldname && !checknewname) {
                boolean updata = loginService.upData(oldname, newname, paw);
                if (updata) {
                    responseModel.setCode(0);
                    responseModel.setMessage("重置成功");
                } else {
                    responseModel.setCode(1);
                    responseModel.setMessage("重置失败");
                }
            }
        }
        return responseModel;
    }
}
