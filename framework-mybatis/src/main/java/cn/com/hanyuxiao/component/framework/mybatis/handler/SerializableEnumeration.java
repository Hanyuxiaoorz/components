package cn.com.hanyuxiao.component.framework.mybatis.handler;

/**
 * 定义可被序列化的枚举类。比如有一个枚举类 DEMO(1) 我们将其保存在数据库当中应该是存储
 * 其 1 这个值，这个值叫做序列化值。
 *
 * @author hanyuxiao
 */
public interface SerializableEnumeration {

    /**
     * 获取该可序列化的枚举类的序列化值。
     *
     * @return 可序列化枚举类的序列化值。
     */
    int getSerializableValue();
}
