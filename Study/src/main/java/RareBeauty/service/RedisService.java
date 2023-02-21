package RareBeauty.service;

import RareBeauty.entity.redisdomain.UsageLog;
import RareBeauty.repository.UsageLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** redis业务操作
 * @Author: ykh
 * @Date: 2023-02-07-23:46
 * @Description:
 */
@Service
public class RedisService {
    @Autowired
    private UsageLogRepository usageLogRepository;

    @Cacheable(cacheNames = "usageLogList")
    public List<UsageLog> findUsageLogByName(String name) {
        List<UsageLog> list = usageLogRepository.findUsageLogByName(name);
        System.out.println("过载");
        return list;
    }
}
