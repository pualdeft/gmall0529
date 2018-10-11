package manager;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class BaseAttrInfo extends SuperBean {
    private String attrName;

    private Integer catalog3Id;
    @TableField(exist = false)
    private List<BaseAttrValue> attrValues;
}
