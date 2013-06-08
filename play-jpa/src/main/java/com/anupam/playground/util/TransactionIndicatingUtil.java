package com.anupam.playground.util;

public class TransactionIndicatingUtil {
    private final static String TSM_CLASSNAME = "org.springframework.transaction.support.TransactionSynchronizationManager";

    public static String getTransactionStatus(boolean verbose) 
    {
        String status = null;

        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) 
           {
                Class tsmClass = contextClassLoader.loadClass(TSM_CLASSNAME);
                Boolean isActive = (Boolean) tsmClass.getMethod("isActualTransactionActive", null).invoke(null, null);
                if (!verbose) {
                    status = (isActive) ? "[+] " : "[-] ";
                } 
               else {
                    String transactionName = (String) tsmClass.getMethod("getCurrentTransactionName", null).invoke(null, null);
                    status = (isActive) ? "[" + transactionName + "] " : "[no transaction] ";
                }            
         }           
         else 
        {
                status = (verbose) ? "[ccl unavailable] " : "[x ]";
            }
        } catch (Exception e) {
            status = (verbose) ? "[spring unavailable] " : "[x ]";
        } 
       return status;
	}
 }

