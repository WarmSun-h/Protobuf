package com.protobuf.protobuftest.util;/**
 * @author Hu MengLong
 * @date 2020/7/29 9:49
 * @version 1.0
 */

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.protobuf.protobuftest.protobuf.PersonTestProtos;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @ClassName Test
 * @Description TODO
 * @Author Hml
 * @DATE 2020/7/29 9:49
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        try {
            /** Step1：生成 personTest 对象 */
            // personTest 构造器
            PersonTestProtos.PersonTest.Builder personBuilder = PersonTestProtos.PersonTest.newBuilder();
            // personTest 赋值
            personBuilder.setName("Jet Chen");
            personBuilder.setEmail("ckk505214992@gmail.com");
            personBuilder.setSex(PersonTestProtos.PersonTest.Sex.MALE);

            // 内部的 PhoneNumber 构造器
            PersonTestProtos.PersonTest.PhoneNumber.Builder phoneNumberBuilder = PersonTestProtos.PersonTest.PhoneNumber.newBuilder();
            // PhoneNumber 赋值
            phoneNumberBuilder.setType(PersonTestProtos.PersonTest.PhoneNumber.PhoneType.MOBILE);
            phoneNumberBuilder.setNumber("17717037257");

            // personTest 设置 PhoneNumber
            personBuilder.addPhone(phoneNumberBuilder);

            // 生成 personTest 对象
            PersonTestProtos.PersonTest personTest = personBuilder.build();

            /** Step2：序列化和反序列化 */
            // 方式一 byte[]：
            // 序列化
//            byte[] bytes = personTest.toByteArray();
            // 反序列化
//            PersonTestProtos.PersonTest personTestResult = PersonTestProtos.PersonTest.parseFrom(bytes);
//            System.out.println(String.format("反序列化得到的信息，姓名：%s，性别：%d，手机号：%s", personTestResult.getName(), personTest.getSexValue(), personTest.getPhone(0).getNumber()));



//             方式二 ByteString：
//             序列化
            long time0=System.currentTimeMillis();
            System.out.println("=========方式2序列化开始");
            ByteString byteString = personTest.toByteString();
            System.out.println(byteString.toString());
             //反序列化
            PersonTestProtos.PersonTest personTestResult2 = PersonTestProtos.PersonTest.parseFrom(byteString);
            long time1=System.currentTimeMillis();
            long time2=time1-time0;
            System.out.println("=========方式2序列化后，时间差：" + time2 +",结果:"+personTestResult2);
//            System.out.println(String.format("反序列化得到的信息，姓名：%s，性别：%d，手机号：%s", personTestResult2.getName(), personTest.getSexValue(), personTest.getPhone(0).getNumber()));



            // 方式三 InputStream
            // 粘包,将一个或者多个protobuf 对象字节写入 stream
            // 序列化
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            personTest.writeDelimitedTo(byteArrayOutputStream);
            // 反序列化，从 steam 中读取一个或者多个 protobuf 字节对象
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            PersonTestProtos.PersonTest personTestResult = PersonTestProtos.PersonTest.parseDelimitedFrom(byteArrayInputStream);
            System.out.println(String.format("反序列化得到的信息，姓名：%s，性别：%d，手机号：%s", personTestResult.getName(), personTest.getSexValue(), personTest.getPhone(0).getNumber()));
        }catch (InvalidProtocolBufferException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
