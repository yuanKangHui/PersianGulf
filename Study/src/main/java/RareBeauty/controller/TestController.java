package RareBeauty.controller;

import RareBeauty.entity.redisdomain.UsageLog;
import RareBeauty.service.RedisService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: ykh
 * @Date: 2023-02-02-16:59
 * @Description: 实验控制类
 */
@RestController
public class TestController {
    @Resource
    private RedisService redisService;

    @GetMapping("/yal")
    public String Hello() {
        return "你好呀🙂";
    }

    @GetMapping("/redis/{name}")
    public List<UsageLog> FindByFirstName(@PathVariable("name") String name){
        System.out.println("缓存");
        return redisService.findUsageLogByName(name);
    }
}
