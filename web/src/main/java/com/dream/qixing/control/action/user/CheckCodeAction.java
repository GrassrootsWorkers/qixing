package com.dream.qixing.control.action.user;

import com.dream.qixing.control.action.BaseAction;
import com.dream.qixing.config.ApiAction;
import com.dream.qixing.mapping.ApiField;
import com.dream.qixing.util.RandomStrUtil;
import com.dream.qixing.util.WebUtils;
import org.apache.zookeeper.server.SessionTracker;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/2/28 0028.
 */
@ApiAction(value ="customer.getCheckCode")
public class CheckCodeAction extends BaseAction {

    private String mobile;
    //获取验证码的用途：0：注册；1：修改密码在此type的值为0，2快速登录验证码
    private int codeType;
    @ApiField("checkCode")
    private String checkCode;
    @Override
    public String execute(){
        String code = RandomStrUtil.getNumStr(6);
        //发送验证码
        Map<String,Object> returnContent = chuangLanSend("http://222.73.117.156/msg/HttpBatchSendSM",code,mobile);
        if(returnContent == null || "07".equals(returnContent.get("error"))){

        }else{
            this.getSession().setAttribute(mobile,code);
        }

        return "";
    }

    /**
     *  上海创蓝http://222.73.117.156/msg/HttpBatchSendSM
     * http://222.73.117.158/msg/HttpBatchSendSM?account=jiekou-cs-01&pswd=Tch147256&mobile=13482416860&msg=【创蓝文化】您的注册验证码是：1131.请完成注册&needstatus=true
     * @param url
     * @param messages
     * @param mobile
     * @return
     */

    public static Map<String,Object> chuangLanSend(String url, String messages, String mobile) {
        String result= null;
        Map<String,Object>resultMap = new HashMap<String,Object>();
        try {
            Map<String,String> params = new HashMap<String,String>();
            params.put("account","jiekou-clcs-05");
            params.put("pswd","Tch599999");
            params.put("mobile",mobile);
            params.put("msg",URLEncoder.encode(messages, "UTF-8"));
            params.put("needstatus","true");
            WebUtils.doGet(url,params,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(result !=null && result != ""){
            String[] strs = result.split(",");
            if(strs.length <= 2){
                resultMap.put("error", "07");
                resultMap.put("code", "07");
                resultMap.put("msgid",null);
            }else{
                String msgId = strs[2];
                resultMap.put("error", "0");
                resultMap.put("code", "0");
                resultMap.put("msgid",msgId);
            }
            return resultMap;
        }
        return null;
    }

    @Override
    public String getResponseName() {
        return null;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }
}
