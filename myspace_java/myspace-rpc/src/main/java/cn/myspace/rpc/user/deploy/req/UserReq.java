package cn.myspace.rpc.user.deploy.req;


import cn.myspace.rpc.user.deploy.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReq implements Serializable {

    /**
     * ERP ID，记录谁在操作
     */
    private String erpId;

    private UserDTO user;

//    private String username;
//
//    private String password;
}
