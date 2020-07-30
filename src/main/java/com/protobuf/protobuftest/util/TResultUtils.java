package com.protobuf.protobuftest.util;


import com.protobuf.protobuftest.domain.ResultCodeEnum;
import com.protobuf.protobuftest.domain.TResult;

/**
 * Created by yc
 * 2017-11-23 14:21
 */
public class TResultUtils {

//    static Logger logger = LoggerFactory.getLogger("TResultUtils");

    public static TResult success(Object object) {
        TResult tResult = new TResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg(), object);
        return tResult;
    }

    public static TResult success() {
        return success(ResultCodeEnum.SUCCESS.getMsg());
    }

    public static TResult success(String msg) {
        return success(ResultCodeEnum.SUCCESS.getCode(), msg);
    }


    public static TResult success(Integer code, String msg) {
        return response(code, msg);
    }

    public static TResult success(Integer code, String msg, Object data) {
        return response(code, msg, data);
    }


    public static TResult error(Integer code, String msg) {
        return response(code, msg);
    }

    /**
     * fj添加
     *
     * @param resultCodeEnum
     * @return
     */
    public static TResult error(ResultCodeEnum resultCodeEnum) {
        return response(resultCodeEnum.getCode(), resultCodeEnum.getMsg());
    }

    public static TResult error(ResultCodeEnum resultCodeEnum, Object data) {
        return response(resultCodeEnum.getCode(), resultCodeEnum.getMsg(), data);
    }

    public static TResult error(Integer code, String msg, Object data) {
        return response(code, msg, data);
    }

    public static TResult response(Integer code, String msg) {
        TResult tResult = new TResult(code, msg, null);
//        logger.info(tResult.toString());
        return tResult;
    }

    public static TResult response(Integer code, String msg, Object data) {
        TResult tResult = new TResult(code, msg, data);
//        logger.info(tResult.toString());
        return tResult;
    }
}
