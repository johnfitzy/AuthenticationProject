package ws;


import ws.annotations.ClientAuthMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Path("/v1")
public class Resource {


    @GET
    @Path("/resource")
    @ClientAuthMapper
    public Response printMessage() {
        return Response.status(200).entity("RESOURCE!!!!!").build();
    }


    @GET
    @Path("/test")
    public Response test() {
        return Response.status(200).entity("No filter").build();
    }

}
