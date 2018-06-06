package pers.robinz.kehu.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robinz.kehu.dao.CustomerDao;
import pers.robinz.kehu.po.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robinz on 2018-06-05.
 */
@Service
public class CustomerService {

    private static final Logger logger = Logger.getLogger(CustomerService.class);

    @Autowired
    private CustomerDao customerDao;

    /**
     * 搜索客户记录
     *
     * @param city
     * @param category
     * @param mobileOnly
     * @param offset
     * @param limit
     * @return
     * @throws Exception
     */
    public List<Customer> query(String city, String category, boolean mobileOnly, int offset, int limit) throws Exception {

        if (customerDao == null) {
            logger.debug("customerDao == null");
            return new ArrayList<Customer>();
        }

        return customerDao.query(city, category, mobileOnly, offset, limit);
    }

    /**
     * 查询记录总数
     *
     * @param city
     * @param category
     * @param mobileOnly
     * @return
     */
    public int count(String city, String category, boolean mobileOnly) throws Exception {
        return customerDao.count(city, category, mobileOnly);
    }

}
