package com.sct.firstappdemo.repository;

import com.sct.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {

    /**
     * 采用内存型的方式 ->Map
     *
     */
    private final ConcurrentMap<Integer,User> repository = new ConcurrentHashMap<>();

    private final static AtomicInteger idGenerator = new AtomicInteger();

    /**
     * 保存用户对象
     * @param user{@link User} 对象
     * @return如果保存成功，返回true，否则返回false
     */
    public boolean save(User user){

            //id从1自动增长
            Integer id = idGenerator.incrementAndGet();
            user.setId(id);
            //从put方法里可以看到，返回值为null时，说明返回成功。
            return repository.put(id,user) == null;
    }
}
