package com.franklin.mydubbo.framework.protocol;

import com.franklin.mydubbo.framework.Invocation;
import com.franklin.mydubbo.framework.URL;

/**
 * @author Kirby
 * @date 2019/9/7 0007 15:27
 */
public interface Protocol {

    void start(URL url);

    Object send(URL url,Invocation invocation);
}
