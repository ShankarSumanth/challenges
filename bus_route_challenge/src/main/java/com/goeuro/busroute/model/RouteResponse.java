package com.goeuro.busroute.model;

/**
 * Response representation of a route
 * @author Shankar
 *
 */
public class RouteResponse {
	
	// departure station id
	private final int dep_sid;
	
	// arrival station id
	private final int arr_sid;
	
	// value represents if a direct route exists or not
	private final boolean direct_bus_route;

	public RouteResponse(int dep_sid, int arr_sid, boolean direct_bus_route) {
		super();
		this.dep_sid = dep_sid;
		this.arr_sid = arr_sid;
		this.direct_bus_route = direct_bus_route;
	}

	public int getDep_sid() {
		return dep_sid;
	}

	public int getArr_sid() {
		return arr_sid;
	}

	public boolean isDirect_bus_route() {
		return direct_bus_route;
	}
	
	

}
