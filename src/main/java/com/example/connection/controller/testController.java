package com.example.connection.controller;

import com.example.connection.common.CommUtil;
import com.example.connection.service.testService;
import core.base.BaseController;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;

@Controller
@RequestMapping("/basic")
public class testController extends BaseController {

    @Resource
    private testService tSvc;

    @RequestMapping(value = "app.do", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public ModelAndView appRequest(@RequestParam HashMap<String, Object> iParam) {
        HashMap<String, Object> pMap = new HashMap<String, Object>();
        HashMap<String, Object> rtMap = null;

        JSONObject jObj = null;

        String jParam = "", sGubun = "";
        String param1 = "", param2 = "", param3 = "";

        try {
            jParam = iParam.get("param").toString();
            jObj = CommUtil.StrToJSONObject(jParam);
            sGubun = CommUtil.JSONObjectToParse(jObj, "gubun");
            param1 = CommUtil.JSONObjectToParse(jObj, "param1");
            param2 = CommUtil.JSONObjectToParse(jObj, "param2");
            param3 = CommUtil.JSONObjectToParse(jObj, "param3");

            System.out.println("sGubun = " + sGubun);
            System.out.println("param1 = " + param1);
            System.out.println("param2 = " + param2);
            System.out.println("param3 = " + param3);

            pMap.put("gubun", sGubun);
            pMap.put("param1", param1);
            pMap.put("param2", param2);
            pMap.put("param3", param3);

            rtMap = tSvc.testRequest(pMap);
            System.out.println("rtMap = " + rtMap);
        } catch (Exception e) {
            System.out.println("testRequest Error = " + e.toString());
        }
        ModelAndView result = new ModelAndView("jsonView", rtMap);
        return result;
    }
}
