package com.tan.example.resource;

import com.tan.example.dto.DetailEnterprise;
import com.tan.example.dto.Enterprise;
import com.tan.example.dto.shared.AbstractGenericType;
import com.tan.example.service.impl.EnterpriseService;
import org.apache.commons.collections4.CollectionUtils;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Objects;

@Path(EnterpriseResource.RESOURCE_PATH)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EnterpriseResource extends AbstractGenericType {

  public static final String RESOURCE_PATH = "/enterprise";

  @Inject
  EnterpriseService enterpriseService;

  @POST
  public Response createEnterprise(@Valid Enterprise enterprise, @Context UriInfo uriInfo) {
    enterprise = this.enterpriseService.createEnterprise(enterprise);
    return Response.created(genericUriBuilder(enterprise.id, uriInfo).build()).entity(enterprise).build();
  }

  @GET
  public Response getAllEnterprises() {
    final List<Enterprise> enterpriseList = this.enterpriseService.findAllEnterprises();
    if(CollectionUtils.isNotEmpty(enterpriseList))
      return Response.ok(enterpriseList).build();
    else
      return Response.noContent().build();
  }

  @GET
  @Path("/{id}")
  public Response getEnterprise(@PathParam("id") String id) {
    if(Objects.nonNull(id)) {
      final Enterprise enterprise = this.enterpriseService.findEnterpriseById(id);
      if (Objects.nonNull(enterprise))
        return Response.ok(enterprise).build();
      else
        return Response.noContent().build();
    }

    return Response.status(Response.Status.BAD_REQUEST).build();
  }

  @POST
  @Path("/detailEnterprise")
  public Response createDetailEnterprise(@Valid DetailEnterprise detailEnterprise, @Context UriInfo uriInfo) {
    detailEnterprise = this.enterpriseService.createDetailEnterprise(detailEnterprise);
    return Response.created(genericUriBuilder(detailEnterprise.id, uriInfo).build()).entity(detailEnterprise).build();
  }
}
