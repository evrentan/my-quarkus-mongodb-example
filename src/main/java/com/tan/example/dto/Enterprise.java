package com.tan.example.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Enterprise {
  public String id;
  public String name;
  public String webPage;
}
