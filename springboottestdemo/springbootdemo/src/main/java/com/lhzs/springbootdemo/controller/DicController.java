package com.lhzs.springbootdemo.controller;

import com.lhzs.springbootdemo.model.DicModel;
import com.lhzs.springbootdemo.model.ResponseModel;
import com.lhzs.springbootdemo.service.DicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/user/")
public class DicController {

    @Autowired
    private DicService dicService;

    //字典
    //字典列表
    @RequestMapping(value = "managerList")
    public String getManagerList(Model model){
        return "manager_list";
    }

    //字典分页列表
    @RequestMapping(value = "managerListByPage")
    @ResponseBody
    public ResponseModel getManagerListByPage(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size){
        ResponseModel responseModel = new ResponseModel();
        PageRequest pageRequest = PageRequest.of(page-1, size);
        Page<DicModel> managerListByPage = dicService.getManagerListByPage(pageRequest);
       // responseModel.setData(managerListByPage.getContent())
        responseModel.setDataInfoModel(managerListByPage);
        responseModel.setMessage("查询成功");
        responseModel.setCode(0);
        return responseModel;
    }


    //保存或更新字典数据
    @RequestMapping(value = "saveManager")
    @ResponseBody
    public ResponseModel saveManager(DicModel dicModel, @RequestParam(value = "managerId", required = false) String managerId){
        ResponseModel responseModel = new ResponseModel();
        if (dicModel != null){
            if (managerId != null){
                DicModel manager = dicService.getManager(Integer.parseInt(managerId));
                dicModel.setId(Integer.parseInt(managerId));
                dicModel.setCreateTime(manager.getCreateTime());
                boolean upDataManager = dicService.upDataManager(dicModel);
                if (upDataManager){
                    responseModel.setCode(0);
                    responseModel.setMessage("提交成功");
                }else {
                    responseModel.setCode(1);
                    responseModel.setMessage("提交失败");
                }
            }else {
                boolean saveManager= dicService.saveManagerInfo(dicModel);
                if (saveManager){
                    responseModel.setCode(0);
                    responseModel.setMessage("提交成功");
                }else {
                    responseModel.setCode(1);
                    responseModel.setMessage("提交失败");
                }
            }
        }else {
            responseModel.setCode(1);
            responseModel.setMessage("请完善信息后再提交");
        }
        return responseModel;
    }

    //获取一条字典信息
    @RequestMapping(value = "addManager")
    public String getManager(@RequestParam(value = "managerId", required = false) Integer managerId, Model model){
        DicModel dicModel = dicService.getManager(managerId);
        model.addAttribute("manager",dicModel);
        return "addmanager";
    }

    //删除字典
    @RequestMapping(value = "deleManager")
    @ResponseBody
    public ResponseModel deleManager(@RequestParam(value = "delManagerId", required = false) String delManagerId){
        ResponseModel responseModel = new ResponseModel();
        boolean deleManager= dicService.deleManager(delManagerId);
        if (deleManager){
            responseModel.setCode(0);
            responseModel.setMessage("删除成功");
        }else {
            responseModel.setCode(1);
            responseModel.setMessage("删除失败");
        }
        return responseModel;
    }
}
