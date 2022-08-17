package com.example.connection.service;

import core.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class testService extends BaseService {

    public HashMap<String, Object> testRequest(HashMap<String, Object> iParam) throws Exception {

        HashMap<String, Object> rtMap = new HashMap<String, Object>();

        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        String sGubun = "";

        try {

            sGubun		= iParam.get("gubun").toString();
            resultList	= sqlSession.selectList("testQry.selTestTime", iParam);

            rtMap.put("gubun",	sGubun);
            rtMap.put("result",	resultList);

        }catch(Exception e) {
            System.out.println("오류 확인 : " + e.toString());

        }

        return rtMap;
    }
}
