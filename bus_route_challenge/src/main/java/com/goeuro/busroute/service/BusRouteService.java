package com.goeuro.busroute.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goeuro.busroute.dao.BusRouteRepository;
import com.goeuro.busroute.dao.BusStationRepository;
import com.goeuro.busroute.model.BusRoute;

/**
 * Default Implementation of the {@code IBusRouteService}
 * 
 * @author Shankar
 *
 */
@Service
public class BusRouteService implements IBusRouteService {

	private BusStationRepository stationRepo;

	private BusRouteRepository routeRepo;

	@Autowired
	public BusRouteService(BusStationRepository stationRep, BusRouteRepository routeRepo) {
		this.stationRepo = stationRep;
		this.routeRepo = routeRepo;
	}

	@Override
	public boolean isDirect(Integer dep_sid, Integer arr_sid) {

		if (dep_sid == null || arr_sid == null || dep_sid.equals(arr_sid))
			return false;

		if (!stationRepo.isStation(dep_sid) || !stationRepo.isStation(arr_sid))
			return false;

		List<BusRoute> routes = stationRepo.getRoutesFor(dep_sid);

		if (routes == null || routes.isEmpty())
			return false;

		// assuming that if a route exists then there has to be atleast two
		// stations.
		return routes.stream().anyMatch(route -> {
			return routeRepo.hasStation(route, arr_sid);
		});
	}
}
