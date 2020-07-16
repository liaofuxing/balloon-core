package com.balloon.core.id;

import java.util.UUID;

/**
 * UUID 生成id
 *
 * @author liaofuxing
 */
public class UUIDGenerateId implements GenerateId<String> {

    @Override
    public String generateId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
