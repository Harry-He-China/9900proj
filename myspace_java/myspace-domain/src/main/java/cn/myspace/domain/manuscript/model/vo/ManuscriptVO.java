package cn.myspace.domain.manuscript.model.vo;

import cn.myspace.domain.goods.model.vo.GoodsVO;
import cn.myspace.domain.user.model.vo.UserCoinsVO;
import cn.myspace.domain.user.model.vo.UserRewardVO;
import cn.myspace.domain.user.model.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * (Manuscript)值对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManuscriptVO implements Serializable {
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
    private List<UserVO> likeUserList;
    /**
     * 踩
     */
    private Long dislike;
    /**
     * 点踩用户列表
     */
    private List<UserVO> dislikeUserList;
    /**
     * 收藏
     */
    private Long favourite;
    /**
     * 收藏用户列表
     */
    private List<UserVO> favouriteUserList;
    /**
     * 投币
     */
    private BigDecimal coins;
    /**
     * 投币列表
     */
    private List<UserCoinsVO> coinsUserList;
    /**
     * 打赏
     */
    private BigDecimal reward;
    /**
     * 打赏列表
     */
    private List<UserRewardVO> rewardUserList;
    /**
     * 帖子评论列表
     */
    private List<ManuscriptCommentVO> manuscriptComments;
    /**
     * 关联商品列表
     */
    private List<GoodsVO> goods;
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