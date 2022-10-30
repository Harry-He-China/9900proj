package cn.myspace.rpc.manuscript.deploy.res;

import cn.myspace.common.Result;
import cn.myspace.rpc.user.deploy.dto.UserDTO;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 帖子查询结果
 */
@Data
@Builder
public class ManuscriptRes implements Serializable {

    private Result result;
    private Long count;
    private List<UserDTO> userDTOList;
}
