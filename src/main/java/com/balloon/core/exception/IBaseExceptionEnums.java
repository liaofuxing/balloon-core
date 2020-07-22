package com.balloon.core.exception;

/**
 * 基础异常枚举接口
 * <p>所有异常枚举都应该继承这个异常枚举接口类, 在声明业务运行时异常时,
 * 可以通过 BusinessRuntimeException(IBaseExceptionEnums enums) 构造器来构造一个运行时业务异常</p>
 * <p>该接口并没有具体方法, 仅方便 balloon 项目构建统一化的运行时业务异常</p>
 * <p>如果异常枚举没有实现该接口, 则不能使用 BusinessRuntimeException(IBaseExceptionEnums enums) 构造器</p>
 *
 * @author liaofuxing
 */
public interface IBaseExceptionEnums {

    Integer getCode();

    String getMsg();
}
