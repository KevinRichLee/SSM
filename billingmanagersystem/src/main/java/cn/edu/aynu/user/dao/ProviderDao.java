package cn.edu.aynu.user.dao;

import cn.edu.aynu.user.entities.Provider;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/15
 */
@Mapper
public interface ProviderDao {
    List<Provider> getAll(String providerName);

    List<Provider> getAllProviders();

    Provider getProviderPid(Integer pid);

    Provider getProviderEcho(Integer pid);

    void updateProvider(Provider provider);

    void deleteProvider(Integer pid);

    void addProvider(Provider provider);

    Integer countProvider();

    List<Provider> findProviderByPage(int currentPage,int pageSize);
}
