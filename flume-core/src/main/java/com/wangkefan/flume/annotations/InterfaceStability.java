package com.wangkefan.flume.annotations;


import java.lang.annotation.Documented;

/**
 * Annotations to inform users of how much to rely on a particular package, class or method no changing over time
 */

@InterfaceAudience.Public
@InterfaceStability.Evolving
public class InterfaceStability {

    @Documented
    public @interface Stable{};

    @Documented
    public @interface Evolving{};

    @Documented
    public @interface  Unstable{};
}
