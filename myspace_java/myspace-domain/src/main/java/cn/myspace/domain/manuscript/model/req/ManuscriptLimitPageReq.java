package cn.myspace.domain.manuscript.model.req;


import cn.myspace.common.PageRequest;
import lombok.*;

import java.util.Date;

/**
 * 帖子分页查询请求对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManuscriptLimitPageReq extends PageRequest {


    /* 用于时间范围搜索 */
    private Date startTime;
    private Date endTime;

    /* 用于排序（默认不排序） */
    private String order;
    private String orderType;
}
