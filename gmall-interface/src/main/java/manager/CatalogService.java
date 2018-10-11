package manager;

import manager.BaseCatalog1;
import manager.BaseCatalog2;
import manager.BaseCatalog3;

import java.util.List;

public interface CatalogService {
    public List<BaseCatalog1> getAllBaseCatalog1();
    public List<BaseCatalog2> getAllBaseCatalog2ByC1Id(Integer catalog1Id);
    public List<BaseCatalog3> getAllBaseCatalog3byC2Id(Integer catalog2Id);
 }
