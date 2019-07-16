package com.cl.common.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import reactor.util.annotation.Nullable;

public class RoutingDataSource extends AbstractRoutingDataSource{
	
	@Nullable
	@Override
	protected Object determineCurrentLookupKey() {
		return DBHandler.get();
	}
	
}
