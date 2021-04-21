package jdk11;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CollectionsC {

    /**
     * 返回一个空列表，此项经常使用
     *
     * @return 空列表
     */
    public List<Object> emptyList() {
        return Collections.emptyList();
    }

    /**
     * 返回一个单对象 Map
     *
     * @return 单对象 Map
     */
    public Map singleMap() {
        return Collections.singletonMap("key", "value");
    }
}
