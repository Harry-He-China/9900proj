package cn.myspace.domain.user.model.res;

import cn.myspace.domain.user.model.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 用户分页查询聚合对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLimitPageRes {

    private Long count;

    private List<UserVO> userVOList;
}
