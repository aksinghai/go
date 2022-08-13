package all.company.com.MachineCoding.LRU.entity.eviction;

import all.company.com.MachineCoding.LRU.entity.Cache;
import all.company.com.MachineCoding.LRU.entity.DataNode;


public class LRUEviction<T> implements Eviction {

    Cache<T> cache;

    public LRUEviction(final Cache<T> cache) {
        this.cache = cache;
    }

    @Override public void keyAccessed(final String key) {
        DataNode<T> data = cache.getDataStore().get(key);
        if(data == null){
            return;
        }



        if(data.getNext() == null && data.getPrevious() == null){
            cache.setTail(null);
            cache.setHead(null);
        } else if (data.getNext() == null){
            cache.setTail(data.getPrevious());
            data.getPrevious().setNext(null);
            data.setPrevious(null);
        } else if(data.getPrevious() == null){
            cache.setHead(cache.getHead().getNext());
            data.getNext().setPrevious(null);
        }
        cache.setAllocation(cache.getAllocation()-1);
    }

    @Override public void doEvict() {

    }
}
