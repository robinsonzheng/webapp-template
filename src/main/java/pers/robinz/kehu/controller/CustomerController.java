package pers.robinz.kehu.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.robinz.kehu.po.Customer;
import pers.robinz.kehu.service.CustomerService;
import pers.robinz.kehu.util.PagingInfo;
import pers.robinz.kehu.util.aop.OpenApiClazz;
import pers.robinz.kehu.util.result.ResultBean;

import java.util.List;

/**
 * Created by Robinz on 2018-06-05.
 * 客户控制器
 */
@RestController
@RequestMapping("/customer")
@OpenApiClazz
public class CustomerController {

    private static final Logger logger = Logger.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/search")
    public ResultBean<?> search(@RequestParam("city") String city,
                                @RequestParam("category") String category,
                                @RequestParam(name = "mobileOnly", required = false, defaultValue = "false") Boolean mobileOnly,
                                @RequestParam(name = "pageSize", required = false, defaultValue = "50") int pageSize,
                                @RequestParam(name = "page", required = false, defaultValue = "1") int page) {

        logger.debug("CustomerController.search");


        try {
            JSONObject data = new JSONObject();
            int count = customerService.count(city, category, mobileOnly);
            PagingInfo pagingInfo = new PagingInfo(count, page, pageSize);
            List<Customer> customerList = customerService.query(city, category, mobileOnly, pagingInfo.getOffset(), pagingInfo.getLimit());
            JSONArray array = JSONArray.parseArray(JSON.toJSONString(customerList));
            data.put("totalPage", pagingInfo.getTotalPage());
            data.put("page", pagingInfo.getPage());
            data.put("item", array);
            data.put("size", array.size());
            return new ResultBean<JSONObject>(data);

        } catch (Exception e) {
            logger.error(e);
            return new ResultBean<Object>(e);
        }
    }

}
