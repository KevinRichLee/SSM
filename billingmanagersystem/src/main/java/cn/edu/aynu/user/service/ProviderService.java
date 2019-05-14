package cn.edu.aynu.user.service;

import cn.edu.aynu.user.entities.Provider;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/15
 */
public interface ProviderService {
    List<Provider> selectProvider(String providerName);

    List<Provider> selectAllProviders();

    Provider selectProviderPid(Integer pid);

    Provider selectProviderEcho(Integer pid);

    void updateProvider(Provider provider);

    void deleteProvider(Integer pid);

    void addProvider(Provider provider);

    List<Provider> findProviderByPage(int currentPage,int pageSize);
}
