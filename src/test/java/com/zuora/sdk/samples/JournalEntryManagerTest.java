package com.zuora.sdk.samples;

import org.junit.Test;

import com.zuora.sdk.lib.ZClient;

public class JournalEntryManagerTest {
	   static final String SAMPLE_JOURNAL_ENTRY_KEY = "JE-00000014";
	   
	   @Test
	   public void test_change_basic(){
	      ZClient zClient = new ZClient();

	      // create a journal entry resource manager
	      JournalEntryManager jeManager = new JournalEntryManager(zClient);

	      // Connect to the End Point using default tenant's credentials
	      if (new ConnectionManager().isConnected(zClient)) {
	    	  jeManager.updateBasicInfo(SAMPLE_JOURNAL_ENTRY_KEY);
	      }
	   }
}
