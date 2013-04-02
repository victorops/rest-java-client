package com.zuora.sdk.samples;

import org.junit.Test;

import com.zuora.sdk.lib.ZClient;

public class AccountManagerTest {
   static final String SAMPLE_ACCOUNT_KEY = "A00001069";
   
   @Test
   public void test_account_manager(){
      // Create a z_client
      ZClient zClient = new ZClient();

      // create an account resource manager
      AccountManager accountManager = new AccountManager(zClient);

      // Connect to the End Point using default tenant's credentials
      // and practice APIs
      if (new ConnectionManager().isConnected(zClient)) {
        accountManager.getSummary(SAMPLE_ACCOUNT_KEY);
        accountManager.getDetails(SAMPLE_ACCOUNT_KEY);
        String accountNumber = accountManager.create();
        if (accountNumber != null) {
          accountManager.update(accountNumber);
          accountManager.createWithSubscription();
        }
      }

   }
}
