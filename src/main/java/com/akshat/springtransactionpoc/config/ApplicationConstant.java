package com.akshat.springtransactionpoc.config;

public final class ApplicationConstant {

  private ApplicationConstant() {
  }

  public static final String ACCOUNT = "account";
  public static final String AMOUNT = "amount";
  public static final String STATUS = "status";

  public static final String LOG_BEFORE_TEMPLATE = "[%s] %s before | %s balance=%.2f%n";
  public static final String LOG_AFTER_TEMPLATE = "[%s] %s after  | %s balance=%.2f%n";
  public static final String LOG_TX_ACTIVE_TEMPLATE = "[%s] %s txActive=%s%n";

  public static final String SERVICE_TRANSACTION = "TransactionService";
  public static final String SERVICE_REQUIRED = "RequiredService";
  public static final String SERVICE_REQUIRES_NEW = "RequiresNewService";
  public static final String SERVICE_SUPPORTS = "SupportsService";
  public static final String SERVICE_NOT_SUPPORTED = "NotSupportedService";
  public static final String SERVICE_MANDATORY = "MandatoryService";
  public static final String SERVICE_NEVER = "NeverService";
  public static final String SERVICE_NESTED = "NestedService";

  public static final String PROPAGATION_REQUIRED = "REQUIRED";
  public static final String PROPAGATION_REQUIRES_NEW = "REQUIRES_NEW";
  public static final String PROPAGATION_SUPPORTS = "SUPPORTS";
  public static final String PROPAGATION_NOT_SUPPORTED = "NOT_SUPPORTED";
  public static final String PROPAGATION_MANDATORY = "MANDATORY";
  public static final String PROPAGATION_NEVER = "NEVER";
  public static final String PROPAGATION_NESTED = "NESTED";

  public static final Long ACCOUNT_ID_ONE = 1L;
  public static final Long ACCOUNT_ID_TWO = 2L;
  public static final Long ACCOUNT_ID_THREE = 3L;

  public static final double DELTA_REQUIRED_OUTER = 100.0;
  public static final double DELTA_REQUIRED_INNER = 200.0;
  public static final double DELTA_REQUIRES_NEW_OUTER = 50.0;
  public static final double DELTA_REQUIRES_NEW_INNER = 500.0;
  public static final double DELTA_SUPPORTS = 70.0;
  public static final double DELTA_NOT_SUPPORTED_OUTER = 120.0;
  public static final double DELTA_NOT_SUPPORTED_INNER = 220.0;
  public static final double DELTA_MANDATORY = 10.0;
  public static final double DELTA_NEVER_OUTER = 30.0;
  public static final double DELTA_NEVER_INNER = 40.0;
  public static final double DELTA_NESTED_OUTER = 300.0;
  public static final double DELTA_NESTED_INNER = 400.0;
  public static final double DELTA_NESTED_OUTER_AFTER = 500.0;

  public static final String LABEL_REQUIRED_OUTER = "requiredScenario outer";
  public static final String LABEL_REQUIRES_NEW_OUTER = "requiresNewScenario outer";
  public static final String LABEL_NOT_SUPPORTED_OUTER = "notSupportedScenario outer";
  public static final String LABEL_NEVER_OUTER = "neverScenario outer";
  public static final String LABEL_NESTED_OUTER = "nestedScenario outer";
  public static final String LABEL_NESTED_OUTER_AFTER = "nestedScenario outer after nested rollback";

  public static final String START_REQUIRED = "\n=== REQUIRED scenario start ===";
  public static final String START_REQUIRES_NEW = "\n=== REQUIRES_NEW scenario start ===";
  public static final String START_SUPPORTS = "\n=== SUPPORTS scenario start ===";
  public static final String START_NOT_SUPPORTED = "\n=== NOT_SUPPORTED scenario start ===";
  public static final String START_MANDATORY = "\n=== MANDATORY scenario start ===";
  public static final String START_NEVER = "\n=== NEVER scenario start ===";
  public static final String START_NESTED = "\n=== NESTED scenario start ===";

  public static final String ERROR_REQUIRED = "Intentional exception from REQUIRED";
  public static final String ERROR_REQUIRES_NEW_OUTER = "Intentional outer exception after REQUIRES_NEW";
  public static final String ERROR_SUPPORTS = "Intentional exception after SUPPORTS";
  public static final String ERROR_NOT_SUPPORTED_OUTER = "Intentional exception after NOT_SUPPORTED";
  public static final String ERROR_NESTED = "Intentional exception from NESTED";

  public static final String LOG_REQUIRED_NOT_REACHED = "[TransactionService] This line is not reached due to exception.";
  public static final String LOG_REQUIRES_NEW_OUTER_FAIL = "[TransactionService] Throwing outer exception -> only outer should roll back.";
  public static final String LOG_SUPPORTS_OUTER_FAIL = "[TransactionService] Throwing after SUPPORTS call -> prior write already committed.";
  public static final String LOG_NOT_SUPPORTED_OUTER_FAIL = "[TransactionService] Throwing outer exception -> outer rollback expected.";
  public static final String LOG_NESTED_CAUGHT = "[TransactionService] Caught nested exception: %s";
  public static final String LOG_NESTED_CONTINUE = "[TransactionService] Outer transaction continues after nested rollback.";
  public static final String LOG_NESTED_COMPLETE = "[TransactionService] NESTED scenario completed -> outer commit expected.";

  public static final String LOG_REQUIRED_EXCEPTION = "[RequiredService] Exception triggered -> rollback expected for outer+inner work.";
  public static final String LOG_NESTED_EXCEPTION = "[NestedService] Exception triggered -> nested rollback to savepoint expected.";

  public static final String MAIL_SENT_PREFIX = "MAIL SENT: ";
  public static final String MAIL_TX_LOG_TEMPLATE = "[MAIL] %s | txActive=%s | txName=%s%n";
  public static final String MAIL_METHOD_REQUIRED = "sendMailRequired";
  public static final String MAIL_METHOD_REQUIRES_NEW = "sendMailRequiresNew";
  public static final String MAIL_METHOD_NOT_SUPPORTED = "sendMailNotSupported";

  public static final String MAIL_MSG_REQUIRED_FLOW = "Required flow executed for account %s";
  public static final String MAIL_MSG_REQUIRES_NEW_FLOW = "RequiresNew flow committed for account %s";
  public static final String MAIL_MSG_NOT_SUPPORTED_FLOW = "NotSupported flow executed for account %s";
  public static final String MAIL_MSG_SUPPORTS_COMPLETE = "SUPPORTS scenario completed without explicit transaction";



  public static final String SCENARIO = "scenario";
  public static final String MESSAGE = "message";
  public static final String ACCOUNTS = "accounts";
  public static final String ERROR = "error";
  public static final String SUCCESS = "SUCCESS";
  public static final String FAILED = "FAILED (expected for rollback demo)";
  public static final String MESSAGE_SUCCESS = "Scenario completed without exception.";

  public static final String UNKNOWN_SCENARIO_FORMAT = "Unknown scenario: %s";


  public static final String APP_STARTED_MESSAGE = "Application started successfully!";
}

