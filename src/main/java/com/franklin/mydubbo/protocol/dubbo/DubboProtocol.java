package com.franklin.mydubbo.protocol.dubbo;

import com.franklin.mydubbo.framework.Invocation;
import com.franklin.mydubbo.framework.protocol.Protocol;
import com.franklin.mydubbo.framework.URL;

/**
 * @author Kirby
 * @date 2019/9/7 0007 15:28
 */
public class DubboProtocol implements Protocol {
    @Override
    public void start(URL url) {

    }

    @Override
    public Object send(URL url, Invocation invocation) {
        return null;
    }
}
