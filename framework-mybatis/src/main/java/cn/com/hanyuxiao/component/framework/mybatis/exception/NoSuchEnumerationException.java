package cn.com.hanyuxiao.component.framework.mybatis.exception;

/**
 * 在这个扩展当中，实现了 {@link cn.com.hanyuxiao.component.framework.mybatis.handler.SerializableEnumeration} 接口的
 * 枚举都会被 {@link cn.com.hanyuxiao.component.framework.mybatis.handler.SerializableEnumerationHandler} 进行解析，如果
 * 给出的序列化值在枚举当中查询不到，那么就会抛出这样的一个异常。
 */
public class NoSuchEnumerationException extends RuntimeException {

    public NoSuchEnumerationException(String message) {
        super(message);
    }
}
