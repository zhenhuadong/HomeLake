package com.zhenhua.homelake.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class StringBufferFactory extends BasePooledObjectFactory<StringBuffer> {

	@Override
	public StringBuffer create() throws Exception {
		return new StringBuffer();
	}

	@Override
	public PooledObject<StringBuffer> wrap(StringBuffer buf) {
		return new DefaultPooledObject<StringBuffer>(buf);
	}

	/**
	 * When an object is returned to the pool, clear the buffer
	 */
    @Override
    public void passivateObject(PooledObject<StringBuffer> pooledObject) {
    	pooledObject.getObject().setLength(0);
    }

}

