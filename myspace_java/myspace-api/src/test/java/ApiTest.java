import cn.myspace.ApiApplication;
import cn.myspace.common.PageResult;
import cn.myspace.rpc.user.deploy.IUserDeploy;
import cn.myspace.rpc.user.deploy.req.UserPageReq;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiApplication.class)
public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @DubboReference(interfaceClass = IUserDeploy.class, url = "dubbo://127.0.0.1:20880")
    private IUserDeploy userDeploy;

    @Test
    public void test_rpc() {
        UserPageReq req = new UserPageReq(1, 10);
        req.setUserId(1L);
        PageResult result = userDeploy.getUserListByPage(req);
    }
}
