package manager.spu;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import manager.SuperBean;

/**
 * 基本销售属性
 */
@TableName("base_sale_attr")
@Data
public class BaseSaleAttr extends SuperBean {

    private String name;//基本销售属性名
}
