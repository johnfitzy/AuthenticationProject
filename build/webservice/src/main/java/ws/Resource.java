package ws;


import ws.annotations.ClientAuthMapper;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Path("/v1/resource/")
public class Resource {


    @GET
    @Path("/one")
    @ClientAuthMapper
    public Response resourceOne() {
        return Response.status(200).entity("Resource one").build();
    }

    @GET
    @Path("/two")
    public Response resourceTwo() {
        return Response.status(200).entity("Resource two").build();
    }



    @GET
    @Path("/open")
    public Response open() {
        return Response.status(200).entity("Open resource").build();
    }

}
