package all.company.com.MachineCoding.MultilevelCacheNew.entity.eviction;

public class Data<T> {

    private String key;
    private T value;
    private int frequency;
    private Data<T> nextData;
    private Data<T> prevData;

    public Data(final String key, final T value, final int frequency, final Data<T> nextData,
            final Data<T> prevData) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
        this.nextData = nextData;
        this.prevData = prevData;
    }

    public String getKey() {
        return key;
    }

    public void setKey(final String key) {
        this.key = key;
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(final int frequency) {
        this.frequency = frequency;
    }

    public Data<T> getNextData() {
        return nextData;
    }

    public void setNextData(final Data<T> nextData) {
        this.nextData = nextData;
    }

    public Data<T> getPrevData() {
        return prevData;
    }

    public void setPrevData(final Data<T> prevData) {
        this.prevData = prevData;
    }
}
