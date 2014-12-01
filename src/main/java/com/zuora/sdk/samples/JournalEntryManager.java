package com.zuora.sdk.samples;

import java.net.URLEncoder;

import com.zuora.sdk.lib.ZAPIArgs;
import com.zuora.sdk.lib.ZAPIResp;
import com.zuora.sdk.lib.ZClient;

public class JournalEntryManager {
	private ZClient zClient;
	 
    public JournalEntryManager(ZClient zClient){
       this.zClient = zClient;
    }
	public void updateBasicInfo(String jeNumber){
	      try {
	    	  jeNumber = URLEncoder.encode(jeNumber, "UTF-8");
	      } catch (Exception e) {
	        System.out.println(e.getMessage());
	        e.printStackTrace();
	        return;
	      }
	      ZAPIArgs args = new ZAPIArgs();
	      args.set("uri", ResourceEndpoints.PUT_JOURNAL_ENTRY_BASIC_INFORMATION.replace("{je-number}",jeNumber));


	      args.set("reqBody", new ZAPIArgs());
	      args.getArg("reqBody").set("notes", "Soho Networks");
	      args.getArg("reqBody").set("transferredToAccounting", "Yes");
	      args.getArg("reqBody").set("je_picklist1__c", "123");
	      args.getArg("reqBody").set("je_text1__c", "Phase 1");
	      
	      System.out.println("========== UPDATE BASIC INFO ============");

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
