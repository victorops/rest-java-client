/**
 * Copyright (c) 2013 Zuora Inc.
 *
 * Sample code to demonstrate how to define all available resource endpoints
 */

package com.zuora.sdk.samples;

public final class ResourceEndpoints {
  // RESOURCE GROUP CONNECTION API
  public static final String CONNECT = "/connections";

  // RESOURCE CATALOG API
  public static final String GET_PRODUCT_CATALOG = "/catalog/products";

  // RESOURCE ACCOUNT API
  public static final String GET_ACCOUNT_DETAIL = "/accounts/{account-key}";
  public static final String GET_ACCOUNT_SUMMARY = "/accounts/{account-key}/summary";
  public static final String POST_ACCOUNT = "/accounts";
  public static final String PUT_ACCOUNT = "/accounts/{account-key}";

  // RESOURCE PAYMENT METHOD API
  public static final String GET_CREDIT_CARDS = "/payment-methods/credit-cards/accounts/{account-key}";
  public static final String POST_CREDIT_CARD = "/payment-methods/credit-cards";
  public static final String PUT_CREDIT_CARD = "/payment-methods/credit-cards/{payment-method-id}";
  public static final String DELETE_PAYMENT_METHOD = "/payment-methods/{payment-method-id}";

  // RESOURCE TRANSACTION API
  public static final String GET_INVOICES = "/transactions/invoices/accounts/{account-key}";
  public static final String GET_PAYMENTS = "/transactions/payments/accounts/{account-key}";
  public static final String GET_USAGE = "/usage/accounts/{account-key}";

  // RESOURCE SUBSCRIPTION API
  public static final String GET_SUBSCRIPTION = "/subscriptions/{subscription-key}";
  public static final String GET_SUBSCRIPTIONS = "/subscriptions/accounts/{account-key}";
  public static final String POST_SUBSCRIPTION = "/subscriptions";
  public static final String POST_SUBSCRIPTION_PREVIEW = "/subscriptions/preview";
  public static final String PUT_SUBSCRIPTION = "/subscriptions/{subscription-key}";
  public static final String PUT_SUBSCRIPTION_RENEW = "/subscriptions/{subscription-key}/renew";
  public static final String PUT_SUBSCRIPTION_CANCEL = "/subscriptions/{subscription-key}/cancel";

  // RESOURCE OPERATIONS
  public static final String POST_INVOICE_COLLECT = "/operations/invoice-collect";

  // RESOURCE USAGE API
  public static final String POST_USAGE = "/usage";
}
