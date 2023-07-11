package com.hubspot.jackson.datatype.protobuf.builtin.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.protobuf.Descriptors.FieldDescriptor;
import com.google.protobuf.Struct;
import com.hubspot.jackson.datatype.protobuf.ProtobufJacksonConfig;
import com.hubspot.jackson.datatype.protobuf.ProtobufSerializer;
import java.io.IOException;

public class StructSerializer extends ProtobufSerializer<Struct> {
  private static final FieldDescriptor FIELDS_FIELD = Struct.getDescriptor().findFieldByName("fields");

  @Deprecated
  public StructSerializer() {
    this(ProtobufJacksonConfig.getDefaultInstance());
  }

  public StructSerializer(ProtobufJacksonConfig config) {
    super(Struct.class, config);
  }

  @Override
  public void serialize(
          Struct struct,
          JsonGenerator generator,
          SerializerProvider serializerProvider
  ) throws IOException {
    writeMap(FIELDS_FIELD, struct.getField(FIELDS_FIELD), generator, serializerProvider);
  }
}
