package com.pachete;
class Pair<K, Val1, Val2> {
    private K key;
    private Val1 valoare1;
    private Val2 valoare2;
    public Pair(K key, Val1 valoare1, Val2 valoare2) {
        this.key = key;
        this.valoare1 = valoare1;
        this.valoare2 = valoare2;
    }
    public K getKey() {
        return key;
    }
    public Val1 getValue1() {
        return valoare1;
    }
    public Val2 getValue2() {
        return valoare2;
    }
}
