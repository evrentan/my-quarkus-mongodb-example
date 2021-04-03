package com.tan.example.dto.shared;

import com.tan.example.resource.EnterpriseResource;
import org.jboss.logging.Logger;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import java.io.Serializable;

public abstract class AbstractGenericType implements Serializable {
  protected static final Logger LOGGER = Logger.getLogger(EnterpriseResource.class);

  public UriBuilder genericUriBuilder(String id, UriInfo uriInfo) {
    final UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(id);
    LOGGER.info("New enterprise created with URI " + uriBuilder.build().toString());
    return uriBuilder;
  }
}
