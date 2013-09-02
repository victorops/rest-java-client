package com.zuora.sdk.samples;

import java.net.URLEncoder;
import java.util.Map;

import com.zuora.sdk.lib.ZAPIArgs;
import com.zuora.sdk.lib.ZAPIResp;
import com.zuora.sdk.lib.ZClient;

public class RevenueScheduleManager {
   private ZClient zClient;
   public final static String SIMPLE_RULE_NAME="";
   
   public RevenueScheduleManager(ZClient zClient){
      this.zClient = zClient;
   }
   
   // GET TRANSACTION REVENUE SCHEDULE DETAIL
   public void getDetailByNumber(String rsNumber) {
     try {
        rsNumber = URLEncoder.encode(rsNumber, "UTF-8");
     } catch (Exception e) {
       System.out.println(e.getMessage());
       e.printStackTrace();
       return;
     }
     
     ZAPIArgs args = new ZAPIArgs();
     args.set("uri", ResourceEndpoints.GET_REVENUE_SCHEDULE_DETAIL.replace("{rs-number}", rsNumber));

     System.out.println( "========== GET TRANSACTION REVENUE SCHEDULE DETAIL ============");

     try {
       ZAPIResp response = zClient.get(args);
       System.out.print(response.toJSONString());
     } catch (IllegalArgumentException e) {
       System.out.println(e.getMessage());
     } catch (RuntimeException e) {
       System.out.println(e.getMessage());
     }
   }
   
   // GET TRANSACTION REVENUE SCHEDULE DETAIL
   public void getDetailByInvoiceItem(String invoiceItemKey) {
     try {
        invoiceItemKey = URLEncoder.encode(invoiceItemKey, "UTF-8");
     } catch (Exception e) {
       System.out.println(e.getMessage());
       e.printStackTrace();
       return;
     }
     
     ZAPIArgs args = new ZAPIArgs();
     args.set("uri", ResourceEndpoints.GET_REVENUE_SCHEDULE_DETAIL_BY_INVOICE_ITEM.replace("{invoice-item-key}", invoiceItemKey));

     System.out.println( "========== GET TRANSACTION REVENUE SCHEDULE DETAIL ============");

     try {
       ZAPIResp response = zClient.get(args);
       System.out.print(response.toJSONString());
     } catch (IllegalArgumentException e) {
       System.out.println(e.getMessage());
     } catch (RuntimeException e) {
       System.out.println(e.getMessage());
     }
   }
   
   // GET TRANSACTION REVENUE SCHEDULE DETAIL
   public void getDetailByInvoiceItemAdjustment(String invoiceItemAdjustmentKey) {
     try {
        invoiceItemAdjustmentKey = URLEncoder.encode(invoiceItemAdjustmentKey, "UTF-8");
     } catch (Exception e) {
       System.out.println(e.getMessage());
       e.printStackTrace();
       return;
     }
     
     ZAPIArgs args = new ZAPIArgs();
     args.set("uri", ResourceEndpoints.GET_REVENUE_SCHEDULE_DETAIL_BY_INVOICE_ITEM_ADJUSTMENT.replace("{invoice-item-adj-key}", invoiceItemAdjustmentKey));

     System.out.println( "========== GET TRANSACTION REVENUE SCHEDULE DETAIL ============");

     try {
       ZAPIResp response = zClient.get(args);
       System.out.print(response.toJSONString());
     } catch (IllegalArgumentException e) {
       System.out.println(e.getMessage());
     } catch (RuntimeException e) {
       System.out.println(e.getMessage());
     }
   }   
   
   public void distributeRevenueRatably(String rsNumber){
      try {
         rsNumber = URLEncoder.encode(rsNumber, "UTF-8");
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        return;
      }
      ZAPIArgs args = new ZAPIArgs();
      args.set("uri", ResourceEndpoints.PUT_REVENUE_SCHEDULE_DISTRIBUTE_RATABLY.replace("{rs-number}",rsNumber));

      args.set("reqBody", new ZAPIArgs());
      args.getArg("reqBody").set("recognitionStart", "2013-02-1");
      args.getArg("reqBody").set("recognitionEnd", "2013-12-1");
      args.getArg("reqBody").set("eventType", "Revenue Distributed");
      args.getArg("reqBody").set("notes", "Soho Networks");
      args.getArg("reqBody").set("cf_project__c", "Project A");
      args.getArg("reqBody").set("cf_phase__c", "Phase 1");
      
      System.out.println("========== UPDATE RECOGNITION TERM ============");

      try {
        ZAPIResp response = zClient.put(args);
        System.out.println(response.toJSONString());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
      }
   }
   
   public void updateBasicInfo(String rsNumber){
      try {
         rsNumber = URLEncoder.encode(rsNumber, "UTF-8");
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        return;
      }
      ZAPIArgs args = new ZAPIArgs();
      args.set("uri", ResourceEndpoints.PUT_REVENUE_SCHEDULE_BASIC_INFORMATION.replace("{rs-number}",rsNumber));


      args.set("reqBody", new ZAPIArgs());
      args.getArg("reqBody").set("notes", "Soho Networks");
      args.getArg("reqBody").set("cf_project__c", "Project B");
      args.getArg("reqBody").set("cf_phase__c", "Phase 1");
      
      System.out.println("========== UPDATE BASIC INFOR ============");

      try {
        ZAPIResp response = zClient.put(args);
        System.out.println(response.toJSONString());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
      }
   }
   
   public void distributeRevenueManually(String rsNumber,Map<String,String> distributionItems){
      try {
         rsNumber = URLEncoder.encode(rsNumber, "UTF-8");
      } catch (Exception e) {
        System.out.println(e.getMessage());
        e.printStackTrace();
        return;
      }
      ZAPIArgs args = new ZAPIArgs();
      args.set("uri", ResourceEndpoints.PUT_REVENUE_SCHEDULE_DISTRIBUTE_MANUALLY.replace("{rs-number}",rsNumber));


      args.set("reqBody", new ZAPIArgs());
      args.getArg("reqBody").set("notes", "Soho Networks");
      args.getArg("reqBody").set("eventType", "Revenue Distributed");
      args.getArg("reqBody").set("cf_project__c", "Project A");
      args.getArg("reqBody").set("cf_phase__c", "Phase 1");
      args.getArg("reqBody").setArray("revenueDistributions");
      int count=0;
      for(Map.Entry<String, String> item:distributionItems.entrySet()){
         String itemKey = "revenueDistributions["+count+"]";
         args.getArg("reqBody").set(itemKey,new ZAPIArgs());
         args.getArg("reqBody").getArg(itemKey).set("accountingPeriodName", item.getKey());
         args.getArg("reqBody").getArg(itemKey).set("newAmount", item.getValue());
         count++;
      }
      System.out.println(args.toJSONString());
      
      
      System.out.println("========== DISTRIBUTE ============");

      try {
        ZAPIResp response = zClient.put(args);
        System.out.println(response.toJSONString());
      } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
      }
   }  
   
}
