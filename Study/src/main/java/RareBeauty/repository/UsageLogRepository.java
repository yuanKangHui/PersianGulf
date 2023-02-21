package RareBeauty.repository;

import RareBeauty.entity.redisdomain.UsageLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @Author: ykh
 * @Date: 2023-02-06-14:15
 * @Description: 使用记录接口
 */
public interface UsageLogRepository extends CrudRepository<UsageLog, String> {
    /**
     * 根据name查找出使用信息
     *
     * @param name
     * @return List<UsageLog>
     * @author ykh
     * @date 2023/2/7 22:49
     */
    List<UsageLog> findUsageLogByName(String name);
}
