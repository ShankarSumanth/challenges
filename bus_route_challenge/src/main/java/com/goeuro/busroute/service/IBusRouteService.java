package com.goeuro.busroute.service;

/**
 * Provides services for bus routes.
 * 
 * @author Shankar
 *
 */
public interface IBusRouteService {

	/**
	 * Checks if a direct route between the given stations exists.
	 * @param dep_sid departing station id
	 * @param arr_sid arriving station id
	 * @return {@code true} if direct route exists else {@code false}.
	 */
	public boolean isDirect(Integer dep_sid, Integer arr_sid);
}
