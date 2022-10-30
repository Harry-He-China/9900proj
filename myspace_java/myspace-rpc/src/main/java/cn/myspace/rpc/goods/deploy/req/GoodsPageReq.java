package cn.myspace.rpc.goods.deploy.req;


import cn.myspace.common.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分页查询请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsPageReq extends PageRequest implements Serializable {

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

    public GoodsPageReq(int page, int rows) {
        super(page, rows);
    }

    public GoodsPageReq(String page, String rows) {
        super(page, rows);
    }
}
