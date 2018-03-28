package com.lhzs.springbootdemo.controller;

import com.lhzs.springbootdemo.model.DicModel;
import com.lhzs.springbootdemo.model.PublicUsersInfoModel;
import com.lhzs.springbootdemo.model.PublicUsersModel;
import com.lhzs.springbootdemo.model.ResponseModel;
import com.lhzs.springbootdemo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    //公众号列表
    @RequestMapping(value = "userList")
    public String getUserList(Model model, @RequestParam(value = "nav-search-input", required = false) String searchStr) {
        List<PublicUsersModel> publicUsersModelList = userInfoService.getUsersNamesModel();
        model.addAttribute("userListModel", publicUsersModelList);

        List<DicModel> typeDicModelList = userInfoService.getTypeManagerModelList("wx_type");
        model.addAttribute("typeDicModelList", typeDicModelList);
        //搜索
        if (searchStr != null){
            List<PublicUsersInfoModel> searchUserInfoList = userInfoService.searchUserInfoList(searchStr);
            model.addAttribute("getUserInfoList", searchUserInfoList);
        }else {
            List<PublicUsersInfoModel> publicUsersInfoModelList = userInfoService.getUserList();
            model.addAttribute("getUserInfoList", publicUsersInfoModelList);
        }
        return "user_list";
    }

    //获取一条公众号信息或所有public_user_id
    @RequestMapping("addUser")
    public String getUserInfo(@RequestParam(value = "userId", required = false) Integer userId, Model model) {
        List<PublicUsersModel> publicUsersModelList = userInfoService.getUsersNamesModel();
        model.addAttribute("userListModel", publicUsersModelList);
        if (userId != null) {
            PublicUsersInfoModel publicUsersInfoModel = userInfoService.getUserInfo(userId);
            model.addAttribute("userInfo", publicUsersInfoModel);

            List<DicModel> wx_type = userInfoService.getTypeManagerModelList("wx_type");
            model.addAttribute("typeDicModelList", wx_type);
        }
        return "adduser";
    }

    //保存或更新公众号信息
    @RequestMapping(value = "saveUser")
    @ResponseBody
    public ResponseModel saveUser(
            PublicUsersInfoModel publicUsersInfoModel,
            @RequestParam(value = "userId", required = false) String userId) {
        ResponseModel responseModel = new ResponseModel();
        if (publicUsersInfoModel != null) {
            if (!userId.equals("0")) {
                publicUsersInfoModel.setId(Integer.parseInt(userId));
                boolean upDataUserInfo = userInfoService.upDataUserInfo(publicUsersInfoModel);
                if (upDataUserInfo) {
                    responseModel.setCode(0);
                    responseModel.setMessage("提交成功");
                } else {
                    responseModel.setCode(1);
                    responseModel.setMessage("提交失败");
                }
            } else {
                boolean saveUserInfo = userInfoService.saveUserInfo(publicUsersInfoModel);
                if (saveUserInfo) {
                    responseModel.setCode(0);
                    responseModel.setMessage("提交成功");
                } else {
                    responseModel.setCode(1);
                    responseModel.setMessage("提交失败");
                }
            }
        } else {
            responseModel.setCode(1);
            responseModel.setMessage("请完善信息后再提交");
        }

        return responseModel;
    }

    //假删除
    @RequestMapping(value = "delUser")
    @ResponseBody
    public ResponseModel delUser(@RequestParam(value = "delUserId", required = false) Integer delUserId) {
        ResponseModel responseModel = new ResponseModel();
        boolean delUser = userInfoService.delUser(delUserId);
        if (delUser) {
            responseModel.setCode(0);
            responseModel.setMessage("删除成功");
        } else {
            responseModel.setCode(1);
            responseModel.setMessage("删除失败");
        }
        return responseModel;
    }

}
