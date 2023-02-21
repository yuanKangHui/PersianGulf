package RareBeauty.entity.redisdomain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: ykh
 * @Date: 2023-02-06-14:03
 * @Description: 使用记录实体
 */
@Data
@RedisHash("usageLog")
public class UsageLog implements Serializable {
    @Id
    private String id;
    @Indexed
    private String time;
    @Indexed
    private String name;
    @Indexed
    private String phone;
}
