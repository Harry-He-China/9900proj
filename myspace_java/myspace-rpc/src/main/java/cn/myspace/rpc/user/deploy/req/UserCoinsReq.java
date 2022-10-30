package cn.myspace.rpc.user.deploy.req;

import cn.myspace.rpc.user.deploy.dto.UserCoinsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户硬币请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCoinsReq implements Serializable {

    /**
     * ERP ID，记录谁在操作
     */
    private String erpId;

    private UserCoinsDTO userCoins;
}
