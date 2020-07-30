package com.protobuf.protobuftest.controller;/**
 * @author Hu MengLong
 * @date 2020/7/29 17:17
 * @version 1.0
 */
import com.google.protobuf.ByteString;
import com.protobuf.protobuftest.domain.TResult;
import com.protobuf.protobuftest.protobuf.Student;
import com.protobuf.protobuftest.service.WebSocketServer;
import com.protobuf.protobuftest.util.TResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName controller
 * @Description TODO
 * @Author Hml
 * @DATE 2020/7/29 17:17
 * @Version 1.0
 **/
@Controller
@RequestMapping("/system")
public class controller {
    @ResponseBody
    @GetMapping("/ws")
    @CrossOrigin
    public TResult pushToWeb(@RequestParam(value = "cid") String cid) throws IOException {
        //构造器
        Student.UcStudent.Builder student = Student.UcStudent.newBuilder();
        //赋值
        student.setCardId("123456789876543210");
        student.setCardType(Student.UcStudent.CardType.ABROAD);
        student.setName("兰博基尼");
        student.setCity("北京");
        student.setSex(Student.UcStudent.Sex.MALE);
        // 生成对象
        Student.UcStudent ucStudent = student.build();
        //序列化
        ByteString byteString = ucStudent.toByteString();
        //获取websocket并发送
        WebSocketServer webSocketServer=WebSocketServer.webSocketMap.get(cid);
        webSocketServer.sendMessage(byteString.toString());
        //第二种序列化方式
        byte[] bytes = ucStudent.toByteArray();
        System.out.println("发送的数据:"+byteString+",第二个："+ bytes.length);
        return TResultUtils.success();
    }
}
