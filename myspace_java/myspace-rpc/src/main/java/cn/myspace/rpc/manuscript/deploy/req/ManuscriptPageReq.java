package cn.myspace.rpc.manuscript.deploy.req;


import cn.myspace.common.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 帖子分页查询请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManuscriptPageReq extends PageRequest implements Serializable {

    /**
     * ERP ID，记录谁在操作
     */
    private String erpId;

    private Long userId;

    private String email;

    private String username;

    /* 用于时间范围搜索 */
    private Date startTime;
    private Date endTime;

    /* 用于排序（默认不排序） */
    private String order;
    private String orderType;

    public ManuscriptPageReq(int page, int rows) {
        super(page, rows);
    }

    public ManuscriptPageReq(String page, String rows) {
        super(page, rows);
    }
}
