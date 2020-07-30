package com.protobuf.protobuftest.domain;

public enum ResultCodeEnum {
    //成功
    SERVER_ERROR(-2, "服务出错"),
    FAIL(-1, "失败"),
    ILL_CONDITIONED(-1, "条件不足"),
    SUCCESS(0, "成功"),
    VALIDATE_OK(0, "校验成功"),
    REGISTER_OK(0, "注册成功"),

    //错误与失败
    VALIDATE_ERR(1, "校验错误"),
    VALIDATE_FAIL(2, "校验失败"),
    MOBILE_EXIST(3, "手机号已存在"),
    TACCOUNT_EXIST(4, "账号已存在"),
    PARAM_ERR(5, "参数错误"),
    REGISTER_FAIL(6, "注册失败"),
    USER_NOT_EXS(7, "用户不存在"),
    VALIDATE_CODE_EMPTY(8, "验证码为空"),
    NOT_NUM(9, "不是数字"),
    PARAM_EMPTY(10, "参数为空"),
    ADD_FAIL(11, "添加失败"),
    UPDATE_FAIL(12, "修改失败"),
    QUERY_FAIL(13, "暂无数据"),
    DELETE_FAIL(14, "删除失败"),
    CATECODE_ERR(15, "分类码错误"),

    ADD_USER_NAME_PWD_ERROR(16, "添加用户名和头像失败"),
    UPDATE_AVATAR_ERROR(17, "修改头像失败"),
    JSONPARSE_ERR(18, "发生json解析错误"),

    DUPLICATE_USER(19, "已经有相同的用户，请检查手机号码和身份证"),

    IOEXCEPTION(20, "IO错误"),

    REFRESH_TOKEN_INVALID(21, "refreshToken无效"),
    QUESTION_CATE_EXSIST(22, "检测到已经添加该问题分类"),
    FILE_UPLOAD_EXCEPTION(23, "文件上传错误"),

    QUERY_STUDENT_CLASS_ERROR(24, "无法获得学员班级信息"),

    PAY_PRISE_FORMAT_ERROR(25, "价钱格式错误"),
    PAY_PRISE_FORMAT_ZEOR_ERROR(26, "请求金额不能为0"),
    PAY_WECHAT_PREORDER_ERROR(27, "微信统一下单请求失败"),
    PAY_WECHAT_PREORDER_HTTP_ERROR(28, "微信统一下单http请求失败"),
    PAY_WECHAT_ORDER_EXIST(29, "订单已存在，请前往订单列表支付"),

    APPOINT_MENT_EXSIST(30, "已经预约过该课程了"),

    IDENTITY_EXIST(31, "身份证号已存在"),
    RESULT_EMPTY(32, "暂无数据"),
    ALREADY_EXIST(33, "已存在"),
    DELETE_TOKEN_FAIL(34, "注销旧令牌失败"),
    AUTH_FAIL(35, "认证失败"),
    CAN_NOT_CANCEL(36, "不允许取消"),
    QUESTION_CATE_REQUIRED(37, "请选择问题分类"),
    WECHAT_NO_LOGIN(38, "微信未登录"),

    INVALIDATE_FILE_TYPE(102, "文件格式非法"),
    SEND_FAIL(104, "发送失败"),

    INVALID_TOKEN(401, "访问令牌无效"),
    LOGIN_FAIL(402, "登录失败"),
    ACCESS_DENIED(403, "无权限被拒"),
    NOT_FOUND(404, "资源不存在"),
    TOKEN_REQUIRED(405, "需要访问令牌"),
    INVALID_REFRESH_TOKEN(406, "刷新令牌无效"),
    PASSWORD_ERROR(407, "密码错误"),
    USER_NOT_EXSIST(408, "用户不存在"),
    OAUTH2_CLIENT_ERROR(409, "client信息有误"),
    OAUTH2_CLIENT_SECRET_ERROR(410, "clientSecret不匹配"),
    OAUTH2_CLIENT_ID_ERROR(411, "clientId不存在"),

    ZUUL_FILTER_ERROR(500, "服务出错"),
    UNKNOWN_STATUS(600, "未知状态"),
    SOCIAL_UNBIND(602, "社交帐号未绑定"),
    SOCIAL_ERR(603, "社交登录出错"),
    MICRO_SERVICE_UNAVAILABLE(40001, "微服务不可用"),

    //常见运行时异常
    DATA_ACCESS_EXCEPTION(40002, "数据库操作失败"),
    COMMUNICATIONS_EXCEPTION(40003, "数据库连接中断"),
    NULLPOINTER_EXCEPTION(40004, "空指针异常"),
    IO_EXCEPTION(40005, "IO异常"),
    CLASS_NOT_FOUND_EXCEPTION(40006, "指定的类不存在"),
    ARRAY_INDEX_OUT_OF_BOUNDS_EXCEPTION(40007, "数组下标越界"),
    ILLEGAL_ARGUMENT_EXCEPTION(40008, "参数错误或非法"),
    CLASS_CAST_EXCEPTION(40009, "类型强制转换错误"),
    SQL_EXCEPTION(40010, "操作数据库异常"),
    SECURITY_EXCEPTION(40011, "违背安全原则异常"),
    NO_SUCH_METHOD_EXCEPTION(40012, "方法未找到异常"),
    CONNECT_EXCEPTION(40013, "服务器连接异常"),
    PARSE_EXCEPTION(40013, "服务器连接异常"),
    TOO_MANY_ITEMS(40014,"数据过载"),
    NONCONFORMITY(40016,"题库题目数量不符合要求"),
    SCOREERROR(40017,"分数错误，请检查您的总分数以及合格分数"),
    POLICYDUPLICATION(40018,"您的策略重复"),
    APPLIED_FOR_EXAMINATION(40019,"您的考试资格已使用"),
    NOT_PURCHASED(40020, "您并未购买，请购买后使用"),
    APPLYID_ISNULL(40021,"APPLY_ID为空"),
    //特殊处理的指令
    CUSTOM_CODE(40015, "");

    /**
     * 0为成功
     */
    private Integer code;
    private String msg;

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
