package RareBeauty;

import RareBeauty.entity.redisdomain.UsageLog;
import RareBeauty.repository.UsageLogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: ykh
 * @Date: 2023-02-06-14:25
 * @Description: 测试使用记录接口
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsageLogRepositoryTest {
    @Autowired
    private UsageLogRepository usageLogRepository;

    @Test
    public void saveUsage() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        UsageLog usageLog = new UsageLog();
        usageLog.setName("勇攀巅峰");
        usageLog.setTime(simpleDateFormat.format(date));
        usageLog.setPhone("13301888666");
        UsageLog save = usageLogRepository.save(usageLog);
        System.out.println(save);
    }

    @Test
    public void findUsageLog_1(){
        List<UsageLog> list = usageLogRepository.findUsageLogByName("勇攀巅峰");
        System.out.println(list);
    }
}
