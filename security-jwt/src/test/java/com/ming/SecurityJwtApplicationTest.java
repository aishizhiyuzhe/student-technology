package com.ming;

import com.ming.common.utils.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityJwtApplicationTest {

    @Resource
    JwtUtil jwtUtil;

    public String  createToken(){
        Map map=new HashMap();
        map.put("userName","ming");
        map.put("createDate",new Date());
        return jwtUtil.createToken(map);
    }


    @Test
    public void  getUserMessage(){
        String token=createToken();
        jwtUtil.getUserMessage(token);

    }


}
