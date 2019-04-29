package com.tnbdc.controller;

import com.tnbdc.entities.*;
import com.tnbdc.service.DemoService;
import com.tnbdc.utils.CommonUseUtil;
import com.tnbdc.utils.ResultUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/tnbdc")
public class TnbdcController {
    @Resource
    private DemoService demoService;

    @RequestMapping(value = "userRegister", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "用户注册")
    public Msg userRegister(@RequestBody Users users){
        try {
            //查看用户名是否存在
            Users u = demoService.getUsersByUsername(users);
            if(u!=null){
                return ResultUtil.error("用户名已存在");
            }
            MessageDigest md5;
            String temp = "";
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base = new BASE64Encoder();
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            users.setSat(uuid);
            String pwd=users.getPassword()+uuid;
            temp = base.encode(md5.digest(CommonUseUtil.getURLDecoderString(pwd).getBytes()));
            users.setPassword(temp);
            int flag=demoService.userRegister(users);
            if(flag>0)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "login", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "username", value = "用户名", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "password", value = "密码", required = false)
    })
    public Msg login(@RequestParam(value = "username",required = false) String username,
                     @RequestParam(value = "password",required = false) String password){
        try {
            //查看用户名是否存在
            Users u = demoService.getUserByUsername(username);
            if(u==null){
                return ResultUtil.error("用户名不存在");
            }
            MessageDigest md5;
            String temp = "";
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base = new BASE64Encoder();

            String pwd=password+u.getSat();
            temp = base.encode(md5.digest(CommonUseUtil.getURLDecoderString(pwd).getBytes()));

            if(u.getPassword().equals(temp)){
                u.setSat(" ");u.setPassword(" ");
                return ResultUtil.success(u);
            }else{
                return ResultUtil.error("密码错误");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("登陆失败，接口异常");
        }
    }


    @RequestMapping(value = "restPassword", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "重置密码，提供（姓名、出生日期、联系电话、新密码）")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "username", value = "用户名", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "name", value = "姓名", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "csrq", value = "出生日期", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "lxdh", value = "联系电话", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "password", value = "新密码", required = false)
    })
    public Msg restPassword(@RequestParam(value = "username",required = false) String username,
                            @RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "csrq",required = false) String csrq,
                            @RequestParam(value = "lxdh",required = false) String lxdh,
                            @RequestParam(value = "password",required = false) String password){
        try {
            //查看用户名是否存在
           /*
*/
            Users u = demoService.getUserByUsername(username);
            if(!u.getName().equals(name)){
                return ResultUtil.error("姓名错误");
            }
            if(!u.getCsrq().equals(csrq)){
                return ResultUtil.error("出生日期错误");
            }
            if(!u.getLxdh().equals(lxdh)){
                return ResultUtil.error("联系电话错误");
            }

            MessageDigest md5;
            String temp = "";
            md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base = new BASE64Encoder();
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            Map<String, String> param = new HashMap<String, String>();
            param.put("username",username);
            param.put("sat",uuid);

            String pwd=password+uuid;
            temp = base.encode(md5.digest(CommonUseUtil.getURLDecoderString(pwd).getBytes()));
            param.put("password",temp);

            int i = demoService.restPassword(param);

            if(i>0){
                return ResultUtil.success("密码重置成功");
            }else{
                return ResultUtil.error("密码重置失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("密码重置失败，接口异常");
        }
    }


    @RequestMapping(value = "addDcwjda", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加调查问卷答案")
    public Msg addDcwjda(@RequestBody Dcwj dcwj){
        try {

            boolean flag=demoService.addDcwjda(dcwj);
            if(flag)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "editDcwjda", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "修改调查问卷答案")
    public Msg editDcwjda(@RequestBody Dcwj dcwj){
        try {
            //编辑
            boolean flag=demoService.addDcwjda(dcwj);
            if(flag)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }

    @RequestMapping(value = "getDcwjdas", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "查询调查问卷答案")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "username", value = "用户名", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "wzid", value = "文章id", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "mkid", value = "模块id", required = false),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "th", value = "题号", required = false)
    })
    public Msg getDcwjdas(@RequestParam(value = "username",required = false) String username,
                         @RequestParam(value = "wzid",required = false) String wzid,
                         @RequestParam(value = "mkid",required = false) String mkid,
                         @RequestParam(value = "th",required = false) String th){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("username",username);
            param.put("wzid",wzid);
            param.put("mkid",mkid);
            param.put("th",th);
            List<Dcwjda> list=demoService.getDcwjdas(param);
                return ResultUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }


    @RequestMapping(value = "addFwWzTotle", method = RequestMethod.POST, produces = "application/json")
    @ApiOperation(value = "添加文章访问次数")
    public Msg addFwWzTotle(@RequestBody FwWzTotle fwWzTotle){
        try {

            boolean flag=demoService.addFwWzTotle(fwWzTotle);
            if(flag)
                return ResultUtil.success("保存成功");
            else
                return ResultUtil.error("保存失败");
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("保存失败，接口异常");
        }
    }


    @RequestMapping(value = "getFwWzTotle", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "查询文章访问次数")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType="query", dataType = "String", name = "username", value = "用户名", required = true),
            @ApiImplicitParam(paramType="query", dataType = "String", name = "mkid", value = "模块id", required = false),
    })
    public Msg getFwWzTotle(@RequestParam(value = "username",required = true) String username,
                          @RequestParam(value = "mkid",required = false) String mkid){
        try {
            Map<String, String> param = new HashMap<String, String>();
            param.put("username",username);
            param.put("mkid",mkid);
            List<FwWzTotle> list=demoService.getFwWzTotle(param);
            return ResultUtil.success(list);
        }catch (Exception e){
            e.printStackTrace();
            return ResultUtil.error("查询失败，接口异常");
        }
    }



}
