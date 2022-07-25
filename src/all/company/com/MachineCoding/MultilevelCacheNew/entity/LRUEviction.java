package all.company.com.MachineCoding.MultilevelCacheNew.entity;

public class LRUEviction <T> implements Eviction{

    Cache<T> cache;

    public LRUEviction(final Cache<T> cache) {
        this.cache = cache;
    }

    @Override
    public void keyAccess(final String key) {
        Data<T> dataNode = cache.getKeyValue().get(key);
        if(dataNode.getNextData() == null && dataNode.getPrevData() == null){
            //Do Nothing
        } else if (dataNode.getNextData() == null) { //LastNode
            cache.setTail(dataNode.getPrevData());
            dataNode.getPrevData().setNextData(null);
            dataNode.setPrevData(null);
            dataNode.setNextData(cache.getHead());
            cache.getHead().setPrevData(dataNode);
            cache.setHead(dataNode);
        } else { //Some Middle Node
            dataNode.getNextData().setPrevData(dataNode.getPrevData());
            dataNode.getPrevData().setNextData(dataNode.getNextData());
            cache.getHead().setPrevData(dataNode);
            dataNode.setPrevData(null);
            dataNode.setNextData(cache.getHead());
        }
        dataNode.setFrequency(dataNode.getFrequency()+1);
    }

    public void evict() {
        while (cache.getAllocatedCapacity() >= cache.getMaxCapacity()){
            Data<T> node = cache.getTail();
            cache.setTail(cache.getTail().getPrevData());
            node.setPrevData(node);
            cache.getTail().setNextData(null);
            cache.setAllocatedCapacity(cache.getAllocatedCapacity()-1);
        }
    }
}
