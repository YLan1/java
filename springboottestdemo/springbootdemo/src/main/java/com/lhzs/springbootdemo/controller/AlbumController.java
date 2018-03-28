package com.lhzs.springbootdemo.controller;

import com.lhzs.springbootdemo.model.AlbumPathModel;
import com.lhzs.springbootdemo.model.ResponseModel;
import com.lhzs.springbootdemo.service.AlbumService;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping(value = "/user/")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @RequestMapping(value = "albumList")
    public String getAlbumList(Model model) {
        List<AlbumPathModel> albumPathModels = albumService.albumList();
        model.addAttribute("albumPathModels", albumPathModels);
        return "album_list";
    }


    @RequestMapping(value = "upload" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseModel upload(@RequestParam(value = "fileImg") MultipartFile file){
        ResponseModel response = new ResponseModel();
        if (!file.isEmpty()){
            try{
                Resource resource = new ClassPathResource("static/assets/images");
                if(resource.exists()){
                    InetAddress localHostLANAddress = getLocalHostLANAddress();
                    String absPath = resource.getURL().getPath();//获取到静态资源路径
                    String fileName = file.getOriginalFilename();
                    File f = new File(absPath , fileName);
                    BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(f));//输入输出流
                    outputStream.write(file.getBytes());
                    outputStream.flush();
                    outputStream.close();
                    //图片地址存数据库
                    AlbumPathModel albumPathModel = new AlbumPathModel();
                    File file1 = new File("assets/images",fileName);
                    String url = "http:/" +localHostLANAddress.toString() + ":8080" + "/" + file1.getPath();
                    albumPathModel.setPath(url);
                    boolean b = albumService.saveAlbum(albumPathModel);
                    if (b){
                        response.setCode(0);
                        response.setData(url);
                        response.setMessage("上传成功");
                        return response;
                    }else {
                        response.setCode(1);
                        response.setMessage("保存数据库失败");
                        return response;
                    }

                }else{
                    response.setCode(1);
                    response.setMessage("路径不存在");
                    return response;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        response.setCode(1);
        response.setMessage("上传失败,文件为空");
        return response;
    }

    //获取本机Ip
    public InetAddress getLocalHostLANAddress() throws Exception {
        try {
            InetAddress candidateAddress = null;
            // 遍历所有的网络接口
            for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
                NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
                // 在所有的接口下再遍历IP
                for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
                    InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
                    if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
                        if (inetAddr.isSiteLocalAddress()) {
                            // 如果是site-local地址，就是它了
                            return inetAddr;
                        } else if (candidateAddress == null) {
                            // site-local类型的地址未被发现，先记录候选地址
                            candidateAddress = inetAddr;
                        }
                    }
                }
            }
            if (candidateAddress != null) {
                return candidateAddress;
            }
            // 如果没有发现 non-loopback地址.只能用最次选的方案
            InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
            return jdkSuppliedAddress;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除
    @RequestMapping(value = "delete" , method = RequestMethod.GET)
    @ResponseBody
    public ResponseModel delete(@RequestParam(value = "deleteId") Integer deleteId){
        ResponseModel response = new ResponseModel();
        if (deleteId != null){
            albumService.deleteAlbum(deleteId);
            response.setCode(0);
            response.setMessage("删除成功");
            return response;
        }
        response.setCode(1);
        response.setMessage("删除失败");
        return response;
    }


}

