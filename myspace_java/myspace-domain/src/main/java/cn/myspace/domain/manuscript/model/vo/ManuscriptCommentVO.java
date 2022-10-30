package cn.myspace.domain.manuscript.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * (ManuscriptComment)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManuscriptCommentVO implements Serializable {
    private static final long serialVersionUID = -43379738783553403L;

    private Long commentId;
    /**
     * 为0表示帖子内的一条评论，否则为子评论
     */
    private Long parentCommentId;

    /**
     * 为0表示帖子内的一条评论，否则为子评论
     */
    private Integer index;

    private Long manuscriptId;
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
    private List<ManuscriptCommentVO> comments;
}