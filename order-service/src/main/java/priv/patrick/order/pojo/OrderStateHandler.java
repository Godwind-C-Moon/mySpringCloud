package priv.patrick.order.pojo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderStateHandler extends BaseTypeHandler<OrderState> {

    /**
     * 数据库类型转换为对应的Java类型
     */
    @Override
    public OrderState getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        OrderState orderState = null;
        if (!resultSet.wasNull()) {
            int state = resultSet.getInt(columnName);
            orderState = OrderState.getEnumByState(state);
        }
        return orderState;
    }

    /**
     * 数据库类型转换为对应的Java类型
     */
    @Override
    public OrderState getNullableResult(ResultSet resultSet, int columnIndex) throws SQLException {
        OrderState orderState = null;
        if (!resultSet.wasNull()) {
            int value = resultSet.getInt(columnIndex);
            orderState = OrderState.getEnumByState(value);
        }
        return orderState;
    }

    /**
     * 数据库类型转换为对应的Java类型
     */
    @Override
    public OrderState getNullableResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        OrderState orderState = null;
        if (!callableStatement.wasNull()) {
            int value = callableStatement.getInt(columnIndex);
            orderState = OrderState.getEnumByState(value);
        }
        return orderState;
    }

    /**
     * Java类型 转换为对应的数据库类型
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int parameterIndex, OrderState orderState, JdbcType jdbcType)
            throws SQLException {
        preparedStatement.setInt(parameterIndex, orderState.getState());
    }

}

