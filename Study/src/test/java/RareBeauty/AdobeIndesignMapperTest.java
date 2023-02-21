package RareBeauty;

import RareBeauty.entity.AdobeIndesign;
import RareBeauty.mapper.AdobeIndesignMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: ykh
 * @Date: 2023-02-05-22:46
 * @Description: 测试专业书籍接口
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdobeIndesignMapperTest {
    @Autowired
    private AdobeIndesignMapper adobeIndesignMapper;

    @Test
    public void selectAdobeIndesign() {
        AdobeIndesign adobeIndesign = adobeIndesignMapper.selectAdobeIndesign(1);
        System.out.println(adobeIndesign);
    }
}
