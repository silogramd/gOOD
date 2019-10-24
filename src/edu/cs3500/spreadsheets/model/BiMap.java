package edu.cs3500.spreadsheets.model;

import java.util.HashMap;

/***
 * A Bi-Directional map implementation.
 * @param <K>
 * @param <V>
 */
public class BiMap<K,V> {

  private HashMap<K,V> map;
  private HashMap<V,K> invertedMap;

  public BiMap() {
    this.map = new HashMap<K,V>();
    this.invertedMap = new HashMap<V,K>();
  }

  public V get(K key) {
    return this.map.get(key);
  }

  public K getKey(V value) {
    return this.invertedMap.get(value);
  }

  public void put(K key, V value) {
    this.map.put(key, value);
    this.invertedMap.put(value, key);
  }

  public boolean containsKey(K key) {
    return this.map.containsKey(key);
  }

}
