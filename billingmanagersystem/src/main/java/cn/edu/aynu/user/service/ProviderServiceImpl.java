package cn.edu.aynu.user.service;

import cn.edu.aynu.user.entities.PageBean;
import cn.edu.aynu.user.entities.Provider;
import cn.edu.aynu.user.dao.ProviderDao;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/15
 */
@Service
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDao providerDao;
    @Override
    public List<Provider> selectProvider(String providerName) {
        return providerDao.getAll(providerName);
    }

    @Override
    public List<Provider> selectAllProviders() {
        return providerDao.getAllProviders();
    }

    @Override
    public Provider selectProviderPid(Integer pid) {
        return providerDao.getProviderPid(pid);
    }

    @Override
    public Provider selectProviderEcho(Integer pid) {
        return providerDao.getProviderEcho(pid);
    }

    @Override
    public void updateProvider(Provider provider) {
        providerDao.updateProvider(provider);
    }

    @Override
    public void deleteProvider(Integer pid) {
        providerDao.deleteProvider(pid);
    }

    @Override
    public void addProvider(Provider provider) {
        providerDao.addProvider(provider);
    }

    @Override
    public List<Provider> findProviderByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
            currentPage=1;
            pageSize=4;
            PageHelper.startPage(currentPage, pageSize);
            List<Provider> allProviders = providerDao.getAllProviders();        //全部商品
            int countNums = providerDao.countProvider();            //总记录数
            PageBean<Provider> pageData = new PageBean<>(currentPage, pageSize, countNums);
            pageData.setItems(allProviders);
            return pageData.getItems();
    }
    // public List<Provider> findProviderByPage(int currentPage,int pageSize) {
    //     //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
    //     PageHelper.startPage(currentPage, pageSize);
    //
    //     List<Provider> allProviders = providerDao.getAllProviders();        //全部商品
    //     int countNums = providerDao.countProvider();            //总记录数
    //     PageBean<Provider> pageData = new PageBean<>(currentPage, pageSize, countNums);
    //     pageData.setItems(allProviders);
    //     return pageData.getItems();

}
