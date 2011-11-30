package com.googlecode.objectify.impl.cmd;

import java.util.List;

import com.google.appengine.api.datastore.QueryResultIterable;
import com.google.appengine.api.datastore.QueryResultIterator;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.cmd.QueryExecute;
import com.googlecode.objectify.cmd.QueryKeys;
import com.googlecode.objectify.util.ResultProxy;

/**
 * Implementation of QueryKeys.
 *
 * @author Jeff Schnitzer <jeff@infohazard.org>
 */
class QueryKeysImpl<T> implements QueryKeys<T>, Cloneable
{
	QueryImpl<T> impl;
	
	/** */
	QueryKeysImpl(QueryImpl<T> query) {
		this.impl = query;
	}

	@Override
	public Ref<T> first() {
		return null;
	}

	@Override
	public QueryResultIterable<Key<T>> iterable() {
		return impl.keysIterable();
	}

	@Override
	public List<Key<T>> list() {
		return ResultProxy.makeAsyncList(impl.chunk(Integer.MAX_VALUE).keysIterable());
	}

	@Override
	public QueryResultIterator<Key<T>> iterator() {
		return iterable().iterator();
	}

	@Override
	public QueryExecute<T> asEntities() {
		return null;
	}
	
}
