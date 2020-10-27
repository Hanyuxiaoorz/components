package cn.com.hanyuxiao.component.framework.mybatis.handler;

import cn.com.hanyuxiao.component.framework.mybatis.exception.NoSuchEnumerationException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SerializableEnumerationHandler extends BaseTypeHandler<SerializableEnumeration> {

    private final Class<SerializableEnumeration> serializableEnumerationClass;

    public SerializableEnumerationHandler(Class<SerializableEnumeration> serializableEnumClass) {
        if (serializableEnumClass == null) {
            throw new IllegalArgumentException(
                    String.format("Create %s wrong, cause parameter is null", SerializableEnumerationHandler.class.getName()));
        }
        this.serializableEnumerationClass = serializableEnumClass;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SerializableEnumeration serializableEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, serializableEnum.getSerializableValue());
    }

    @Override
    public SerializableEnumeration getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int value = resultSet.getInt(s);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return getEnum(value);
        }
    }

    @Override
    public SerializableEnumeration getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int value = resultSet.getInt(i);
        if (resultSet.wasNull()) {
            return null;
        } else {
            return getEnum(value);
        }
    }

    @Override
    public SerializableEnumeration getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int value = callableStatement.getInt(i);
        if (callableStatement.wasNull()) {
            return null;
        } else {
            return getEnum(value);
        }
    }

    private SerializableEnumeration getEnum(int value) {
        SerializableEnumeration[] enums = serializableEnumerationClass.getEnumConstants();
        for (SerializableEnumeration target : enums) {
            if (target.getSerializableValue() == value) {
                return target;
            }
        }

        throw new NoSuchEnumerationException(
                String.format("Enum %s have no value %d",
                        serializableEnumerationClass.getName(), value));
    }
}
