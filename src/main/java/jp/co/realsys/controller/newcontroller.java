package jp.co.realsys.controller;

import jp.co.realsys.model.user;
import jp.co.realsys.service.impl.UserDBServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value ="newcontroller")
public class newcontroller {

    @Autowired
    private UserDBServiceImpl userDBService;

    @RequestMapping(params = "act=query")
    public String query(String username, String sex, Model model){
        user u=new user();
        u.setName(username);
        u.setSex(sex);
        List<user> querUser=userDBService.getStudentByNameOrSex(u);
        List<Integer> sexlist=userDBService.getAllSex();
        sexlist.add(0,-1);
        if(sex!=null&&sex!=""){
            sexlist.remove(Integer.valueOf(sex));
            sexlist.add(0, Integer.valueOf(sex));
        }
        if(querUser!=null&&querUser.size()>0) {
            model.addAttribute("userList", querUser);
        }
        model.addAttribute("name",username);
        model.addAttribute("sexlist",sexlist);
        return "velocityTest" ;
    }
    @RequestMapping(params = "act=delete")
    public String delete(Integer id,String username, String sex,Model model){
        if(id==null||"".equals(id)){
            return "errero";
        }
        user u=new user();
        u.setId(id);
        try {
            int i = userDBService.doDeleteUSER(u);
            if (i == -1) {
                return "errero";
            }
        }catch (Exception e){
            return "errero";
        }
        //重新查询
       /* user u1=new user();
        u1.setName(username);
        u1.setSex(sex);
        List<user> querUser=userDBService.getStudentByNameOrSex(u1);
        List<Integer> sexlist=userDBService.getAllSex();
        sexlist.add(0,-1);
        if(sex!=null&&sex!=""){
            sexlist.remove(Integer.valueOf(sex));
            sexlist.add(0, Integer.valueOf(sex));
        }
        if(querUser!=null&&querUser.size()>0) {
            model.addAttribute("userList", querUser);
        }
        model.addAttribute("name",username);
        model.addAttribute("sexlist",sexlist);*/
        return "redirect:newcontroller?act=query" ;
    }
    @RequestMapping(params = "act=add")
    public String add(String username, String sex,String age,Model model){
        user u=new user();
        u.setSex(sex);
        u.setName(username);
        u.setAge(age);
        int i=userDBService.doRegisterUSER(u);
        if(i==-1){
            return "errero";
        }
        //重新查询
        user u1=new user();
        List<user> querUser=userDBService.getStudentByNameOrSex(u1);
        List<Integer> sexlist=userDBService.getAllSex();
        sexlist.add(0,-1);
        if(sex!=null&&sex!=""){
            sexlist.remove(Integer.valueOf(sex));
            sexlist.add(0, Integer.valueOf(sex));
        }
        if(querUser!=null&&querUser.size()>0) {
            model.addAttribute("userList", querUser);
        }
        model.addAttribute("name",username);
        model.addAttribute("sexlist",sexlist);
        return "velocityTest" ;
    }
    @RequestMapping(value= "/retuanadd")
    public String add(){

        return "add" ;
    }
}
