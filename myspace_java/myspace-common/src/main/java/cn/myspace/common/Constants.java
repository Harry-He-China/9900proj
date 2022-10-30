package cn.myspace.common;

/**
 * 常量类
 */
public class Constants {

    public enum ResponseCode {
        SUCCESS("0000", "成功"),
        UNKNOWN_ERROR("0001", "未知失败"),
        ILLEGAL_PARAMETER("0002", "非法参数"),
        INDEX_DUP("0003", "主键冲突"),
        NO_UPDATE("0004", "SQL操作无更新"),
        UNAUTHORIZED("0005", "认证失败");

        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    /**
     * 全局属性
     */
    public static final class Global {
        public static final String UTF8 = "UTF-8";

        public static final String GBK = "GBK";
    }

    public static final class DB {

        /**
         * 0表示启用，1表示删除
         * 2表示临时启用，3表示暂时停用
         */
        public static final Integer ENABLE_MARK = 0;

        public static final Integer DELETE_MARK = 1;

        public static final Integer TEMPORARY_MARK = 2;

        public static final Integer STOP_MARK = 3;
    }

    /**
     * 1表示管理员，2表示贡献者
     * 3表示普通用户，4表示游客
     */
    public static final class Role {

        public static final Integer ADMIN = 1;

        public static final Integer CONTRIBUTOR = 2;

        public static final Integer EXPLORER = 3;

        public static final Integer GUEST = 4;
    }

    public static final class Login {
        /**
         * -1表示登录失败，
         * 0表示登录成功，
         * 1表示用户已退出
         *
         * 默认为用户无操作后 30min 自动退出登录
         */
        public static final Integer LOGIN_FAILURE = -1;
        public static final Integer LOGIN_SUCCESS = 0;

        public static final Integer LOGOUT_MARK = 1;

        public static final Integer LOGIN_EXPIRE_TIME = 30;
    }

    /**
     * 缓存 Key
     */
    public static final class RedisKey {

        // 库存 Key
        private static final String STOCK_COUNT = "stock_count_";

        public static String KEY_STOCK_COUNT(Long id) {
            return STOCK_COUNT + id;
        }

        // 库存锁 Key
        private static final String STOCK_COUNT_TOKEN = "stock_count_token_";

        public static String KEY_STOCK_COUNT_TOKEN(Long id, Integer stockUsedCount) {
            return STOCK_COUNT_TOKEN + id + "_" + stockUsedCount;
        }

        /**
         * 验证码 Key
         */
        public static final String KEY_LOGIN_CODE = "login_code:";

        public static String KEY_LOGIN_CODE_TOKEN(Long id) {
            return KEY_LOGIN_CODE + id;
        }
    }

    /**
     * 消息发送状态（0未发送、1发送成功、2发送失败）
     */
    public enum MQState {
        INIT(0, "初始"),
        COMPLETE(1, "完成"),
        FAIL(2, "失败");

        private Integer code;
        private String info;

        MQState(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

}
