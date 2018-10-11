package manager;

import java.util.List;

public interface BaseAttrInfoService {
public List<BaseAttrInfo> getBaseSttrInfoByCatalog3Id(Integer catalog3Id);
public List<BaseAttrValue> getBaseAttrValueByAttrId (Integer baseAttrInfoId);
  void saveOrUpdateBaseInfo(BaseAttrInfo baseAttrInfo);

}
