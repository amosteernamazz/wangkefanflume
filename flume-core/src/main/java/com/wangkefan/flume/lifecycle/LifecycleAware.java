package com.wangkefan.flume.lifecycle;

/**
 * LifecycleAware interface represents service lifesycle.
 */

public interface LifecycleAware {


    /**
     * <p>
     *     Start a service.
     * </p>
     */
    public void start();

    /**
     * <p>
     *     Stop a service.
     * </p>
     */
    public void stop();

    /**
     * <p>
     *     Return lifecycle status.
     * </p>
     */
    public LifecycleState getLifecycleState();
}
