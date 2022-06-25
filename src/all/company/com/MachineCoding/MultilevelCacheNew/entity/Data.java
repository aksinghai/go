package all.company.com.MachineCoding.MultilevelCacheNew.entity;

public class Data<T> {

    private T value;
    private int frequency;
    private Data<T> nextData;
    private Data<T> prevData;

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

    public Data getNextData() {
        return nextData;
    }

    public void setNextData(final Data nextData) {
        this.nextData = nextData;
    }

    public Data getPrevData() {
        return prevData;
    }

    public void setPrevData(final Data prevData) {
        this.prevData = prevData;
    }
}
