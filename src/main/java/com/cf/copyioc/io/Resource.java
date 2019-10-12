package com.cf.copyioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * resource是spirng内部定位资源的接口
 */
public interface Resource {

    InputStream getInputStream() throws IOException;

}
