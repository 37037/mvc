package cn.ahpu.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.management.ObjectName;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class uploadController {

    @RequestMapping("/upload")
    public ModelAndView upload(){
        ModelAndView mv=new ModelAndView("upload");
        return mv;
    }
    @RequestMapping("/toupload")
    public ModelAndView toupload(@RequestParam("file") MultipartFile[] files, HttpServletRequest req ,HttpSession session) throws Exception {
        if (files.length > 0) {
            for (int i = 0; i < files.length; i++) {

                String savedDir = req.getSession().getServletContext().getRealPath("pic"); //获取服务器指定文件存取路径
                File savedFile = new File(savedDir, files[i].getOriginalFilename());
                boolean isCreateSuccess = false;
                isCreateSuccess = savedFile.createNewFile();
                if (isCreateSuccess) {
                    files[i].transferTo(savedFile);  //转存文件
                }
            }
            Map<String, Object> map = new HashMap<>();
            String s = req.getContextPath()+"/"+files[1].getOriginalFilename();
            map.put("s", s);
            ModelAndView mv = new ModelAndView("toupload", map);
            return mv;

        }
        // String fileRealName = file[0].getOriginalFilename();                   //获得原始文件名;
        //String savedDir = req.getSession().getServletContext().getRealPath(""); //获取服务器指定文件存取路径
        //File savedFile = new File(savedDir,fileRealName );
//            boolean isCreateSuccess = false;
//            isCreateSuccess = savedFile.createNewFile();
//            if(isCreateSuccess){
//                    file.transferTo(savedFile);  //转存文件
//                }
//            Map<String , Object> map=new HashMap<>();
//            String s=req.getContextPath()+"/"+fileRealName;
//            map.put("s",s);
//            ModelAndView mv=new ModelAndView("toupload",map);
//            return mv;
//        }
        return new ModelAndView("error");
    }
}
