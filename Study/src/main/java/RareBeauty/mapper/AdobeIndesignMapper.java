package RareBeauty.mapper;

import RareBeauty.entity.AdobeIndesign;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Author: ykh
 * @Date: 2023-02-05-21:47
 * @Description: 专业书籍表接口
 */
@Mapper
public interface AdobeIndesignMapper {
    /**
     * 查询出指定书籍编号的信息
     *
     * @param bno
     * @return adobeIndesign
     * @author ykh
     * @date 2023/2/5 21:50
     */
    public AdobeIndesign selectAdobeIndesign(Integer bno);

    /**
     * 修改专业书籍的信息
     *
     * @param adobeIndesign
     * @return int
     * @author ykh
     * @date 2023/2/5 21:55
     */
    public int updateAdobeIndesign(AdobeIndesign adobeIndesign);
}
