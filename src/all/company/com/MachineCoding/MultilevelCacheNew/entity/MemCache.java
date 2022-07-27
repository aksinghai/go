package all.company.com.MachineCoding.MultilevelCacheNew.entity;

import all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction.Cache;
import all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction.Data;


public class MemCache<T> extends Cache<T> {



    public MemCache(final String name, final Integer maxCapacity) {
        super(name, maxCapacity, 100, 150, 50);
    }

    @Override public T get(final String key) {
        if(this.getKeyValue().containsKey(key)) {
            Data<T> dataNode = this.getKeyValue().get(key);
            getEviction().keyAccess(key);
            return (T) dataNode.getValue();
        }

        return null;
    }

    @Override public boolean set(final String key, final T value) {
        if(this.getKeyValue().containsKey(key)){
            Data<T> dataNode = this.getKeyValue().get(key);
            dataNode.setValue(value);
            this.setAllocatedCapacity(this.getAllocatedCapacity()+1);
        } else {
            if(this.getAllocatedCapacity() >= this.getMaxCapacity()) {
                getEviction().evict();
            } else {
                this.setAllocatedCapacity(this.getAllocatedCapacity()+1);
            }
            Data<T> newDataNode = new Data<>(key, value, 0, null, null);
            if(this.getTail() == null){
                this.setHead(newDataNode);
            } else {
                newDataNode.setPrevData(this.getTail());
            }
            this.setTail(newDataNode);
            this.getKeyValue().put(key, newDataNode);
        }

        getEviction().keyAccess(key);
        return true;
    }

    @Override public boolean delete(final String key) {
        if(this.getKeyValue().containsKey(key)){
            Data<T> dataNode = this.getKeyValue().get(key);
            this.setAllocatedCapacity(this.getAllocatedCapacity()-1);
            if(dataNode.getNextData() == null && dataNode.getPrevData() == null){ //Only Node
                this.setTail(null);
                this.setHead(null);
            } else if(getTail().getNextData() == null){
                setTail(getTail().getPrevData());
                getTail().setNextData(null);
                dataNode.setPrevData(null);
            } else {
                dataNode.getPrevData().setNextData(dataNode.getNextData());
                dataNode.getNextData().setPrevData(dataNode.getPrevData());
            }
            getKeyValue().remove(key);
        }
        return true;
    }
}
