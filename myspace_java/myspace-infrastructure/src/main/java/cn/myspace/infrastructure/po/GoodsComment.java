package cn.myspace.infrastructure.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (GoodsComment)实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsComment implements Serializable {
    private static final long serialVersionUID = 174357195886727358L;

    private Long commentId;
    /**
     * 为0表示帖子内的一条评论，否则为子评论
     */
    private Long parentCommentId;
    /**
     * 为0表示帖子内的一条评论，否则为子评论
     */
    private Integer index;
    /**
     * 为0表示子评论，否则为帖子内的一条评论
     */
    private Long orderId;

    private Long goodsId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 创建者
     */
    private Long creator;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0表示已发布，1表示删除）
     */
    private Integer deleteMark;

    /**
     * 集合
     */

    private List<GoodsComment> comments;
}