package cn.myspace.rpc.manuscript.deploy.dto;

import cn.myspace.rpc.goods.deploy.dto.GoodsDTO;
import cn.myspace.rpc.user.deploy.dto.UserCoinsDTO;
import cn.myspace.rpc.user.deploy.dto.UserDTO;
import cn.myspace.rpc.user.deploy.dto.UserRewardDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * (Manuscript)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManuscriptDTO implements Serializable {
    private static final long serialVersionUID = 392239817823106441L;

    private Long manuscriptId;
    /**
     * 标题
     */
    private String title;
    /**
     * 简介
     */
    private String intro;
    /**
     * 标签
     */
    private String tag;
    /**
     * 原料
     */
    private String ingredient;
    /**
     * 步骤
     */
    private String step;
    /**
     * 赞
     */
    private Long like;
    /**
     * 点赞用户列表
     */
    private List<UserDTO> likeUserList;
    /**
     * 踩
     */
    private Long dislike;
    /**
     * 点踩用户列表
     */
    private List<UserDTO> dislikeUserList;
    /**
     * 收藏
     */
    private Long favourite;
    /**
     * 收藏用户列表
     */
    private List<UserDTO> favouriteUserList;
    /**
     * 投币
     */
    private BigDecimal coins;
    /**
     * 投币列表
     */
    private List<UserCoinsDTO> coinsUserList;
    /**
     * 打赏
     */
    private BigDecimal reward;
    /**
     * 打赏列表
     */
    private List<UserRewardDTO> rewardUserList;
    /**
     * 帖子评论列表
     */
    private List<ManuscriptCommentDTO> manuscriptComments;
    /**
     * 关联商品列表
     */
    private List<GoodsDTO> goods;
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
     * 删除标志（0表示发布成功，1已删除，2表示临时保存，3表示稿件被退回）
     */
    private Integer deleteMark;
}