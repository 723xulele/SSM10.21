package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-10-21 19:07:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param uid
     * @return 单条数据
     */
    @GetMapping("/selectOne/{uid}")
    public User selectOne(@PathVariable("uid") int uid) {

        return this.userService.queryById(uid);
    }

    @GetMapping("/ueryAllByLimit/{offset}/{limit}")
    public List<User> ueryAllByLimit(@PathVariable("offset") int offset, @PathVariable("limit") int limit){
        //offect 第几个元素开始  limit 显示的元素个数
        return  this.userService.queryAllByLimit(offset, limit);

    }

    @GetMapping("/queryAll")
    public List<User> queryAll(){
        return this.userService.queryAll();
    }

    @PostMapping("/insert")
    public boolean insert(User user){
        return this.userService.insert(user) != null;
    }

    @PostMapping("/update")
    public List<User> update(User user){
        this.userService.update(user);
        return this.userService.queryAll();
    }

    @GetMapping("delete/{uid}")
    public boolean delete(@PathVariable("uid") int uid){
        return this.userService.deleteById(uid);
    }
}