package com.tan.example.dto;

import com.tan.example.dto.shared.AbstractGenericType;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Enterprise extends AbstractGenericType {
  public String id;
  public String name;
  public String webPage;
}
