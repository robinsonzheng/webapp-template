package pers.robinz.kehu.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.robinz.kehu.po.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Robinz on 2018-06-05.
 */
@Repository
public class CustomerDao {

    private static final Logger logger = Logger.getLogger(CustomerDao.class);

    @Autowired
    private SqlSession sqlSession;

    /**
     * 查询客户列表
     *
     * @param city       城市
     * @param category   行业
     * @param mobileOnly 是否只取有手机号码的记录
     * @param offset     开始记录号
     * @param limit      返回记录数
     * @return
     */
    public List<Customer> query(String city, String category, boolean mobileOnly, int offset, int limit) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("city", city);
        params.put("category", category);
        params.put("mobileOnly", mobileOnly);
        params.put("offset", offset);
        params.put("limit", limit);

        logger.debug("CustomerDao.query");

        return sqlSession.selectList("Customer.query", params);
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
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("city", city);
        params.put("category", category);
        params.put("mobileOnly", mobileOnly);
        logger.debug("CustomerDao.count");

        return sqlSession.selectOne("Customer.queryCount", params);
    }

}
