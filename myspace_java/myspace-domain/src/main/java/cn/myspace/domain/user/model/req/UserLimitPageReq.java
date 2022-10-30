package cn.myspace.domain.user.model.req;


import cn.myspace.common.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 分页查询请求对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLimitPageReq extends PageRequest {

    private Long userId;

    private String email;

    private String username;

    /* 用于时间范围搜索 */
    private Date startTime;
    private Date endTime;

    /* 用于排序（默认不排序） */
    private String order;
    private String orderType;

    public UserLimitPageReq(String page, String rows) {
        super(page, rows);
    }

    public UserLimitPageReq(int page, int rows) {
        super(page, rows);
    }
}
