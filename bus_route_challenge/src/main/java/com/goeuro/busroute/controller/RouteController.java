package com.goeuro.busroute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goeuro.busroute.model.RouteResponse;
import com.goeuro.busroute.service.IBusRouteService;

/**
 * Simple rest controller.
 * 
 * @author Shankar
 *
 */
@RestController
public class RouteController {

	@Autowired
	private IBusRouteService busRouteService;

	/**
	 * Check if a route exists directly between the departing station and the
	 * arrivaing station.
	 * 
	 * @return {@code RouteResponse} with value direct as true if route exist
	 */
	@RequestMapping(value = "/direct", method = RequestMethod.GET)
	public RouteResponse direct(@RequestParam(value = "dep_sid") int dep_sid,
			@RequestParam(value = "arr_sid") int arr_sid) {
		boolean direct = busRouteService.isDirect(dep_sid, arr_sid);
		return new RouteResponse(dep_sid, arr_sid, direct);
	}
}
