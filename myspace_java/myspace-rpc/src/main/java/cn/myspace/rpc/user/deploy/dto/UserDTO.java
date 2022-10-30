package cn.myspace.rpc.user.deploy.dto;

import cn.myspace.rpc.manuscript.deploy.dto.ManuscriptDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * (User)数据传输对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO implements Serializable {

    private Long userId;

    private UserInfoDTO info;

    private RoleDTO role;

    /**
     * 注册邮箱
     */
    private String email;

    private String username;

    private String password;

    /**
     * 关注
     */
    private Integer follower;

    /**
     * 关注列表
     */
    private List<UserDTO> followerList;

    /**
     * 粉丝
     */
    private Integer funs;

    /**
     * 粉丝列表
     */
    private List<UserDTO> funsList;

    /**
     * 打赏金额
     */
    private BigDecimal selfRewardTotal;

    /**
     * 被打赏金额
     */
    private BigDecimal rewardTotal;

    /**
     * 打赏记录
     */
    private List<UserRewardDTO> selfRewardList;

    /**
     * 被打赏记录
     */
    private List<UserRewardDTO> rewardList;

    /**
     * 持币量
     */
    private BigDecimal coinsHolding;

    /**
     * 投币量
     */
    private BigDecimal selfCoinsTotal;

    /**
     * 被投币量
     */
    private BigDecimal coinsTotal;

    /**
     * 投币记录
     */
    private List<UserCoinsDTO> selfCoinsList;

    /**
     * 被投币记录
     */
    private List<UserCoinsDTO> coinsList;

    /**
     * 帖子 - 喜欢数
     */

    private Integer likeTotal;

    /**
     * 帖子 - 喜欢列表
     */
    private List<ManuscriptDTO> likeList;

    /**
     * 帖子 - 收藏数
     */
    private Integer collectionTotal;

    /**
     * 帖子 - 收藏列表
     */
    private List<ManuscriptDTO> collectionList;

    /**
     * 商品 - 收藏？
     */

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 删除标志（0代表启用，1代表删除）
     */
    private Integer deleteMark;
}
