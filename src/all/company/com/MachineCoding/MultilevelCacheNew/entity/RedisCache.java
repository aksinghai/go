package all.company.com.MachineCoding.MultilevelCacheNew.entity;

public class RedisCache extends Cache {

    public <T> RedisCache(final String name, final Integer maxCapacity) {
        super(name, maxCapacity);
    }

    @Override public String get(final String key) {
        /*if(super.getKeyValue() == null || !super.getKeyValue().containsKey(key)){
            return null;
        }
        super.getKeyValue().get(key).setFrequency(super.getKeyValue().get(key).getFrequency()+1);
        return super.getKeyValue().get(key).setValue();*/
        return null;
    }

    /*@Override public boolean set(final String key, ) {
        if(super.getKeyValue().containsKey(key)){
            super.getKeyValue().get(key).setFrequency(super.getKeyValue().get(key).getFrequency()+1);
            super.getKeyValue().get(key).setValue(key);
            return true;
        }

        return false;
    }*/

    @Override public boolean set(final String key, final Object value) {
        return false;
    }

    @Override public boolean delete(final String key) {
        return false;
    }

}
