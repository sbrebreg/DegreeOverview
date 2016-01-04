package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import model.Result;

@Path("results")
// Connection to Agility Persistence plugin
public class ResultService {
	private static ArrayList<Result> resultList = new ArrayList<Result>();

	@PUT
	// Edit data (ID is transmitted)
	@Path("{id:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Result update(@PathParam("id") Long id,
			MultivaluedMap<String, String> params) {

		System.out.println("update");

		Result result = new Result(params.getFirst("semester"),
				params.getFirst("singleGrades"),
				params.getFirst("aggregatedGrades"),
				params.getFirst("averageMean"),
				params.getFirst("averageMedian"), params.getFirst("course"));
		result.setId(id);
		for (int i = 0; i < resultList.size(); i++) {
			Result r = resultList.get(i);
			if (r.getId() == result.getId()) {
				resultList.set(i, result); // update
				break;
			}
		}
		return result;
	}

	@POST
	// Add data (if no ID is transmitted -> new result)
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes("application/x-www-form-urlencoded")
	public Result create(MultivaluedMap<String, String> params) {

		System.out.println("create");

		Result result = new Result(params.getFirst("semester"),
				params.getFirst("singleGrades"),
				params.getFirst("aggregatedGrades"),
				params.getFirst("averageMean"),
				params.getFirst("averageMedian"), params.getFirst("course"));

		// Simulation of the Id, will be generated later by DB
		long maxId = 0;
		for (Result currentResult : resultList) {
			if (maxId < currentResult.getId()) {
				maxId = currentResult.getId();
			}
		}
		result.setId(maxId + 1);

		resultList.add(result);
		return result;
	}

	@GET
	// Read data: single result
	@Path("{id:[0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Result load(@PathParam("id") Long id) {
		System.out.println("load");
		Result result = null; // new object of Result, empty
		for (Result r : resultList) {
			if (r.getId() == id) {
				result = r;
			}
		}
		return result;
	}

	@GET
	// Read data: resultList
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Result> getAll() {
		System.out.println("getAll");
		return resultList;
	}

	@DELETE
	// Delete data
	@Path("{id:[0-9]*}")
	public void delete(@PathParam("id") Long id) {
		System.out.println("delete");
		for (int i = 0; i < resultList.size(); i++) {
			Result r = resultList.get(i);
			if (r.getId() == id) {
				resultList.remove(i);
				break;
			}
		}
	}

}
