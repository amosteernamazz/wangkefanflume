package com.wangkefan.flume;


/**
 * Transaction interface isolate the sink,channel,source and the user operations.
 */
public interface Transaction {

    enum TransactionState { Started, Committed, RolledBack, Closed}

    void begin();

    void commit();

    void rollback();

    void close();
}
