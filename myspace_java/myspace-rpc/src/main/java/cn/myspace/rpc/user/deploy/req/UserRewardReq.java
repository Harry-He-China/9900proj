package cn.myspace.rpc.user.deploy.req;

import cn.myspace.rpc.user.deploy.dto.UserRewardDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户捐献请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRewardReq implements Serializable {

    /**
     * ERP ID，记录谁在操作
     */
    private String erpId;

    private UserRewardDTO userReward;
}
