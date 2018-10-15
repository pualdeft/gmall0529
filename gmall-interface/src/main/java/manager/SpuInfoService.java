package manager;

import manager.spu.BaseSaleAttr;
import manager.spu.SpuInfo;

import java.util.List;

public interface SpuInfoService {

    List<SpuInfo> getSpuInfoByC3Id(Integer catalog3Id);

    List<BaseSaleAttr> getBaseSaleAttr();

    void saveBigSpuInfo(SpuInfo spuInfo);
}
