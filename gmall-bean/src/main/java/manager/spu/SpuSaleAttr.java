package manager.spu;


import lombok.Data;
import manager.SuperBean;

/**
 * Spu销售属性
 */
@Data
public class SpuSaleAttr extends SuperBean {

    //spu_id  sale_attr_id  sale_attr_name
    private Integer spuId;
    private Integer saleAttrId;
    private String saleAttrName;
}
