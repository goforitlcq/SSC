package com.project.service;

import com.project.BaseTest;
import com.project.common.exception.BusinessException;
import com.project.model.material.Request;
import com.project.service.weixin.material.WechatMaterialService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by goforit on 2017/11/27.
 */
public class WechatMaterialServiceTest extends BaseTest {
    @Autowired
    private WechatMaterialService wechatMaterialService;

    @Test
    public void testBatchget_material() throws BusinessException {
        Request request = getMaterialRequest();
        System.out.println(wechatMaterialService.batchget_material(request));
    }
    @Test
    public void testBatchgetMaterialUrl() throws BusinessException{
        Request request = getMaterialRequest();
        wechatMaterialService.batchgetMaterialUrl("url",request).forEach((title,url)->{
            System.out.println(String.format("title:%s,url:%s,", title,url));
        });
    }

    @Test
    public void testShowContent(){
//        System.out.println(wechatMaterialService.showContent("https://mp.weixin.qq" +
//                ".com/s/szpzQ6ID-3W-IVow6FUq9w"));
    }
    private Request getMaterialRequest() {
       return new Request(Request.TypeEnum.NEWS,0,20);
    }
}
