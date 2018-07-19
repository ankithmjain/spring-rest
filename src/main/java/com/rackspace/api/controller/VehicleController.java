package com.rackspace.api.controller;

import java.util.List;

import com.rackspace.api.constants.URI;
import com.rackspace.api.entity.Vehicle;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rackspace.api.service.VehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.VEHICLES)
@Api(tags = "vehicles")
public class VehicleController {

	private VehicleService service;

	public VehicleController(VehicleService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
//	@ApiOperation(value = "Find All Users", notes = "Returns a list of users in the app")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
//			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Vehicle> findAll() {
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.ID)
//	@ApiOperation(value = "Find Vehicle by Id", notes = "Returns a user by id if it exists in the app")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
//			@ApiResponse(code = 404, message = "Not Found"),
//			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Vehicle findOne(@PathVariable("id") String id) {
		return service.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
//	@ApiOperation(value = "Create Vehicle", notes = "Creates a vehicle in the app with unique email")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
//			@ApiResponse(code = 400, message = "Bad Request"),
//			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Vehicle create(@RequestBody Vehicle vehicle) {
		return service.create(vehicle);
	}

	@RequestMapping(method = RequestMethod.PUT, value = URI.ID)
//	@ApiOperation(value = "Update Vehicle", notes = "Updates an existing vehicle")
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
//			@ApiResponse(code = 404, message = "Not Found"),
//			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public Vehicle update(@PathVariable("id") String id, @RequestBody Vehicle vehicle) {
		return service.update(id, vehicle);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = URI.ID)
//	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
//			@ApiResponse(code = 404, message = "Not Found"),
//			@ApiResponse(code = 500, message = "Internal Server Error"), })
//	@ApiOperation(value = "Delete Vehicle", notes = "Deletes an existing user")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
}