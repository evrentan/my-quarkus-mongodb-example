package com.tan.example.resource;

import com.tan.example.entity.EnterpriseEntity;
import com.tan.example.service.EnterpriseService;
import org.apache.commons.collections4.CollectionUtils;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Objects;

@Path("/enterprise")
public class EnterpriseResource {

  private static final Logger logger = Logger.getLogger(EnterpriseResource.class);

  @Inject
  EnterpriseService enterpriseService;


  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createEnterprise(@Valid EnterpriseEntity enterpriseEntity, @Context UriInfo uriInfo) {
    enterpriseEntity = enterpriseService.createEnterprise(enterpriseEntity);
    UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(enterpriseEntity.id.toString());
    logger.info("New hero created with URI " + builder.build().toString());
    return Response.created(builder.build()).build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllEnterprises() {
    final List<EnterpriseEntity> enterpriseEntityList = enterpriseService.findAllEnterprises();
    if(CollectionUtils.isNotEmpty(enterpriseEntityList))
      return Response.ok(enterpriseEntityList).build();
    else
      return Response.noContent().build();
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{id}")
  public Response getEnterprise(@PathParam("id") String id) {
    if(Objects.nonNull(id)) {
      final EnterpriseEntity enterpriseEntity = enterpriseService.findEnterpriseById(id);
      if (Objects.nonNull(enterpriseEntity))
        return Response.ok(enterpriseEntity).build();
      else
        return Response.noContent().build();
    }

    return Response.status(Response.Status.BAD_REQUEST).build();
  }

}
