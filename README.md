# balloon-core （气球）

#### 项目介绍

    项目命名为气球，意为轻量简洁，基于jdk 1.8，不依赖任何框架，适合当项目基础工具包，该项目也是 balloon-springboot 项目的基础包

#### 支持
    jdk 1.8+

#### 工具（模块）

| 类名  | 工具名  | 包路径 |
|---|---|---|
| CollectionUtils  | 集合工具类  | com.balloon.core.collection.CollectionUtils |
| DateTimeUtils |  时间工具类 |  com.balloon.core.date.DateTimeUtils  |
| BusinessRuntimeException | 通用业务异常类  | com.balloon.core.exception.BusinessRuntimeException |
| UUIDGenerateId  |  uuid生成类 | com.balloon.core.id.UUIDGenerateId   |
| MapUtils  | map工具类  | com.balloon.core.map.MapUtils  |
| observer | 观察者工具包  | com.balloon.core.observer   |
| RandomUtils| 随机字符串工具类  |  com.balloon.core.random.RandomUtils |
| StringUtils| 字符串工具类  |  com.balloon.core.utils.StringUtils |
| EncryptionUtil| 加密解密工具类  |  com.balloon.core.utils.EncryptionUtil|


#### 例子
    如果要想使用 RandomUtils 生成一个长度为6随机数字
    @code {
        // 例子 
        System.out.println(RandomUtils.randomNumber(6)); 
          
        // 输出
        634169         
    }

    如果要想使用 RandomUtils 生成一个长度为10随机字符串，包含字母和数字不区分大小
    @code {
        // 例子 
        System.out.println(RandomUtils.randomNumber(6)); 
          
        // 输出
        gmd40Bk929       
    }

    如果想将一个list转化为以某个符号隔开的字符串

    @code {
        // 例子 list = [1 2 3 4]
        
        System.out.println(CollectionUtils.collectionConvertStringJoiner(list，",")); 
          
        // 输出
        1, 2, 3, 4      
    }

    其他工具类，详情见文档


    